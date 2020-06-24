package com.km.knowledgemessage.service;

import com.km.knowledgemessage.Mapper.*;
import com.km.knowledgemessage.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.Date;
import java.util.List;

@Service
public class CardService {
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
    public long addCard(Card card) {
        card.setGmtCreate(System.currentTimeMillis());
        card.setGmtModified(card.getGmtCreate());
        cardExtMapper.insert(card);
        KnowledgeBase knowledgeBase =new KnowledgeBase();
        knowledgeBase.setCardName(card.getTitle());
        knowledgeBase.setGmtCreate(card.getGmtCreate());
        knowledgeBase.setGmtModified(card.getGmtCreate());
        knowledgeBase.setUserId(card.getUserId());
        knowledgeBase.setCardId(card.getId());
        knowledgeBase.setReviewTime(card.getGmtCreate());
        knowledgeBase.setReviewNum((long) 0);
        knowledgeBaseMapper.insert(knowledgeBase);
        LabelBaseExample labelBaseExample=new LabelBaseExample();
        labelBaseExample.createCriteria().andUserIdEqualTo(card.getUserId());
        List<LabelBase> labelBases = labelBaseMapper.selectByExample(labelBaseExample);
        if(labelBases.size()==0){
            LabelBase labelBase=new LabelBase();
            labelBase.setLabelName(card.getLabelName());
            labelBase.setUserId(card.getUserId());
            labelBaseMapper.insert(labelBase);
        }
        if (card.getIsPublic()==true){
            PublicCard publicCard=new PublicCard();
            publicCard.setGmtCreate(card.getGmtCreate());
            publicCard.setGmtModified(card.getGmtModified());
            publicCard.setCardId(card.getId());
            publicCardMapper.insert(publicCard);

        }
        return card.getId();
    }
}
