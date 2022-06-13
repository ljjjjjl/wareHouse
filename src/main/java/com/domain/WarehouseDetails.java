package com.domain;

public class WarehouseDetails {
    private int id;
    private int num;
    private int goods_details_id;
    private int warehouse_id;

    @Override
    public String toString() {
        return "WarehouseDetails{" +
                "id=" + id +
                ", num=" + num +
                ", goods_details_id=" + goods_details_id +
                ", warehouse_id=" + warehouse_id +
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
}
