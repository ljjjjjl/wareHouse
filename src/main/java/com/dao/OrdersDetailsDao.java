package com.dao;

import com.domain.GoodsDetails;
import com.domain.OrdersDetails;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrdersDetailsDao {


    @Select("select *from orders_details where status =0 and orders_id =#{orders_id}")
    public List<OrdersDetails> getAll(Integer orders_id);

//    @Select("select warehouse_id from orders o,orders_details od " +
//            "where o.id =od.orders_id and o.id =#{orders_id} group by warehouse_id")
    @Select("select warehouse_id from orders where id =#{orders_id} ")
    public int getWarehouseId(OrdersDetails ordersDetails);


    @Insert("insert into orders_details " +
            "(amount,goods_details_id,orders_id)" +
            "values(#{amount},#{goods_details_id},#{orders_id})")
    public int save(OrdersDetails ordersDetails);

    @Delete("update orders_details set status =1 where id =#{id}")
    public int delete(Integer id);

    @Select({"<script>" +
            "select *from orders_details where status =0 " +
            "<if test=\"amount != null and amount !=''\"> " +
            "and amount like concat('%',#{amount},'%')" +
            "</if> " +
            "<if test=\"goods_details_id != null and goods_details_id !=''\"> " +
            "and goods_details_id like concat('%',#{goods_details_id},'%') " +
            "</if>"+
            "<if test=\"orders_id != null and orders_id !=''\">" +
            " and orders_id like concat('%',#{orders_id},'%') " +
            "</if>"+
            "</script>"
    })
    public List<OrdersDetails> find(OrdersDetails ordersDetails);

    @Update("update orders_details set amount =#{amount} where id =#{id}")
    public int update(OrdersDetails ordersDetails);

    @Select("select amount from orders_details where id =#{id}")
    public int getAmount(OrdersDetails ordersDetails);

    @Select("select * from orders_details where id =#{id}")
    public OrdersDetails getById(Integer id);

    @Select("select count(*) from orders_details where orders_id =#{orders_id} and status =0")
    int getTotal(int orders_id);
    @Select("select * from orders_details where orders_id =#{orders_id} and status =0 limit #{start},#{size}")
    List<OrdersDetails> findByPage(@Param("orders_id")int goods_id, @Param("start") int start, @Param("size") int size);
}
