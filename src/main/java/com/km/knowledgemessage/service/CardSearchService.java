package com.km.knowledgemessage.service;

import com.km.knowledgemessage.Mapper.CardMapper;
import com.km.knowledgemessage.Mapper.CardNumMapper;
import com.km.knowledgemessage.Mapper.KnowledgeBaseMapper;
import com.km.knowledgemessage.Mapper.UserMapper;
import com.km.knowledgemessage.Model.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CardSearchService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private CardMapper cardMapper;
    @Resource
    private KnowledgeBaseMapper knowledgeBaseMapper;


    public List<Card> getSearchCard(String context) {
        CardExample cardExample = new CardExample();
        CardExample allcardExample = new CardExample();
        allcardExample.createCriteria().andTitleLike(context);
        CardExample.Criteria cardExample_cr = cardExample.createCriteria();
        CardExample.Criteria allcardExample_cr = allcardExample.createCriteria();
        if(StringUtils.isNotBlank(context)){
            //通配符%需要手动加上
            cardExample_cr.andCardDescriptionLike("%"+context+"%");
            allcardExample_cr.andTitleLike("%"+context+"%");
        }
        //cardExample.createCriteria().andCardDescriptionLike(context);   // 搜索相似的描述
        //cardExample.createCriteria().andTitleGreaterThanOrEqualTo(context);
        List<Card> cards = cardMapper.selectByExample(allcardExample);
        List<Card> cards1 = cardMapper.selectByExample(cardExample);
        cards.addAll(cards1);
        for(Card i:cards){
            User tempUser = new User();
            tempUser = userMapper.selectByPrimaryKey(i.getCreatorId());
            i.setImgSrc(tempUser.getAvatarUrl());
        }
        return cards;

    }


}
