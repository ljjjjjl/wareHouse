package com.service.Impl;

import com.dao.GoodsDao;

import com.domain.Goods;
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
    public List<Goods> find(Goods goods) {
        return goodsDao.find(goods);
    }

    @Override
    public List<Goods> getAll() {
        return goodsDao.getAll();
    }
}
