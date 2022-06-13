package com.dao;


import com.domain.GoodsDetails;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface GoodsDetailsDao {
    @Insert("insert into goods_details " +
            "(goods_color,goods_size,goods_id)" +
            "values(#{goods_color},#{goods_size},#{goods_id})")
    public int save(GoodsDetails goodsDetails);

    @Update("update goods_details set " +
            "goods_color =#{goods_color},goods_size=#{goods_size}" +
            "where id =#{id}")
    public int update(GoodsDetails goodsDetails);

    @Delete("update goods_details set status =1 where id =#{id}")
    public int delete(Integer id);


    @Select({"<script>" +
            "select *from goods_details where status =0 " +
            "<if test=\"goods_color != null\"> and goods_color like concat('%',#{goods_color},'%')</if> " +
            "<if test=\"goods_size != null\"> and goods_size like concat('%',#{goods_size},'%') </if>"+
            "</script>"
    })
    public List<GoodsDetails> find(GoodsDetails goodsDetails);

    @Select("select *from goods_details where goods_id =#{goods_id} and status =0")
    public List<GoodsDetails> getAll(Integer goods_id);
}
