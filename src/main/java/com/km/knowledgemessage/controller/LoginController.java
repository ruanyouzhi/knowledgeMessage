package com.km.knowledgemessage.controller;

import com.km.knowledgemessage.Model.Result;
import com.km.knowledgemessage.Model.User;
import com.km.knowledgemessage.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller

public class LoginController {
    @Autowired
    private LoginService registerService;
    @CrossOrigin
    @RequestMapping(value = "api/login")
    @ResponseBody
    public Map<Result, Object> login(@RequestParam String userMail, String userPassword) {
        Map<Result, Object> map = new HashMap<>();
        Long userId = registerService.getUserId(userMail);
        if (userId == -1) {

            map.put(new Result(400), "该用户不存在");
            return map;
        }
        User user = registerService.getUser(userId);
        // 首先，判断是否存在该用户
        if (!registerService.judgeExist(user)) {

            if (user.getPassword().equals(userPassword)) {
                map.put(new Result(200), user.getId());
                map.put(new Result(200), "该用户正确");

            } else {

                map.put(new Result(200), "账号密码错误");
            }
        }
        return map;
    }
}
