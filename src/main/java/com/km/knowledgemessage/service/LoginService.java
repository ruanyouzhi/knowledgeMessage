package com.km.knowledgemessage.service;

import com.km.knowledgemessage.Mapper.*;
import com.km.knowledgemessage.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    private UserMapper userMapper;

    public Long getUserId(String userMail) {

        UserExample example = new UserExample();
        example.createCriteria().andMailEqualTo(userMail);
        List<User> users = userMapper.selectByExample(example);
        User user = users.get(0);
        if (user != null){

            return user.getId();
        }
        else
            return (long) -1;
    }

    public User getUser(Long userId){
        return userMapper.selectByPrimaryKey(userId);
    }
    public Boolean judgeExist(User user){
        // 判断是否存在用户
        User user1;   // 在数据库中查询，如果有，说明该用户不能被注册
        user1 = userMapper.selectByPrimaryKey(user.getId());
        return user1 == null;
    }



}
