package com.km.knowledgemessage.utils;

import com.km.knowledgemessage.Mapper.CardNumExtMapper;
import com.km.knowledgemessage.Mapper.CardNumMapper;
import com.km.knowledgemessage.Mapper.UserLikeMapper;
import com.km.knowledgemessage.Model.CardNum;
import com.km.knowledgemessage.Model.User;
import com.km.knowledgemessage.Model.UserLike;
import com.km.knowledgemessage.Model.UserLikeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetCardNumService {
    @Autowired
    public CardNumMapper cardNumMapper;
    @Autowired
    public UserLikeMapper userLikeMappser;
    @Autowired
    public CardNumExtMapper cardNumExtMapper;
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

}
