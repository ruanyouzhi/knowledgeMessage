package com.km.knowledgemessage.service;

import com.km.knowledgemessage.Mapper.*;
import com.km.knowledgemessage.Model.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RegisterService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserExtMapper userExtMapper;
    @Resource
    private KnowledgeBaseMapper knowledgeBaseMapper;

    public Boolean judgeExist(User user){
        // 判断是否存在用户
        User user1;   // 在数据库中查询，如果有，说明该用户不能被注册
        user1 = userMapper.selectByPrimaryKey(user.getId());
        return user1 == null;
    }
    public long UserRegister(User user){
        // 用户注册
        user.setGmtCreate(System.currentTimeMillis());
        user.setGmtModified(user.getGmtCreate());
        userExtMapper.insert(user);
        //KnowledgeBase
        KnowledgeBase knowledgeBase =new KnowledgeBase();
        knowledgeBase.setGmtCreate(user.getGmtCreate());
        knowledgeBase.setGmtModified(user.getGmtCreate());
        knowledgeBase.setUserId(user.getId());
        knowledgeBase.setCreatorId(user.getId());
        knowledgeBaseMapper.insert(knowledgeBase);
        return user.getId();
    }


    public User getUser(long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
