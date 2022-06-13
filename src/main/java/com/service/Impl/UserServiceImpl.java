package com.service.Impl;

import com.controller.result.Code;
import com.dao.UserDao;
import com.domain.User;
import com.exception.SqlException;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public boolean save(User user) {
        if (userDao.UNIQUE(user) >=1){
            throw new SqlException(Code.SQL_PEPEATUSER_ERR,"该用户名已被占用");
        }
        System.out.println(userDao.UNIQUE(user));
        return userDao.save(user)>0;
    }

    @Override
    public boolean update(User user) {
        return userDao.update(user)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return userDao.delete(id)>0;
    }

    @Override
    public User getById(Integer id) {
        return userDao.getById(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }



    @Override
    public User login(User user) {
        return userDao.login(user);
    }

    @Override
    public boolean change(User user) {
        return userDao.change(user)>0;
    }
}
