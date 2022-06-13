package com.service.Impl;

import com.dao.WarehouseDao;
import com.domain.Warehouse;
import com.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseDao warehouseDao;
    @Override
    public List<Warehouse> getAll() {
        return warehouseDao.getAll();
    }
}
