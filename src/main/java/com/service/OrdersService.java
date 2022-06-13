package com.service;

import com.domain.Goods;
import com.domain.Orders;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Transactional
public interface OrdersService {
    /**
     * 保存
     * @param orders
     * @return
     */
    public boolean save(Orders orders);

    /**
     * 修改
     * @param orders
     * @return
     */
    public boolean update(Orders orders);

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
    public Orders getById(Integer id);

    /**
     * 查询
     * @param orders
     * @return
     */
    public List<Orders> find(Orders orders);

    /**
     * 查询全部入库
     * @return
     */
    public List<Orders> getAllIn();

    /**
     * 查询全部出库
     * @return
     */
    public List<Orders> getAllOut();
}
