package com.dao;

import com.domain.OrdersDetails;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface OrdersDetailsDao {
    @Insert("insert into orders_details " +
            "(amount,goods_details_id,orders_id)" +
            "values(#{amount},#{goods_details_id},#{orders_id})")
    public int save(OrdersDetails ordersDetails);

    @Update("update orders_details set " +
            "amount =#{amount} " +
            "where id =#{id}")
    public int update(OrdersDetails ordersDetails);

    @Delete("update orders_details set goods_status =1 where id =#{id}")
    public int delete(Integer id);

    @Select("select *from orders_details where id =#{id} and status =0")
    public OrdersDetails getById(Integer id);

    @Select("select *from orders_details where status =0 and orders_id =#{orders_id}")
    public List<OrdersDetails> getAll(Integer orders_id);
}
