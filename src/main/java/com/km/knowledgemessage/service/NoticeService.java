package com.km.knowledgemessage.service;

import com.km.knowledgemessage.Mapper.NoticeMapper;
import com.km.knowledgemessage.Model.Notice;
import com.km.knowledgemessage.Model.NoticeExample;
import com.km.knowledgemessage.dto.NoticeDTO;
import com.km.knowledgemessage.enums.NoticeEnum;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class NoticeService {
    @Resource
    private NoticeMapper noticeMapper;

    public  List getNoticeList(Long userId) {
        NoticeExample example = new NoticeExample();
        example.createCriteria().andReceiverEqualTo(userId);
        List<Notice> noticeList = noticeMapper.selectByExample(example);
        List<NoticeDTO> noticeDTOList=new ArrayList<NoticeDTO>();
        for (Notice notice:noticeList) {
            NoticeDTO noticeDTO=new NoticeDTO();
            BeanUtils.copyProperties(notice,noticeDTO);
            noticeDTO.setTypeName(NoticeEnum.nameOfType(notice.getType()));
            noticeDTOList.add(noticeDTO);
        }
        Collections.sort(noticeDTOList, new Comparator<NoticeDTO>() {
            @Override
            public int compare(NoticeDTO o1, NoticeDTO o2) {
                return o1.getStatus()-o2.getStatus();
            }
        });
        return noticeDTOList;
    }


}
