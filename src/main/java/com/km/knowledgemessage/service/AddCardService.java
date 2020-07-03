package com.km.knowledgemessage.service;

import com.km.knowledgemessage.Mapper.*;
import com.km.knowledgemessage.Model.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AddCardService {

    @Resource
    private CardMapper cardMapper;
    @Resource
    private CardExtMapper cardExtMapper;
    @Resource
    private PublicCardMapper publicCardMapper;
    @Resource
    private LabelBaseMapper labelBaseMapper;
    @Resource
    private KnowledgeBaseMapper knowledgeBaseMapper;
    @Resource
    private CardNumMapper cardNumMapper;

    public long addCard(Card card) {
        //card
        card.setGmtCreate(System.currentTimeMillis());
        card.setGmtModified(card.getGmtCreate());
        cardExtMapper.insert(card);
        //KnowledgeBase
        KnowledgeBase knowledgeBase =new KnowledgeBase();
        knowledgeBase.setCardName(card.getTitle());
        knowledgeBase.setGmtCreate(card.getGmtCreate());
        knowledgeBase.setGmtModified(card.getGmtCreate());
        knowledgeBase.setUserId(card.getCreatorId());
        knowledgeBase.setCardId(card.getId());
        knowledgeBase.setReviewTime(card.getGmtCreate());
        knowledgeBase.setLastReviewTime(System.currentTimeMillis());
        knowledgeBase.setReviewNum((long) 0);
        knowledgeBase.setCreatorId(card.getCreatorId());
        knowledgeBase.setCardDescription(card.getCardDescription());
        knowledgeBaseMapper.insert(knowledgeBase);
        CardNum cardNum=new CardNum();
        cardNum.setLikeNum((long) 0);
        cardNum.setCollectNum((long) 0);
        cardNum.setCommentNum((long) 0);
        cardNum.setCardId(card.getId());
        cardNumMapper.insert(cardNum);
        //插入label库
        String []labels= StringUtils.split(card.getLabelName(),"，|,");
        LabelBase label=new LabelBase();
        label.setUserId(card.getCreatorId());
        label.setCardId(card.getId());
        for ( String tag: labels) {
            label.setLabelName(tag);
            labelBaseMapper.insert(label);
        }
        //is_public
        if (card.getIsPublic()){
            PublicCard publicCard=new PublicCard();
            publicCard.setGmtCreate(card.getGmtCreate());
            publicCard.setGmtModified(card.getGmtModified());
            publicCard.setCardId(card.getId());
            publicCardMapper.insert(publicCard);

        }
        return card.getId();
    }

    public Card getCard(long cardId) {
        return cardMapper.selectByPrimaryKey(cardId);
    }

    public void upCard(Card card) {
        card.setGmtModified(System.currentTimeMillis());
        cardMapper.updateByPrimaryKeySelective(card);
        KnowledgeBase knowledgeBase=new KnowledgeBase();
        knowledgeBase.setCardId(card.getId());
        knowledgeBase.setCardName(card.getTitle());
        knowledgeBase.setCardDescription(card.getCardDescription());
        knowledgeBase.setGmtModified(card.getGmtModified());
        KnowledgeBaseExample example = new KnowledgeBaseExample();
        example.createCriteria().andUserIdEqualTo(card.getCreatorId())
                .andCardIdEqualTo(card.getId());
        knowledgeBaseMapper.updateByExampleSelective(knowledgeBase, example);
    }
}
