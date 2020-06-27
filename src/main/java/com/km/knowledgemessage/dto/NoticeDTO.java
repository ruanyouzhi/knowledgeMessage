package com.km.knowledgemessage.dto;

import lombok.Data;

@Data
public class NoticeDTO {
    private Long Id;
    private Long notifier;
    private Long receiver;
    private Long cardId;
    private Integer type;
    private Integer status;
    private String cardName;
    private String notifierName;
    private String typeName;
}
