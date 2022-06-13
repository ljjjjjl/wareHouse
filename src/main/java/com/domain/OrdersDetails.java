package com.domain;

public class OrdersDetails {
    private int id;
    private int amount;
    private int goods_details_id;
    private int orders_id;
    private String status;


    @Override
    public String toString() {
        return "OrdersDetails{" +
                "id=" + id +
                ", amount=" + amount +
                ", goods_details_id=" + goods_details_id +
                ", orders_id=" + orders_id +
                ", status='" + status + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getGoods_details_id() {
        return goods_details_id;
    }

    public void setGoods_details_id(int goods_details_id) {
        this.goods_details_id = goods_details_id;
    }

    public int getOrders_id() {
        return orders_id;
    }

    public void setOrders_id(int orders_id) {
        this.orders_id = orders_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
