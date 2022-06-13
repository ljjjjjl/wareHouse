package com.service.Impl;

import com.dao.GoodsDetailsDao;
import com.dao.UserDao;
import com.domain.GoodsDetails;
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
}
