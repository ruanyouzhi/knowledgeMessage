package com.km.knowledgemessage.service;

import com.km.knowledgemessage.Mapper.*;
import com.km.knowledgemessage.Model.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class ShowCardService {
    @Resource
    private CardMapper cardMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private CardNumMapper cardNumMapper;

    public Card getCard(Long cardId){
        return cardMapper.selectByPrimaryKey(cardId);
    }

    public CardNum getCardNum(Long cardId){
        return cardNumMapper.selectByPrimaryKey(cardId);
    }
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
    public String showCardCreator(Long cardId) { // 显示创建者
        //card
        // 传入当前卡片的id, 默认显示卡片详情为点击卡片，即卡片已经存在
        Card card = cardMapper.selectByPrimaryKey(cardId);
        Long creatorId = card.getCreatorId();
        User user = userMapper.selectByPrimaryKey(creatorId);
        return user.getName();
    }

    public String showCardTitle(Long cardId, Long userId) { // 显示标题
        //card
        // 传入当前卡片的id, 默认显示卡片详情为点击卡片，即卡片已经存在
        Card card = cardMapper.selectByPrimaryKey(cardId);
        return card.getTitle();
    }
    public String showCardDescrip(Long cardId, Long userId) { // 显示卡片描述
        //card
        // 传入当前卡片的id, 默认显示卡片详情为点击卡片，即卡片已经存在
        Card card = cardMapper.selectByPrimaryKey(cardId);

        return card.getCardDescription();
    }
    public String showCardLable(Long cardId, Long userId) { // 显示卡片标签
        //card
        // 传入当前卡片的id, 默认显示卡片详情为点击卡片，即卡片已经存在
        Card card = cardMapper.selectByPrimaryKey(cardId);
        return card.getLabelName();
    }
}
