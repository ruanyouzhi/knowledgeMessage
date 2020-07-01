package com.km.knowledgemessage.utils;

import com.km.knowledgemessage.Mapper.*;
import com.km.knowledgemessage.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class SetCardNumService {
    @Autowired
    public CardNumMapper cardNumMapper;
    @Autowired
    public UserLikeMapper userLikeMappser;
    @Autowired
    public CardNumExtMapper cardNumExtMapper;
    @Autowired
    public KnowledgeBaseMapper knowledgeBaseMapper;
    @Autowired
    public CardMapper cardMapper;
    public Long upLikeNum(long userId,long cardId){
        UserLikeExample likeExample = new UserLikeExample();
        likeExample.createCriteria()
                .andCardIdEqualTo(cardId)
                .andUserIdEqualTo(userId);
        long likeNum =  userLikeMappser.countByExample(likeExample);
        if(likeNum==0){
            UserLike like=new UserLike();
            like.setCardId(cardId);
            like.setUserId(userId);
            userLikeMappser.insertSelective(like);
            CardNum cardNum = cardNumMapper.selectByPrimaryKey(cardId);
            cardNum.setLikeNum(cardNum.getLikeNum()+1);
            cardNumMapper.updateByPrimaryKeySelective(cardNum);
            return cardNum.getLikeNum();
        }else {
            UserLikeExample example = new UserLikeExample();
            example.createCriteria()
                    .andCardIdEqualTo(cardId)
                    .andUserIdEqualTo(userId);
            userLikeMappser.deleteByExample(example);
            CardNum cardNum = cardNumMapper.selectByPrimaryKey(cardId);
            cardNum.setLikeNum(cardNum.getLikeNum()-1);
            cardNumMapper.updateByPrimaryKeySelective(cardNum);
            return Long.valueOf(-1);
        }
    }
    public Long upCollect(long userId,long cardId){
        KnowledgeBaseExample example = new KnowledgeBaseExample();
        example.createCriteria()
                .andUserIdEqualTo(userId)
                .andCardIdEqualTo(cardId);
        long count = knowledgeBaseMapper.countByExample(example);
        Card card = cardMapper.selectByPrimaryKey(cardId);
        if(card.getCreatorId()==userId)return Long.valueOf(0);
        if(count==1){
            KnowledgeBaseExample example1 = new KnowledgeBaseExample();
            example1.createCriteria()
                    .andCardIdEqualTo(cardId)
                    .andUserIdEqualTo(userId);
            int i = knowledgeBaseMapper.deleteByExample(example1);
            CardNumExample cardExample = new CardNumExample();
            cardExample.createCriteria()
                    .andCardIdEqualTo(cardId);
            List<CardNum> cardNums = cardNumMapper.selectByExample(cardExample);
            cardNums.get(0).setCollectNum(cardNums.get(0).getCommentNum()-1);
            cardNumMapper.updateByPrimaryKeySelective(cardNums.get(0));
            return Long.valueOf(-1);
        }else {
            KnowledgeBase knowledgeBase=new KnowledgeBase();
            knowledgeBase.setCardName(card.getTitle());
            knowledgeBase.setGmtCreate(System.currentTimeMillis());
            knowledgeBase.setGmtModified(knowledgeBase.getGmtCreate());
            knowledgeBase.setUserId(userId);
            knowledgeBase.setCardId(card.getId());
            knowledgeBase.setReviewTime(card.getGmtCreate());
            knowledgeBase.setLastReviewTime(card.getGmtCreate());
            knowledgeBase.setReviewNum((long) 0);
            knowledgeBase.setCreatorId(card.getCreatorId());
            knowledgeBase.setCardDescription(card.getCardDescription());
            knowledgeBaseMapper.insert(knowledgeBase);
            CardNumExample example1 = new CardNumExample();
            example1.createCriteria().andCardIdEqualTo(cardId);
            List<CardNum> cardNums=  cardNumMapper.selectByExample(example1);
            cardNums.get(0).setCollectNum(cardNums.get(0).getCommentNum()+1);
            cardNumMapper.updateByPrimaryKeySelective(cardNums.get(0));
            return cardNums.get(0).getCommentNum();
        }
    }

}
