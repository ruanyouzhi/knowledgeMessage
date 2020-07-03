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
public class CardReviewService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private CardMapper cardMapper;
    @Resource
    private KnowledgeBaseMapper knowledgeBaseMapper;

    int[] Ebbinghaus = {1, 2, 4, 7, 15};

    public User getUser(Long userId){
        return userMapper.selectByPrimaryKey(userId);
    }
    public KnowledgeBase getKnowledgeBase(Long userId){
        KnowledgeBaseExample knowledgeBaseExample = new KnowledgeBaseExample();
        knowledgeBaseExample.createCriteria().andUserIdEqualTo(userId);
        List<KnowledgeBase> knowledgeBases = knowledgeBaseMapper.selectByExample(knowledgeBaseExample);
        KnowledgeBase knowledgeBase = knowledgeBases.get(0);
        return knowledgeBase;
    }
    public List<KnowledgeBase> getReviewCards(User user) throws ParseException {
        KnowledgeBaseExample knowledgeBaseExample = new KnowledgeBaseExample();     // 知识库
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");   // 指定日期类型

        String dateStr = dateformat.format(System.currentTimeMillis());     // 获取当前时间
        Date date = dateformat.parse(dateStr);

        long time_low = date.getTime() ;
        long time_high = date.getTime() + 1000*60*60*24;    // 找到介于二者之间的。即当天的复习 卡片

        knowledgeBaseExample.createCriteria().andUserIdEqualTo(user.getId()).andReviewTimeBetween(time_low, time_high);    // 先找到用户的知识库
        List<KnowledgeBase> userKnowledgeBases = knowledgeBaseMapper.selectByExample(knowledgeBaseExample);

        return userKnowledgeBases;
    }

    public Card getReviewResult(Long knowledgeBaseId, int state) throws ParseException {
        // state = 1: 已会
        // state = 0： 提示

        KnowledgeBase knowledgeBase = knowledgeBaseMapper.selectByPrimaryKey(knowledgeBaseId);
        Card card = cardMapper.selectByPrimaryKey(knowledgeBase.getCardId());
        if (1 == state){
            knowledgeBase.setGmtModified(System.currentTimeMillis());
            knowledgeBase.setReviewNum(knowledgeBase.getReviewNum()+1);
            knowledgeBase.setLastReviewTime(System.currentTimeMillis());
            long time = System.currentTimeMillis() + 15 * 1000 * 60 * 60 * 24;  // 已经会了就最长周期复习一次
            knowledgeBase.setReviewTime(time);
            knowledgeBaseMapper.updateByPrimaryKey(knowledgeBase);  // 修改
        }
        else if(0 == state){
            knowledgeBase.setGmtModified(System.currentTimeMillis());
            knowledgeBase.setLastReviewTime(System.currentTimeMillis());
            long reviewTime;
            if(knowledgeBase.getReviewNum() < 5) {
                reviewTime = knowledgeBase.getLastReviewTime() + Ebbinghaus[(int) (knowledgeBase.getReviewNum() - 1)] * 1000 * 60 * 60 * 24;
            }
            else{ // 超过周期，默认15天复习一次
                reviewTime = knowledgeBase.getLastReviewTime() + 15 * 1000 * 60* 60 * 24;
            }

            knowledgeBase.setReviewTime(reviewTime);
            knowledgeBase.setReviewNum(knowledgeBase.getReviewNum() + 1);
            knowledgeBaseMapper.updateByPrimaryKey(knowledgeBase);
            return card;
        }
        return null;
    }
}
