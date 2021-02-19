package com.cqjtu.studentdocument.service.Impl;

import com.cqjtu.studentdocument.dao.SuggestionDao;
import com.cqjtu.studentdocument.entity.Suggestion;
import com.cqjtu.studentdocument.service.SuggestionService;
import com.cqjtu.studentdocument.utils.dto.InfoDTO;
import com.cqjtu.studentdocument.utils.dto.InfoReadDTO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class SuggestionServiceImpl extends BaseServiceImpl<Suggestion,SuggestionDao> implements SuggestionService {
    @Override
    public List<Suggestion> getUnReadMessageByUserId(Integer userId) {
        Example example = new Example(Suggestion.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId",userId).andEqualTo("isRead",0);
        return this.entityDao.selectByExample(example);
    }

    @Override
    public PageInfo<Suggestion> getPage(InfoDTO infoDTO) {
        PageHelper.startPage(infoDTO.getPage(), infoDTO.getRows());
        Example example = new Example(Suggestion.class);
        Example.Criteria criteria = example.createCriteria();
        if (infoDTO.getDoctorId()!=null){
            criteria.andEqualTo("doctorId",infoDTO.getDoctorId());
        }
        if (infoDTO.getUserId()!=null){
            criteria.andEqualTo("userId",infoDTO.getUserId());
        }
        if (infoDTO.getIsRead()!=null){
            criteria.andEqualTo("isRead",infoDTO.getIsRead());
        }
        if (!StringUtils.isEmpty(infoDTO.getOffice())){
            criteria.andEqualTo("office",infoDTO.getOffice());
        }
        if (!StringUtils.isEmpty(infoDTO.getContent())){
            criteria.andLike("content",infoDTO.getContent());
        }
        List<Suggestion> list = this.entityDao.selectByExample(example);
        return new PageInfo<>(list);
    }

    @Override
    public Integer markToRead(InfoReadDTO infoReadDTO) {
        return this.entityDao.setInfoReadByIds(infoReadDTO.getIds(),infoReadDTO.getIsRead());
    }

    @Override
    public Integer deleteInfoByIds(Integer[] ids) {
        return this.entityDao.deleteByIds(ids);
    }
}
