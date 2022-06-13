package com.service;

import com.domain.Warehouse;

import java.util.List;

public interface WarehouseService {


    /**
     * 查询全部
     * @return
     */
    public List<Warehouse> getAll();
}
