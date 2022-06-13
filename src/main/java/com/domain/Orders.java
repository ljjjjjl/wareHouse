package com.domain;

import java.sql.Timestamp;

public class Orders {
    private int id;
    private String orders_id;
    private String orders_type;
    private String orders_address;
    private Timestamp orders_date;
    private String orders_note;
    private int warehouse_id;
    private int user_id;
    private String orders_status;


    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", orders_id='" + orders_id + '\'' +
                ", orders_type='" + orders_type + '\'' +
                ", orders_address='" + orders_address + '\'' +
                ", orders_date=" + orders_date +
                ", orders_note='" + orders_note + '\'' +
                ", warehouse_id=" + warehouse_id +
                ", user_id=" + user_id +
                ", order_status='" + orders_status + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrders_id() {
        return orders_id;
    }

    public void setOrders_id(String orders_id) {
        this.orders_id = orders_id;
    }

    public String getOrders_type() {
        return orders_type;
    }

    public void setOrders_type(String orders_type) {
        this.orders_type = orders_type;
    }

    public String getOrders_address() {
        return orders_address;
    }

    public void setOrders_address(String orders_address) {
        this.orders_address = orders_address;
    }

    public Timestamp getOrders_date() {
        return orders_date;
    }

    public void setOrders_date(Timestamp orders_date) {
        this.orders_date = orders_date;
    }

    public String getOrders_note() {
        return orders_note;
    }

    public void setOrders_note(String orders_note) {
        this.orders_note = orders_note;
    }

    public int getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(int warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getOrder_status() {
        return orders_status;
    }

    public void setOrder_status(String orders_status) {
        this.orders_status = orders_status;
    }
}
