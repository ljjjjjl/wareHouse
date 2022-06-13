package com.service;

import com.domain.OrdersDetails;
import com.domain.User;

import java.util.List;

public interface OrdersDetailsService {

    /**
     * 查询全部
     * @return
     */
    public List<OrdersDetails> getAll(Integer orders_id);

    /**
     * 查询仓库id
     * @param ordersDetails
     * @return
     */
    public int getWarehouseId(OrdersDetails ordersDetails);

    /**
     * 保存
     * @param ordersDetails
     * @return
     */
    public boolean save(OrdersDetails ordersDetails);

    /**
     * 按id删除
     * @param id
     * @return
     */
    public boolean delete(Integer id);

    /**
     * 模糊查询
     * @param ordersDetails
     * @return
     */
    public List<OrdersDetails> find(OrdersDetails ordersDetails);

    /**
     * 修改下单数
     * @param ordersDetails
     * @return
     */
    public boolean updateIn(OrdersDetails ordersDetails);

    /**
     * 按id删除
     * @param ordersDetails
     * @return
     */
    public Integer getAmount(OrdersDetails ordersDetails);

    /**
     * 按id查询
     * @param id
     * @return
     */
    public OrdersDetails getById(Integer id);


}
