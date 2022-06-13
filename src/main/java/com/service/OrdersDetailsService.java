package com.service;

import com.domain.OrdersDetails;
import com.domain.User;

import java.util.List;

public interface OrdersDetailsService {
    /**
     * 保存
     * @param ordersDetails
     * @return
     */
    public boolean save(OrdersDetails ordersDetails);

    /**
     * 修改
     * @param ordersDetails
     * @return
     */
    public boolean update(OrdersDetails ordersDetails);

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
    public List<OrdersDetails> getAll(Integer orders_id);
}
