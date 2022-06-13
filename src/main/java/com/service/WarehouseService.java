package com.service;

import com.domain.Warehouse;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface WarehouseService {


    /**
     * 查询全部
     * @return
     */
    public List<Warehouse> getAll();
}
