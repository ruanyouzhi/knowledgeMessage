package com.km.knowledgemessage.service;

import com.km.knowledgemessage.Mapper.*;
import com.km.knowledgemessage.Model.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RegisterService {
    @Autowired
    private CardMapper cardMapper;
    @Autowired
    private CardExtMapper cardExtMapper;
    @Autowired
    private PublicCardMapper publicCardMapper;
    @Autowired
    private LabelBaseMapper labelBaseMapper;
    @Autowired
    private KnowledgeBaseMapper knowledgeBaseMapper;
    @Autowired
    private UserMapper userMapper;

    public Boolean judgeExist(User user){
        // 判断是否存在用户
        User user1 = userMapper.selectByPrimaryKey(user.getId());   // 在数据库中查询，如果有，说明该用户不能被注册
        return user.equals(user1);
    }
    public long UserRegister(User user){
        // 用户注册
        user.setGmtCreate(System.currentTimeMillis());
        user.setGmtModified(user.getGmtCreate());
        userMapper.insert(user);
        return user.getId();
    }


    public User getUser(long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
