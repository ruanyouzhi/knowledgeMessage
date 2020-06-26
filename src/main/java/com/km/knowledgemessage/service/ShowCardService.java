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
public class ShowCardService {
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

    public String showCard(Long cardId, Long userId) { // 显示卡片内容
        //card
        // 传入当前卡片的id, 默认显示卡片详情为点击卡片，即卡片已经存在
        Card card = cardMapper.selectByPrimaryKey(cardId);
        if(card.getIsPublic()){
            return card.getCardText();
        }
        else {
            if (card.getUserId().equals(userId))
                return card.getCardText();
            else {
                return "Invalid Card or User!";
            }
        }
    }
    public String showCardScr(Long cardId, Long userId) {      // 显示卡片图片源
        //card
        Card card = cardMapper.selectByPrimaryKey(cardId);
        if(card.getIsPublic()){
            return card.getCardText();
        }
        else {
            if (card.getUserId().equals(userId))
                return card.getImgSrc();
            else {
                return "Invalid Card or User!";
            }
        }
    }
}
