package com.km.knowledgemessage.dto;

import lombok.Data;

@Data
public class CardQueryDTO {
    private  Integer userId;
    private String search;
    private Integer page;
    private Integer size;
}
