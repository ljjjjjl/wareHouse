package com.service.Impl;

import com.dao.GoodsDetailsDao;
import com.dao.OrdersDetailsDao;
import com.domain.GoodsDetails;
import com.domain.OrdersDetails;
import com.domain.User;
import com.service.OrdersDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersDetailsServiceImpl implements OrdersDetailsService {

    @Autowired
    private OrdersDetailsDao ordersDetailsDao;

    @Override
    public List<OrdersDetails> getAll(Integer orders_id) {
        return ordersDetailsDao.getAll(orders_id);
    }

    @Override
    public int getWarehouseId(OrdersDetails ordersDetails) {
        return ordersDetailsDao.getWarehouseId(ordersDetails);
    }

    @Override
    public boolean save(OrdersDetails ordersDetails) {
        return ordersDetailsDao.save(ordersDetails)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return ordersDetailsDao.delete(id)>0;
    }

    @Override
    public List<OrdersDetails> find(OrdersDetails ordersDetails) {
        return ordersDetailsDao.find(ordersDetails);
    }

    @Override
    public boolean updateIn(OrdersDetails ordersDetails) {
        return ordersDetailsDao.updateIn(ordersDetails)>0;
    }

    @Override
    public Integer getAmount(OrdersDetails ordersDetails) {
        return ordersDetailsDao.getAmount(ordersDetails);
    }

    @Override
    public OrdersDetails getById(Integer id) {
        return ordersDetailsDao.getById(id);
    }


}
