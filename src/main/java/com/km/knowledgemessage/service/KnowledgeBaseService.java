package com.km.knowledgemessage.service;

import com.km.knowledgemessage.Mapper.*;
import com.km.knowledgemessage.Model.*;
import com.km.knowledgemessage.dto.CardQueryDTO;
import com.km.knowledgemessage.dto.PaginationDTO;
import com.km.knowledgemessage.dto.TimeLineDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.NewThreadAction;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class KnowledgeBaseService {
    @Resource
    private KnowledgeBaseExtMapper knowledgeBaseExtMapper;
    @Resource
    private CardMapper cardMapper;
    @Resource
    private CardNumMapper cardNumMapper;
    @Resource
    private CommentMapper commentMapper;

    @Resource
    private KnowledgeBaseMapper knowledgeBaseMapper;
    @Resource
    private LabelBaseMapper labelBaseMapper;
    @Resource
    private PublicCardMapper publicCardMapper;

    public PaginationDTO list(Integer userId, String search, Integer page, Integer size) {
        if(StringUtils.isNotBlank(search)){
            String []tags=StringUtils.split(search,' ');
            search= Arrays.stream(tags).collect(Collectors.joining("|"));
        }

        Integer totalPage;
        PaginationDTO<KnowledgeBase> pagination = new PaginationDTO<>();
        CardQueryDTO cardQueryDTO = new CardQueryDTO();
        cardQueryDTO.setSearch(search);
        cardQueryDTO.setUserId(userId);
        Integer totalCount=knowledgeBaseExtMapper.countBySearch(cardQueryDTO);
        totalPage=totalCount%size==0?(totalCount/size):(totalCount/size+1);
        if(page<1)page=1;
        if(page>totalPage)page=totalPage;
        pagination.setPagination(page,totalPage);
        Integer offset=size*(page-1);
        List<KnowledgeBase> knowledgeBaseList=new ArrayList<>();//?
        KnowledgeBaseExample example=new KnowledgeBaseExample();
        example.setOrderByClause("gmt_create desc");
        cardQueryDTO.setSize(size);
        cardQueryDTO.setPage(offset);
        knowledgeBaseList = knowledgeBaseExtMapper.selectBySearch(cardQueryDTO);

        pagination.setData(knowledgeBaseList);
        return pagination;
    }
    public List<TimeLineDTO> simpleList(Long userId) {
        KnowledgeBaseExample example=new KnowledgeBaseExample();
        example.setOrderByClause("gmt_create desc");
        example.createCriteria().andUserIdEqualTo(userId);
        List<KnowledgeBase> knowledgeBaseList = knowledgeBaseMapper.selectByExample(example);
        int i=0;
        List<TimeLineDTO> timeLineDTOList=new ArrayList<>();
        for (KnowledgeBase k :knowledgeBaseList) {
            if(k.getCardId()==null)break;
            TimeLineDTO timeLineDTO=new TimeLineDTO();
            CardNumExample cardNumExample = new CardNumExample();
            cardNumExample.createCriteria().andCardIdEqualTo(k.getCardId());
            List<CardNum> cardNums = cardNumMapper.selectByExample(cardNumExample);
            BeanUtils.copyProperties(k,timeLineDTO);
            timeLineDTO.setLikeNum(cardNums.get(0).getLikeNum());
            timeLineDTOList.add(timeLineDTO);
        }
        return timeLineDTOList;

    }

    public void delCard(long userId, long cardId,long creatorId) {
        KnowledgeBaseExample knowledgeBaseExample = new KnowledgeBaseExample();
        knowledgeBaseExample.createCriteria().andCardIdEqualTo(cardId).andUserIdEqualTo(userId);
        knowledgeBaseMapper.deleteByExample(knowledgeBaseExample);
        LabelBaseExample labelBaseExample = new LabelBaseExample();
        labelBaseExample.createCriteria().andCardIdEqualTo(cardId).andUserIdEqualTo(userId);
        labelBaseMapper.deleteByExample(labelBaseExample);

        if(creatorId!=userId){
            return;
        }else {
            CardExample cardExample = new CardExample();
            cardExample.createCriteria().andCreatorIdEqualTo(creatorId)
                    .andIdEqualTo(cardId);
            cardMapper.deleteByExample(cardExample);
            cardNumMapper.deleteByPrimaryKey(cardId);
            CommentExample commentExample = new CommentExample();
            commentExample.createCriteria().andCardIdEqualTo(cardId);
            commentMapper.deleteByExample(commentExample);
            publicCardMapper.deleteByPrimaryKey(cardId);
        }


    }
}
