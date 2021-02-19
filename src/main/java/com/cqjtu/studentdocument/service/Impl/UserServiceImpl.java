package com.cqjtu.studentdocument.service.Impl;

import com.cqjtu.studentdocument.dao.UserDao;
import com.cqjtu.studentdocument.entity.User;
import com.cqjtu.studentdocument.service.UserService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl<User,UserDao> implements UserService {
    @Override
    public User findByUsername(String username) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("username",username);
        List<User> users = this.entityDao.selectByExample(example);
        if (users.size()==0){
            return null;
        }
        return users.get(0);
    }
}
