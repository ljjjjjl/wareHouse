package com.service.Impl;

import com.controller.result.Code;
import com.dao.UserDao;
import com.domain.PageInfo;
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
            throw new SqlException(Code.SQL_REPEATUSER_ERR,"该用户名已被占用");
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



    @Override
    public PageInfo<User> findByPage(int currentPage) {
        PageInfo<User> pageInfo = new PageInfo<>();
        //获取每页的数据量
        pageInfo.setSize(2);

        //获取总数据量
        int totalCount = userDao.getTotal();//中断
        pageInfo.setTotalCount(totalCount);
        //获取总页数
        int totalPage = (int)Math.ceil(totalCount/(double)pageInfo.getSize());
        pageInfo.setTotalPage(totalPage);

        //判断当前页是否合理
        if(currentPage<1){
            pageInfo.setCurrentPage(1);
        }else if(currentPage>totalPage){
            pageInfo.setCurrentPage(totalPage);
        }else {
            pageInfo.setCurrentPage(currentPage);
        }

        int start = (pageInfo.getCurrentPage()-1)*pageInfo.getSize();
        //查询当前页面下所有的用户信息
        List<User> list = userDao.findByPage(start,pageInfo.getSize());

        pageInfo.setList(list);
        return pageInfo;
    }


}
