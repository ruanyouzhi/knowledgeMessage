package com.km.knowledgemessage.service;

import com.km.knowledgemessage.Mapper.NoticeMapper;
import com.km.knowledgemessage.Mapper.UserMapper;
import com.km.knowledgemessage.Model.NoticeExample;
import com.km.knowledgemessage.Model.User;
import com.km.knowledgemessage.Model.UserExample;
import com.km.knowledgemessage.dto.PersonPageDTO;
import com.km.knowledgemessage.enums.NoticeStatusEnum;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

@Autowired
public NoticeMapper noticeMapper;
@Autowired
public UserMapper userMapper;
    public PersonPageDTO getPersonPage(long userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        PersonPageDTO personPageDTO=new PersonPageDTO();
        BeanUtils.copyProperties(user,personPageDTO);
        NoticeExample noticeExample = new NoticeExample();
        noticeExample.createCriteria().andStatusEqualTo(NoticeStatusEnum.UNREAD.getStatus());//已读:status=1;未读：status=0；
        long noticeNum = noticeMapper.countByExample(noticeExample);
        personPageDTO.setNoticeNum(noticeNum);
        return personPageDTO;
    }

    public User getUserInfo(long userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        user.setToken("");
        return user;
    }

    public void setUserInfo(User user) {
        int i = userMapper.updateByPrimaryKeySelective(user);
    }
}
