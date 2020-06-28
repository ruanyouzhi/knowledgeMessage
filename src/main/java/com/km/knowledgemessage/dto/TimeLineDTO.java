package com.km.knowledgemessage.dto;

import lombok.Data;

@Data
public class TimeLineDTO {
    private Long cardId;
    private Long creatorId;
    private Long gmtCreate;
    private Long reviewNum;
    private String cardName;
    private String cardDescription;
    private Long likeNum;
}
