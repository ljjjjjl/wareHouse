package com.service;

import com.domain.GoodsDetails;
import com.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface GoodsDetailsService {
    /**
     * 保存
     * @param goodsDetails
     * @return
     */
    public boolean save(GoodsDetails goodsDetails);

    /**
     * 修改
     * @param goodsDetails
     * @return
     */
    public boolean update(GoodsDetails goodsDetails);

    /**
     * 按id删除
     * @param id
     * @return
     */
    public boolean delete(Integer id);

    /**
     * 按id查询
     * @param goodsDetails
     * @return
     */
    public List<GoodsDetails> find(GoodsDetails goodsDetails);
//
//    /**
//     * 查询全部相同goods_id
//     * @return
//     */
//    public List<GoodsDetails> getAll();

    public List<GoodsDetails> getAll(Integer goods_id);
}
