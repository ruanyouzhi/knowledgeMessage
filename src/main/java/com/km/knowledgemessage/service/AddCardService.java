package com.km.knowledgemessage.service;

import com.km.knowledgemessage.Mapper.*;
import com.km.knowledgemessage.Model.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AddCardService {
    @Autowired
    private CardMapper cardMapper;
    @Autowired
    private CardExtMapper cardExtMapper;
    @Autowired
    private PublicCardMapper publicCardMapper;
    @Autowired
    private LabelBaseMapper labelBaseMapper;
    @Autowired
    private KnowledgeBaseMapper knowledgeBaseMapper;
    @Autowired
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
        knowledgeBase.setUserId(card.getUserId());
        knowledgeBase.setCardId(card.getId());
        knowledgeBase.setReviewTime(card.getGmtCreate());
        knowledgeBase.setReviewNum((long) 0);
        knowledgeBase.setCreatorId(card.getCreatorId());
        knowledgeBase.setCardDescription(card.getCardDescription());
        knowledgeBaseMapper.insert(knowledgeBase);
        CardNum cardNum=new CardNum();
        cardNum.setCardId(card.getId());
        cardNumMapper.insert(cardNum);
        //插入label库
        String []labels= StringUtils.split(card.getLabelName(),"，|,");
        LabelBase label=new LabelBase();
        label.setUserId(card.getUserId());
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
}
