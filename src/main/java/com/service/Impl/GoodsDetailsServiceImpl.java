package com.service.Impl;

import com.dao.GoodsDetailsDao;
import com.dao.UserDao;
import com.domain.Goods;
import com.domain.GoodsDetails;
import com.domain.PageInfo;
import com.domain.User;
import com.service.GoodsDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsDetailsServiceImpl implements GoodsDetailsService {

    @Autowired
    private GoodsDetailsDao goodsDetailsDao;
    @Override
    public boolean save(GoodsDetails goodsDetails) {
        return goodsDetailsDao.save(goodsDetails)>0;
    }

    @Override
    public boolean update(GoodsDetails goodsDetails) {
        return goodsDetailsDao.update(goodsDetails)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return goodsDetailsDao.delete(id)>0;
    }

    @Override
    public List<GoodsDetails> find(GoodsDetails goodsDetails) {
        return goodsDetailsDao.find(goodsDetails);
    }

//    @Override
//    public List<GoodsDetails> getAll() {
//        return goodsDetailsDao.getAll();
//    }


    @Override
    public List<GoodsDetails> getAll(Integer goods_id) {
        return goodsDetailsDao.getAll(goods_id);
    }

    @Override
    public List<GoodsDetails> getAllGoodsdetail() {
        return goodsDetailsDao.getAllgoodsdetail();
    }

    @Override
    public boolean UNIQUE(GoodsDetails goodsDetails) {
        return goodsDetailsDao.UNIQUEupdate(goodsDetails)>0;
    }

    @Override
    public GoodsDetails getbyid(Integer id) {
        return goodsDetailsDao.getbyid(id);
    }

    @Override
    public PageInfo<GoodsDetails> findByPage(int others_id,int currentPage) {
        PageInfo<GoodsDetails> pageInfo = new PageInfo<>();
        //获取每页的数据量
        pageInfo.setSize(5);

        //获取总数据量
        int totalCount = goodsDetailsDao.getTotal(others_id);//中断
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
        List<GoodsDetails> list = goodsDetailsDao.findByPage(others_id,start,pageInfo.getSize());

        pageInfo.setList(list);
        pageInfo.setOthers_id(others_id);
        return pageInfo;
    }

    @Override
    public PageInfo<GoodsDetails> search(int currentPage) {
        PageInfo<GoodsDetails> pageInfo = new PageInfo<>();
        //获取每页的数据量
        pageInfo.setSize(5);

        //获取总数据量
        int totalCount = goodsDetailsDao.searchTotal();//中断
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
        List<GoodsDetails> list = goodsDetailsDao.search(start,pageInfo.getSize());

        pageInfo.setList(list);
        return pageInfo;
    }




}
