package com.dao;

import com.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {
    @Insert("insert into user (user_id,user_name)values(#{user_id},#{user_name})")
    public int save(User user);

    @Update("update user set user_id =#{user_id},user_password=#{user_password},user_name=#{user_name} where id =#{id}")
    public int update(User user);

    @Delete("update user set user_status =1 where id =#{id}")
    public int delete(Integer id);

    @Select("select *from user where id =#{id} and user_status =0")
    public User getById(Integer id);

    @Select("select *from user where user_status =0")
    public List<User> getAll();


    @Select("select * from user where user_id =#{user_id} and user_password=#{user_password} and user_status =0")
    public User login(User user);

    @Update("update user set user_password=#{user_password} where id =#{id}")
    public int change(User user);

    //查询user_id是否唯一
    @Select("SELECT COUNT(id) FROM user WHERE user_id =#{user_id}")
    public int UNIQUE(User user);

    @Select("select * from user where user_status=0 and (id like concat('%',#{keyword},'%') or user_id like concat('%',#{keyword},'%')" +
            " or user_name like concat('%',#{keyword},'%'))")
    List<User> search(String keyword);

    @Select("select * from user where user_status=0 )")
    List<User> searchNull();


    @Select("select count(*) from user where user_status =0")
    public int getTotal();

    @Select("select * from user where user_status =0 limit #{start},#{size}")
    List<User> findByPage(@Param("start") int start,@Param("size") int size);
}
