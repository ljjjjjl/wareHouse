package com.service.Impl;

import com.controller.result.Code;
import com.controller.result.RandomString;
import com.dao.OrdersDao;
import com.domain.*;
import com.exception.SqlException;
import com.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    OrdersDao ordersDao;
    RandomString randomString;

    @Override
    public boolean save(Orders orders) {
        int flag =ordersDao.save(orders);
        if (flag>0){
            orders.setId(ordersDao.maxId());
            //生成随机数
            orders.setOrders_id(randomString.getRandomString(5)+orders.getId());
            flag =ordersDao.afterUpdate(orders);
        }else {
            throw new SqlException(Code.SQL_ADDGOODS_ERR,"新添货单失败");
        }
        return flag>0;
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

    @Override
    public PageInfo<Orders> findByPageIn(int currentPage) {
        PageInfo<Orders> pageInfo = new PageInfo<>();
        //获取每页的数据量
        pageInfo.setSize(5);

        //获取总数据量
        int totalCount = ordersDao.getTotalIn();//中断
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
        if(totalCount ==0){
            start =0;
        }
        //查询当前页面下所有的用户信息
        List<Orders> list = ordersDao.findByPageIn(start,pageInfo.getSize());

        pageInfo.setList(list);
        return pageInfo;
    }

    @Override
    public PageInfo<Orders> findByPageOut(int currentPage) {
        PageInfo<Orders> pageInfo = new PageInfo<>();
        //获取每页的数据量
        pageInfo.setSize(5);

        //获取总数据量
        int totalCount = ordersDao.getTotalOut();//中断
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
        if(totalCount ==0){
            start =0;
        }
        //查询当前页面下所有的用户信息
        List<Orders> list = ordersDao.findByPageOut(start,pageInfo.getSize());

        pageInfo.setList(list);
        return pageInfo;
    }

    @Override
    public PageInfo<Orders> searchIn(PageInfo pageInfo) {
        PageInfo<Orders> infos = new PageInfo<>();
        //获取每页的数据量
        infos.setSize(5);

        //获取总数据量
        int totalCount = ordersDao.getTotalSearchIn(pageInfo.getStart(),pageInfo.getOver());//中断
        infos.setTotalCount(totalCount);
        //获取总页数
        int totalPage = (int)Math.ceil(totalCount/(double)infos.getSize());
        infos.setTotalPage(totalPage);

        //判断当前页是否合理
        if(pageInfo.getCurrentPage()<1){
            infos.setCurrentPage(1);
        }else if(pageInfo.getCurrentPage()>totalPage){
            infos.setCurrentPage(totalPage);
        }else {
            infos.setCurrentPage(pageInfo.getCurrentPage());
        }

        int start = (infos.getCurrentPage()-1)*infos.getSize();
        if(totalCount ==0){
            start =0;
        }
        //查询当前页面下所有的用户信息
        List<Orders> list = ordersDao.searchIn(pageInfo.getStart(),pageInfo.getOver(),start,infos.getSize());


        infos.setList(list);
        infos.setStart(pageInfo.getStart());
        infos.setOver(pageInfo.getOver());
        return infos;
    }

    @Override
    public PageInfo<Orders> searchOut(PageInfo pageInfo) {
        PageInfo<Orders> infos = new PageInfo<>();
        //获取每页的数据量
        infos.setSize(5);

        //获取总数据量
        int totalCount = ordersDao.getTotalSearchOut(pageInfo.getStart(),pageInfo.getOver());//中断
        infos.setTotalCount(totalCount);
        //获取总页数
        int totalPage = (int)Math.ceil(totalCount/(double)infos.getSize());
        infos.setTotalPage(totalPage);

        //判断当前页是否合理
        if(pageInfo.getCurrentPage()<1){
            infos.setCurrentPage(1);
        }else if(pageInfo.getCurrentPage()>totalPage){
            infos.setCurrentPage(totalPage);
        }else {
            infos.setCurrentPage(pageInfo.getCurrentPage());
        }

        int start = (infos.getCurrentPage()-1)*infos.getSize();
        if(totalCount ==0){
            start =0;
        }
        //查询当前页面下所有的用户信息
        List<Orders> list = ordersDao.searchOut(pageInfo.getStart(),pageInfo.getOver(),start,infos.getSize());


        infos.setList(list);
        infos.setStart(pageInfo.getStart());
        infos.setOver(pageInfo.getOver());
        return infos;
    }
}
