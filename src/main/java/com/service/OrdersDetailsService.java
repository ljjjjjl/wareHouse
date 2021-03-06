package com.service;

import com.domain.GoodsDetails;
import com.domain.OrdersDetails;
import com.domain.PageInfo;
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
    public boolean update(OrdersDetails ordersDetails);

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

    /**
     * 获得列表页面的分页信息
     * @return
     */
    public PageInfo<OrdersDetails> findByPage(int others_id, int currentPage);

    /**
     * 获得列表页面的分页信息
     * @return
     */
    public PageInfo<OrdersDetails> findAll(String info, int currentPage);

}
