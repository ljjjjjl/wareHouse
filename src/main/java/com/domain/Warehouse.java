package com.domain;

public class Warehouse {
    private int id;
    private String warehouse_id;
    private String warehouse_name;


    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", warehouse_id='" + warehouse_id + '\'' +
                ", warehouse_name='" + warehouse_name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(String warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public String getWarehouse_name() {
        return warehouse_name;
    }

    public void setWarehouse_name(String warehouse_name) {
        this.warehouse_name = warehouse_name;
    }
}
