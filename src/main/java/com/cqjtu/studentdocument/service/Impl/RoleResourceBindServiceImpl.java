package com.cqjtu.studentdocument.service.Impl;

import com.cqjtu.studentdocument.dao.RoleResourceBindDao;
import com.cqjtu.studentdocument.entity.RoleResourceBind;
import com.cqjtu.studentdocument.service.RoleResourceBindService;
import com.cqjtu.studentdocument.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleResourceBindServiceImpl extends BaseServiceImpl<RoleResourceBind,RoleResourceBindDao> implements RoleResourceBindService {

    @Autowired
    RoleService roleService;

    @Override
    public List<Integer> getResourceIds(Integer roleId) {
        Example example = new Example(RoleResourceBind.class);
        example.createCriteria().andEqualTo("roleId",roleId);
        List<RoleResourceBind> binds = this.entityDao.selectByExample(example);
        List<Integer> list = new ArrayList<>(binds.size());
        binds.forEach(b-> list.add(b.getResourceId()));
        return list;
    }

    @Override
    public List<Integer> getRoleIds(Integer resourceId) {
        Example example = new Example(RoleResourceBind.class);
        example.createCriteria().andEqualTo("resourceId",resourceId);
        List<RoleResourceBind> binds = this.entityDao.selectByExample(example);
        Set<Integer> set = new HashSet<>(binds.size());
        binds.forEach(b-> set.add(b.getRoleId()));
        List<Integer> list = new ArrayList<>(set);
        return  list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer addBindInfo(Integer resourceId, List<Integer> roleList) {
        return this.entityDao.addBindInfo(resourceId,roleList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer deleteBindInfo(Integer resourceId) {
        return this.entityDao.deleteBindInfo(resourceId);
    }
}
