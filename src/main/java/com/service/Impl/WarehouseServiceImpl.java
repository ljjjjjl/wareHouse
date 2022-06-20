package com.service.Impl;

import com.controller.result.Code;
import com.controller.result.RandomString;
import com.dao.WarehouseDao;
import com.domain.PageInfo;
import com.domain.User;
import com.domain.Warehouse;
import com.exception.SqlException;
import com.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseDao warehouseDao;
    private RandomString randomString;

    @Override
    public List<Warehouse> getAll() {
        return warehouseDao.getAll();
    }

    @Override
    public String getnameByid(Integer id) {
        return warehouseDao.getnameByid(id);
    }

    @Override
    public PageInfo<Warehouse> findByPage(int currentPage) {
        PageInfo<Warehouse> pageInfo = new PageInfo<>();
        //获取每页的数据量
        pageInfo.setSize(5);

        //获取总数据量
        int totalCount = warehouseDao.getTotal();//中断
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
        List<Warehouse> list = warehouseDao.findByPage(start,pageInfo.getSize());

        pageInfo.setList(list);
        return pageInfo;
    }

    @Override
    public boolean save(Warehouse warehouse) {
        int flag =warehouseDao.save(warehouse);
        if (flag>0){
            warehouse.setId(warehouseDao.maxId());
            //生成随机数
            warehouse.setWarehouse_id(randomString.getRandomString(5)+warehouse.getId());
            flag =warehouseDao.update(warehouse);
        }else {
            throw new SqlException(Code.SQL_ADDGOODS_ERR,"新添仓库失败");
        }
        return flag>0;
    }
}
