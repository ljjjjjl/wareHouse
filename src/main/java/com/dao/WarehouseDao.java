package com.dao;

import com.domain.Warehouse;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WarehouseDao {

    @Select("select *from warehouse")
    public List<Warehouse> getAll();
}
