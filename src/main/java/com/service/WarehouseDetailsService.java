package com.service;

import com.domain.WarehouseDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface WarehouseDetailsService {

    /**
     * 查询全部
     * @return
     */
    public List<WarehouseDetails> getAll(Integer warehouse_id);

    /**
     * 查询重复
     * @return
     */
    public boolean unique(WarehouseDetails warehouseDetails);

    /**
     * 显示独特id
     * @return
     */
    public int uniqueId(WarehouseDetails warehouseDetails);

    /**
     * 查看库存
     * @return
     */
    public int selectNum(WarehouseDetails warehouseDetails);

    /**
     * 修改库存
     * @return
     */
    public boolean updateNum(WarehouseDetails warehouseDetails);

    /**
     * 添加
     * @return
     */
    public boolean save(WarehouseDetails warehouseDetails);
}
