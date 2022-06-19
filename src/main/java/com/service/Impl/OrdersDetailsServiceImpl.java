package com.service.Impl;

import com.dao.GoodsDetailsDao;
import com.dao.OrdersDetailsDao;
import com.domain.*;
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
    public boolean update(OrdersDetails ordersDetails) {
        return ordersDetailsDao.update(ordersDetails)>0;
    }

    @Override
    public Integer getAmount(OrdersDetails ordersDetails) {
        return ordersDetailsDao.getAmount(ordersDetails);
    }

    @Override
    public OrdersDetails getById(Integer id) {
        return ordersDetailsDao.getById(id);
    }


    @Override
    public PageInfo<OrdersDetails> findByPage(int others_id,int currentPage) {
        PageInfo<OrdersDetails> pageInfo = new PageInfo<>();
        //获取每页的数据量
        pageInfo.setSize(5);

        //获取总数据量
        int totalCount = ordersDetailsDao.getTotal(others_id);//中断
        pageInfo.setTotalCount(totalCount);
        //获取总页数
        int totalPage = (int)Math.ceil(totalCount/(double)pageInfo.getSize());
        pageInfo.setTotalPage(totalPage);

        //判断当前页是否合理
        if(currentPage<1){
            pageInfo.setCurrentPage(1);
        }else if(currentPage>totalPage){
            pageInfo.setCurrentPage(totalPage);
        }else {
            pageInfo.setCurrentPage(currentPage);
        }

        int start = (pageInfo.getCurrentPage()-1)*pageInfo.getSize();
        //查询当前页面下所有的用户信息
        List<OrdersDetails> list = ordersDetailsDao.findByPage(others_id,start,pageInfo.getSize());

        pageInfo.setList(list);
        return pageInfo;
    }
}
