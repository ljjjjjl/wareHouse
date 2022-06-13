package com.service.Impl;

import com.dao.OrdersDao;
import com.domain.Goods;
import com.domain.Orders;
import com.domain.User;
import com.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    OrdersDao ordersDao;

    @Override
    public boolean save(Orders orders) {
        return ordersDao.save(orders)>0;
    }

    @Override
    public boolean update(Orders orders) {
        return ordersDao.update(orders)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return ordersDao.delete(id)>0;
    }

    @Override
    public Orders getById(Integer id) {
        return ordersDao.getById(id);
    }

    @Override
    public List<Orders> find(Orders orders) {
        return ordersDao.find(orders);
    }

    @Override
    public List<Orders> getAllIn() {
        return ordersDao.getAllIn();
    }

    @Override
    public List<Orders> getAllOut() {
        return ordersDao.getAllOut();
    }
}
