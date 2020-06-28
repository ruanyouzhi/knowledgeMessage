package com.km.knowledgemessage.controller;
import com.km.knowledgemessage.Model.*;
import com.km.knowledgemessage.service.AddCardService;
import com.km.knowledgemessage.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller

public class RegisterController {
    @Autowired
    private RegisterService registerService;
// 用户注册
// 应该从前端传入用户对象
    @CrossOrigin
    @PostMapping(value = "api/register")
    @ResponseBody


    public Map<String,Long> register(@RequestBody User requestUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getName();
        username = HtmlUtils.htmlEscape(username);
        Map<String,Long>map=new HashMap<>();
        // 首先，判断是否存在该用户
        if(!registerService.judgeExist(requestUser)){
            try{
                Long userId = registerService.UserRegister(requestUser);
                map.put("userId", userId);
                map.put("status", (long) 1);
            }catch (Exception e){
                map.put("status", (long) 0);
            }
        }
        else{
            System.out.println("该用户已存在！");
            map.put("status", (long) 0);
        }
        return map;
    }
}
