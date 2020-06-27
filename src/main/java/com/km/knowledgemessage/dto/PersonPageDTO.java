package com.km.knowledgemessage.dto;
import com.km.knowledgemessage.Model.User;
import lombok.Data;

@Data
public class PersonPageDTO {
    private Long id;
    private String name;
    private String avatarUrl;
    private Long noticeNum;
}
