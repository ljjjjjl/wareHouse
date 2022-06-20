package com.dao;

import com.domain.Goods;
import com.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface GoodsDao {
//    @Insert("insert into goods (goods_id,goods_name)values(#{goods_id},#{goods_name})")
    @Insert("insert into goods (goods_name)values(#{goods_name})")
    public int save(Goods goods);
    @Select("select max(id) from goods")
    public int maxId();

    @Update("update goods set goods_id =#{goods_id},goods_name=#{goods_name} where id =#{id}")
    public int update(Goods goods);

//    @Delete("UPDATE goods  g1,goods_details  g2 " +
//            "SET g1.goods_status =1,g2.status=1  " +
//            "WHERE g1.id =#{id} AND g1.id =g2.goods_id; ")
    @Delete("update goods set goods_status =1 where id =#{id}")
    public int delete(Integer id);

    @Delete("update goods_details set status =1 where id =#{id}")
    public int andDelete(Integer id);



//    @Select({"<script>" +
//            "select *from goods where goods_status =0 " +
//            "<if test=\"goods_name != null and goods_name!=''\">" +
//            " and goods_name like concat('%',#{goods_name},'%')" +
//            "</if> " +
//            "<if test=\"goods_id != null and goods_id!=''\">" +
//            " and goods_id like concat('%',#{goods_id},'%') " +
//            "</if>"+
//            "</script>"
//    })
    @Select("select *from goods where goods_status =0 and (goods_name like concat('%',#{keyword},'%') " +
            "or goods_id like concat('%',#{keyword},'%') or id like concat('%',#{keyword},'%'))")
    public List<Goods> find(String keyword);

    @Select("select *from goods where goods_status =0")
    public List<Goods> getAll();

    @Select("select *from goods where goods_status =0 and id = #{id}")
    public Goods getById(Integer id);

    @Select("SELECT COUNT(id) FROM goods WHERE goods_id=#{goods_id} and goods_status=0")
    int UNIQUE(Goods goods);

    @Select("SELECT COUNT(id) FROM goods WHERE goods_id=#{goods_id} and goods_status=0 and id!=#{id}")
    int UNIQUEUpdate(Goods goods);

    @Select("select count(*) from goods where goods_status =0")
    int getTotal();
    @Select("select * from goods where goods_status =0 limit #{start},#{size}")
    List<Goods> findByPage(@Param("start") int start, @Param("size") int size);

    @Select("select count(*) from goods where goods_status =0 and " +
            "(goods_name like concat('%',#{keyword},'%') " +
            "or goods_id like concat('%',#{keyword},'%') or id like concat('%',#{keyword},'%'))")
    int searchTotal(String keyword);
    @Select("select * from goods where goods_status =0 and " +
            "(goods_name like concat('%',#{keyword},'%') " +
            "or goods_id like concat('%',#{keyword},'%') or id like concat('%',#{keyword},'%'))" +
            "limit #{start},#{size}")
    List<Goods> search(@Param("keyword")String keyword,@Param("start") int start,@Param("size") int size);

}
