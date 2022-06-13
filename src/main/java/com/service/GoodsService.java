package com.service;

import com.domain.Goods;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface GoodsService {
    /**
     * 保存
     * @param goods
     * @return
     */
    public boolean save(Goods goods);

    /**
     * 修改
     * @param goods
     * @return
     */
    public boolean update(Goods goods);

    /**
     * 按id删除
     * @param id
     * @return
     */
    public boolean delete(Integer id);

    /**
     * 查询
     * @param goods
     * @return
     */
    public List<Goods> find(Goods goods);

    /**
     * 查询全部
     * @return
     */
    public List<Goods> getAll();
}
