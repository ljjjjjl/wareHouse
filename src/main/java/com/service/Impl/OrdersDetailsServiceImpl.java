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
    public boolean save(OrdersDetails ordersDetails) {
        return false;
    }

    @Override
    public boolean update(OrdersDetails ordersDetails) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public User getById(Integer id) {
        return null;
    }

    @Override
    public List<OrdersDetails> getAll(Integer orders_id) {
        return ordersDetailsDao.getAll(orders_id);
    }
}
