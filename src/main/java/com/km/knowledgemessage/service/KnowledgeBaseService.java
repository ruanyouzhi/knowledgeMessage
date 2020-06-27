package com.km.knowledgemessage.service;

import com.km.knowledgemessage.Mapper.*;
import com.km.knowledgemessage.Model.*;
import com.km.knowledgemessage.dto.CardQueryDTO;
import com.km.knowledgemessage.dto.PaginationDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class KnowledgeBaseService {
    @Autowired
    private KnowledgeBaseExtMapper knowledgeBaseExtMapper;
    @Autowired
    private CardMapper cardMapper;
    @Autowired
    private CardNumMapper cardNumMapper;
    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private KnowledgeBaseMapper knowledgeBaseMapper;
    @Autowired
    private LabelBaseMapper labelBaseMapper;
    @Autowired
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
