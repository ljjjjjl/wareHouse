package com.dao;

import com.domain.Goods;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface GoodsDao {
    @Insert("insert into goods (goods_id,goods_name)values(#{goods_id},#{goods_name})")
    public int save(Goods goods);

    @Update("update goods set goods_id =#{goods_id},goods_name=#{goods_name} where id =#{id}")
    public int update(Goods goods);

//    @Delete("UPDATE goods  g1,goods_details  g2 " +
//            "SET g1.goods_status =1,g2.status=1  " +
//            "WHERE g1.id =#{id} AND g1.id =g2.goods_id; ")
    @Delete("update goods set goods_status =1 where id =#{id}")
    public int delete(Integer id);

    @Delete("update goods_details set status =1 where id =#{id}")
    public int andDelete(Integer id);



    @Select({"<script>" +
            "select *from goods where goods_status =0 " +
            "<if test=\"goods_name != null and goods_name!=''\">" +
            " and goods_name like concat('%',#{goods_name},'%')" +
            "</if> " +
            "<if test=\"goods_id != null and goods_id!=''\">" +
            " and goods_id like concat('%',#{goods_id},'%') " +
            "</if>"+
            "</script>"
    })
    public List<Goods> find(Goods goods);

    @Select("select *from goods where goods_status =0")
    public List<Goods> getAll();
}