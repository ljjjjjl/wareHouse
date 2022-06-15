package com.service.Impl;

import com.dao.GoodsDao;

import com.domain.Goods;
import com.domain.PageInfo;
import com.domain.User;
import com.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public boolean save(Goods goods) {
        return goodsDao.save(goods)>0;
    }

    @Override
    public boolean update(Goods goods) {
        return goodsDao.update(goods)>0;
    }

    @Override
    public boolean delete(Integer id) {
        goodsDao.andDelete(id);//这里如果删除出错，没有提示信息返回
        return goodsDao.delete(id)>0;
    }

    @Override
    public List<Goods> find(String keyword) {
        return goodsDao.find(keyword);
    }

    @Override
    public List<Goods> getAll() {
        return goodsDao.getAll();
    }

    @Override
    public Goods getById(Integer id) {
        return null;
    }

    @Override
    public boolean UNIQUE(Goods goods) {
        return false;
    }

    @Override
    public PageInfo<Goods> findByPage(int currentPage) {
        PageInfo<Goods> pageInfo = new PageInfo<>();
        //获取每页的数据量
        pageInfo.setSize(2);

        //获取总数据量
        int totalCount = goodsDao.getTotal();//中断
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
        List<Goods> list = goodsDao.findByPage(start,pageInfo.getSize());

        pageInfo.setList(list);
        return pageInfo;
    }

    @Override
    public PageInfo<Goods> search(String info, int currentPage) {
        PageInfo<Goods> pageInfo = new PageInfo<>();
        pageInfo.setInfo(info);
        //获取每页的数据量
        pageInfo.setSize(2);

        //获取总数据量
        int totalCount = goodsDao.searchTotal(info);//中断
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
        List<Goods> list = goodsDao.search(info,start,pageInfo.getSize());

        pageInfo.setList(list);
        return pageInfo;
    }
}
