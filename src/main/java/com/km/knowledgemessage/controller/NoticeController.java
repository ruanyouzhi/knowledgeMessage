package com.km.knowledgemessage.controller;

import com.km.knowledgemessage.Mapper.NoticeMapper;
import com.km.knowledgemessage.Model.Notice;
import com.km.knowledgemessage.dto.NoticeDTO;
import com.km.knowledgemessage.enums.NoticeStatusEnum;
import com.km.knowledgemessage.service.NoticeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class NoticeController {
    @Autowired
    public NoticeService noticeService;
    @Autowired
    public NoticeMapper noticeMapper;

    /**
     * This method was generated by ygm
        关于返回值：
     private Long Id:这条通知在数据库的id
     status：UNREAD(0),READ(1);是否已读
     private Long notifier：通知发起者id
     private Long receiver：通知接受者id
     private Integer type：通知种类：
     private String typeName：通知类型名;
     包括以下几种
     {
     REPLY_QUESTION(1,"回复了问题"),
     REPLY_COMMENT(2,"回复了评论"),
     REPLY_COLLECT(3,"收藏了"),
     REPLY_LIKE(4,"点赞了"),
     }

     */


    @CrossOrigin
    @RequestMapping(value = "api/getNotice")
    @ResponseBody
    public Map<String,Object> getNotice(@RequestParam Long userId){
        Map<String,Object>map=new HashMap<>();
        try {
            List<NoticeDTO> noticeDTOList = noticeService.getNoticeList(userId);
            map.put("noticeList",noticeDTOList);
            map.put("status", (long) 1);
        }catch (Exception e){
            map.put("status", (long) 0);
        }
        return map;
    }
    @CrossOrigin
    @RequestMapping(value = "api/read")
    @ResponseBody
    public String read(@RequestParam Long noticeId){
            Notice notice=new Notice();
            notice.setId(noticeId);
            notice.setStatus(NoticeStatusEnum.READ.getStatus());
            noticeMapper.updateByPrimaryKeySelective(notice);
        return "redirect:/card/"+noticeId;
    }
    @CrossOrigin
    @RequestMapping(value = "api/delNotice")
    @ResponseBody
    public Map<String,Object>  delNotice(@RequestParam Long noticeId){
        Map<String,Object>map = new HashMap<>();
        try {
            noticeMapper.deleteByPrimaryKey(noticeId);
            map.put("status", (long) 1);
        }catch (Exception e){
            map.put("status", (long) 0);
        }
        return map;
    }
}