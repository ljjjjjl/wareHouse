package com.dao;

import com.domain.User;
import com.domain.Warehouse;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface WarehouseDao {

    @Select("select *from warehouse")
    public List<Warehouse> getAll();
    @Select("select warehouse_name from warehouse where id = #{id}")
    public String getnameByid(Integer id);

    @Select("select count(*) from warehouse ")
    int getTotal();
    @Select("select * from warehouse  limit #{start},#{size}")
    public List<Warehouse> findByPage(@Param("start") int start, @Param("size") int size);

    @Insert("insert into warehouse (warehouse_name)values(#{warehouse_name})")
    int save(Warehouse warehouse);

    @Select("select max(id) from warehouse")
    public int maxId();

    @Update("update warehouse set warehouse_id =#{warehouse_id} where id =#{id}")
    int update(Warehouse warehouse);
}
