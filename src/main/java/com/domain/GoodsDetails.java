package com.domain;

public class GoodsDetails {
    private int id;
    private String goods_color;
    private String goods_size;
    private int goods_id;
    private String status;

    @Override
    public String toString() {
        return "GoodsDetails{" +
                "id=" + id +
                ", goods_color='" + goods_color + '\'' +
                ", goods_size='" + goods_size + '\'' +
                ", goods_id=" + goods_id +
                ", status='" + status + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoods_color() {
        return goods_color;
    }

    public void setGoods_color(String goods_color) {
        this.goods_color = goods_color;
    }

    public String getGoods_size() {
        return goods_size;
    }

    public void setGoods_size(String goods_size) {
        this.goods_size = goods_size;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
