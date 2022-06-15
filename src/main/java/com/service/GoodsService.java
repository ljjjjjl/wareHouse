package com.service;

import com.domain.Goods;
import com.domain.PageInfo;
import com.domain.User;
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
     * @param keyword
     * @return
     */
    public List<Goods> find(String keyword);

    /**
     * 查询全部
     * @return
     */
    public List<Goods> getAll();

    public Goods getById(Integer id);

    public boolean UNIQUE(Goods goods);

    /**
     * 获得用户列表页面的分页信息
     * @return
     */
    public PageInfo<Goods> findByPage(int currentPage);

    /**
     * 多条件模糊查询
     * @return
     */
    public PageInfo<Goods> search(String info,int currentPage);
}
