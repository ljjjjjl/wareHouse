package com.service;

import com.domain.PageInfo;
import com.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UserService {
    /**
     * 保存
     * @param user
     * @return
     */
    public boolean save(User user);

    /**
     * 修改
     * @param user
     * @return
     */
    public boolean update(User user);

    /**
     * 按id删除
     * @param id
     * @return
     */
    public boolean delete(Integer id);

    /**
     * 按id查询
     * @param id
     * @return
     */
    public User getById(Integer id);

    /**
     * 查询全部
     * @return
     */
    public List<User> getAll();



    /**
     * 登录验证
     * @return
     */
    public User login(User user);

    /**
     * 密码修改
     * @return
     */
    public boolean change(User user);

    /**
     * 是否为唯一账号
     * @return
     */
    public boolean UNIQUE(User user);

    /**
     * 多条件模糊查询
     * @return
     */
    public List<User> search(String info);


    /**
     * 获得用户列表页面的分页信息
     * @return
     */
    public PageInfo<User> findByPage(int currentPage);
}
