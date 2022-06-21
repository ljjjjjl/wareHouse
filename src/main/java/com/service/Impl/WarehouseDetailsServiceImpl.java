package com.service.Impl;

import com.controller.result.Code;
import com.dao.WarehouseDetailsDao;
import com.domain.GoodsDetails;
import com.domain.PageInfo;
import com.domain.WarehouseDetails;
import com.exception.SqlException;
import com.service.WarehouseDetailsService;
import org.apache.ibatis.binding.BindingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseDetailsServiceImpl implements WarehouseDetailsService {
    @Autowired
    WarehouseDetailsDao warehouseDetailsDao;
    @Override
    public List<WarehouseDetails> getAll(Integer warehouse_id) {
        return warehouseDetailsDao.getAll(warehouse_id);
    }

    @Override
    public boolean unique(WarehouseDetails warehouseDetails) {
        return warehouseDetailsDao.unique(warehouseDetails)>0;
    }
    @Override
    public int uniqueId(WarehouseDetails warehouseDetails) {
        int id;
        try{
            id = warehouseDetailsDao.uniqueId(warehouseDetails);
        }catch (BindingException e){
            throw new SqlException(Code.SQL_LESSTHANZERO_ERR,"该仓库无此货品");
        }
        return id;
    }

    @Override
    public int selectNum(WarehouseDetails warehouseDetails) {
        return warehouseDetailsDao.selectNum(warehouseDetails);
    }

    @Override
    public boolean updateNum(WarehouseDetails warehouseDetails) {

        return warehouseDetailsDao.updateNum(warehouseDetails);
    }

    @Override
    public boolean save(WarehouseDetails warehouseDetails) {
        return warehouseDetailsDao.save(warehouseDetails)>0;
    }

    @Override
    public PageInfo<WarehouseDetails> findByPage(int others_id, int currentPage) {
        PageInfo<WarehouseDetails> pageInfo = new PageInfo<>();
        //获取每页的数据量
        pageInfo.setSize(5);

        //获取总数据量
        int totalCount = warehouseDetailsDao.getTotal(others_id);//中断
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
        List<WarehouseDetails> list = warehouseDetailsDao.findByPage(others_id,start,pageInfo.getSize());

        pageInfo.setList(list);
        pageInfo.setOthers_id(others_id);
        return pageInfo;
    }


}
