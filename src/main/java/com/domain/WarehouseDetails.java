package com.domain;

public class WarehouseDetails {
    private int id;
    private int num;
    private int goods_details_id;
    private int warehouse_id;

    private String goods_name;
    private String goods_color;
    private String goods_size;

    @Override
    public String toString() {
        return "WarehouseDetails{" +
                "id=" + id +
                ", num=" + num +
                ", goods_details_id=" + goods_details_id +
                ", warehouse_id=" + warehouse_id +
                ", goods_name='" + goods_name + '\'' +
                ", goods_color='" + goods_color + '\'' +
                ", goods_size='" + goods_size + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getGoods_details_id() {
        return goods_details_id;
    }

    public void setGoods_details_id(int goods_details_id) {
        this.goods_details_id = goods_details_id;
    }

    public int getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(int warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
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
}
