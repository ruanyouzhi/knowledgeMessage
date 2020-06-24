package com.km.knowledgemessage.Mapper;

import com.km.knowledgemessage.Model.Card;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CardExtMapper {
    int insert(Card record);

}