package com.domain;

public class Goods {
    private int id;
    private String goods_id;
    private String goods_name;
    private String goods_status;

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goods_id='" + goods_id + '\'' +
                ", goods_name='" + goods_name + '\'' +
                ", goods_status='" + goods_status + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_status() {
        return goods_status;
    }

    public void setGoods_status(String goods_status) {
        this.goods_status = goods_status;
    }
}
