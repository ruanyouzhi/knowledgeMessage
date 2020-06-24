package com.km.knowledgemessage.Mapper;

import com.km.knowledgemessage.dto.CardQueryDTO;

import java.util.List;

public interface KnowledgeBaseExtMapper {
    Integer countBySearch(CardQueryDTO cardQueryDTO);

    List selectBySearch(CardQueryDTO cardQueryDTO);
}