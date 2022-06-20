package com.service;
;
import com.domain.PageInfo;
import com.domain.User;
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


    public String getnameByid(Integer id);


    /**
     * 保存
     * @param warehouse
     * @return
     */
    public boolean save(Warehouse warehouse);

    /**
     * 获得页面的分页信息
     * @return
     */
    public PageInfo<Warehouse> findByPage(int currentPage);
}
