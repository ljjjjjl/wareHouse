package com.dao;

import com.domain.Goods;
import com.domain.GoodsDetails;
import com.domain.Orders;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrdersDao {
//    @Insert("insert into orders " +
//            "(orders_id,orders_type,orders_address,orders_note,warehouse_id,user_id)" +
//            "values(#{orders_id},#{orders_type},#{orders_address}," +
//            "#{orders_note},#{warehouse_id},#{user_id})")
    @Insert("insert into orders " +
        "(orders_type,orders_address,orders_note,warehouse_id,user_id)" +
        "values(#{orders_type},#{orders_address}," +
        "#{orders_note},#{warehouse_id},#{user_id})")
    public int save(Orders orders);
    @Select("select max(id) from orders")
    public int maxId();


    @Update("update orders set " +
            "orders_id =#{orders_id},orders_address =#{orders_address} ," +
            "orders_note =#{orders_note},warehouse_id =#{warehouse_id} " +
            "where id =#{id}")
    public int update(Orders orders);

    @Delete("update orders set orders_status =1 where id =#{id}")
    public int delete(Integer id);

    @Select("select *from orders where id =#{id} and orders_status =0")
    public Orders getById(Integer id);

    @Select({"<script>" +
            "select *from orders where orders_status =0 " +
            "<if test=\"orders_id != null and orders_id !=''\"> " +
            "and orders_id like concat('%',#{orders_id},'%')" +
            "</if> " +
            "<if test=\"orders_address != null and orders_address !=''\"> " +
            "and orders_address like concat('%',#{orders_address},'%') " +
            "</if>"+
            "<if test=\"warehouse_id != null and warehouse_id !=''\">" +
            " and warehouse_id like concat('%',#{warehouse_id},'%') " +
            "</if>"+
            "<if test=\"user_id != null and user_id !=''\">" +
            " and user_id like concat('%',#{user_id},'%') " +
            "</if>"+
            "</script>"
    })
    public List<Orders> find(Orders orders);

    @Select("select *from orders where orders_type ='入库' and orders_status =0")
    public List<Orders> getAllIn();

    @Select("select *from orders where orders_type ='出库' and orders_status =0")
    public List<Orders> getAllOut();

    @Select("select count(*) from orders where orders_type ='入库' and orders_status =0")
    int getTotalIn();
    @Select("select * from orders where orders_type ='入库' and orders_status =0 limit #{start},#{size}")
    List<Orders> findByPageIn(@Param("start") int start, @Param("size") int size);

    @Select("select count(*) from orders where orders_type ='出库' and orders_status =0")
    int getTotalOut();
    @Select("select * from orders where orders_type ='出库' and orders_status =0 limit #{start},#{size}")
    List<Orders> findByPageOut(@Param("start") int start, @Param("size") int size);
}
