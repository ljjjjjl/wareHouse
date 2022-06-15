package com.dao;

import com.domain.PageInfo;
import com.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {
    @Insert("insert into user (user_id,user_name)values(#{user_id},#{user_name})")
    int save(User user);

    @Update("update user set user_id =#{user_id},user_password=#{user_password},user_name=#{user_name} where id =#{id}")
    int update(User user);

    @Delete("update user set user_status =1 where id =#{id}")
    int delete(Integer id);

    @Select("select *from user where id =#{id} and user_status =0")
    User getById(Integer id);

    @Select("select *from user where user_status =0")
    List<User> getAll();


    @Select("select * from user where user_id =#{user_id} and user_password=#{user_password} and user_status =0")
    User login(User user);

    @Update("update user set user_password=#{user_password} where id =#{id}")
    int change(User user);

    //查询user_id是否唯一
    @Select("SELECT COUNT(id) FROM user WHERE user_id =#{user_id}")
    int UNIQUE(User user);





    @Select("select count(*) from user where user_status =0")
    int getTotal();

    @Select("select * from user where user_status =0 limit #{start},#{size}")
    List<User> findByPage(@Param("start") int start,@Param("size") int size);

    @Select("select count(*) from user where user_status=0 and " +
            "(id like concat('%',#{keyword},'%') or user_id like concat('%',#{keyword},'%') or user_name like concat('%',#{keyword},'%')" +
            ")")
    int searchTotal(String keyword);

    @Select("select * from user where user_status=0 and " +
            "(id like concat('%',#{keyword},'%') or user_id like concat('%',#{keyword},'%') or user_name like concat('%',#{keyword},'%'))" +
            " limit #{start},#{size}")
    List<User> search(@Param("keyword")String keyword,@Param("start") int start,@Param("size") int size);
}
