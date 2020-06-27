package com.km.knowledgemessage.enums;

public enum NoticeEnum {
    REPLY_QUESTION(1,"回复了问题"),
    REPLY_COMMENT(2,"回复了评论"),
    REPLY_COLLECT(3,"收藏了"),
    REPLY_LIKE(4,"点赞了"),
    ;

    public int getType() {
        return type;
    }
    public String getName() {
        return name;
    }
    private int type;
    private String name;

    NoticeEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }
    public static String nameOfType(int type){

        for (NoticeEnum noticeEnum : NoticeEnum.values()) {
            if(noticeEnum.getType()==type){
                return noticeEnum.getName();
            }
        }
        return "";
    }
}
