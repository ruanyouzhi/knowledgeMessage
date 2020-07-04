package com.km.knowledgemessage.controller;
import com.km.knowledgemessage.Model.User;
import com.km.knowledgemessage.dto.PersonPageDTO;
import com.km.knowledgemessage.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserInfoController {
    @Autowired
    public UserInfoService userInfoService;
    @CrossOrigin
    @RequestMapping(value = "api/personPage")
    @ResponseBody
    public Map<String,Object> getPersonPage(@RequestParam(name = "userId")long userId) {
        Map<String, Object> map = new HashMap<>();
        PersonPageDTO personPageDTO=userInfoService.getPersonPage(userId);
        try {
                 map.put("peronPageInfo",personPageDTO);
                map.put("status", (long) 1);
        } catch (Exception e) {
            map.put("status", (long) 0);
        }
        return map;
    }
    @CrossOrigin
    @RequestMapping(value = "api/getUserInfo")
    @ResponseBody
    public Map<String,Object> getUserInfo(@RequestParam(name = "userId")long userId) {
        Map<String, Object> map = new HashMap<>();
        User user =userInfoService.getUserInfo(userId);
        try {
            map.put("userInfo",user);
            map.put("status", (long) 1);
        } catch (Exception e) {
            map.put("status", (long) 0);
        }
        return map;
    }



    /**
     * This method was generated by ygm
     关于传入信息：
     private Long id;
     private String name;
     private String mail;
     private String password;
     private String avatarUrl;

     */
    @CrossOrigin
    @RequestMapping(value = "api/modifiedUserInfo")
    @ResponseBody
    public Map<String,Object> modifiedUserInfo(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        user.setGmtCreate(System.currentTimeMillis());
        userInfoService.setUserInfo(user);
        try {
            map.put("status", (long) 1);
        } catch (Exception e) {
            map.put("status", (long) 0);
        }
        return map;
    }
}
