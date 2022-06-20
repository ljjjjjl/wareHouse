package com.dao;

import com.domain.WarehouseDetails;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface WarehouseDetailsDao {
    @Select("select *from warehouse_details where warehouse_id =#{warehouse_id}")
    public List<WarehouseDetails> getAll(Integer warehouse_id);

    @Select("select count(*) from warehouse_details where goods_details_id =#{goods_details_id} and warehouse_id =#{warehouse_id}")
    public int unique(WarehouseDetails warehouseDetails);
    @Select("select id from warehouse_details where goods_details_id =#{goods_details_id} and warehouse_id =#{warehouse_id}")
    public int uniqueId(WarehouseDetails warehouseDetails);
    @Select("select num from warehouse_details where id =#{id} ")
    public int selectNum(WarehouseDetails warehouseDetails);
    @Update("update warehouse_details set num =#{num} where id =#{id}")
    public boolean updateNum(WarehouseDetails warehouseDetails);
    @Insert("insert into warehouse_details " +
            "(num,goods_details_id,warehouse_id)" +
            "values(#{num},#{goods_details_id},#{warehouse_id})")
    public int save(WarehouseDetails warehouseDetails);


    @Select("select count(*) from warehouse_details where warehouse_id =#{warehouse_id} ")
    int getTotal(int warehouse_id);
    @Select("select * from warehouse_details where warehouse_id =#{warehouse_id}  limit #{start},#{size}")
    List<WarehouseDetails> findByPage(@Param("warehouse_id")int warehouse_id, @Param("start") int start, @Param("size") int size);
}
