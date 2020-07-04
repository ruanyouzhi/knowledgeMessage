package com.km.knowledgemessage.service;

import com.km.knowledgemessage.Mapper.CardMapper;
import com.km.knowledgemessage.Mapper.CardNumMapper;
import com.km.knowledgemessage.Mapper.KnowledgeBaseMapper;
import com.km.knowledgemessage.Mapper.UserMapper;
import com.km.knowledgemessage.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
        cardExample.createCriteria().andCardDescriptionLike(context);   // 搜索相似的描述
        //cardExample.createCriteria().andTitleGreaterThanOrEqualTo(context);
        List<Card> cards = cardMapper.selectByExample(cardExample);
        return cards;

    }


}
