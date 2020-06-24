package com.km.knowledgemessage.service;

import com.km.knowledgemessage.Mapper.CardExtMapper;
import com.km.knowledgemessage.Mapper.KnowledgeBaseExtMapper;
import com.km.knowledgemessage.Mapper.KnowledgeBaseMapper;
import com.km.knowledgemessage.Model.KnowledgeBase;
import com.km.knowledgemessage.Model.KnowledgeBaseExample;
import com.km.knowledgemessage.dto.CardQueryDTO;
import com.km.knowledgemessage.dto.paginationDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
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
    public paginationDTO list(Integer userId,String search, Integer page, Integer size) {
        if(StringUtils.isNotBlank(search)){
            String []tags=StringUtils.split(search,' ');
            search= Arrays.stream(tags).collect(Collectors.joining("|"));
        }

        Integer totalPage;
        paginationDTO<KnowledgeBase>pagination = new paginationDTO<>();
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
}
