package com.service.Impl;

import com.dao.WarehouseDetailsDao;
import com.domain.WarehouseDetails;
import com.service.WarehouseDetailsService;
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
        return warehouseDetailsDao.uniqueId(warehouseDetails);
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

}
