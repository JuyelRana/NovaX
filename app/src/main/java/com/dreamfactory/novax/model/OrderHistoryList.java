package com.dreamfactory.novax.model;

public class OrderHistoryList {

    private int img_order_history;
    private String txt_product_name_history_order, txt_order_history_date, txt_Direction, txt_Type, txt_Quantity, txt_LimitPrice, txt_ExpiryDate;
    private String type;

    public OrderHistoryList() {
    }

    public OrderHistoryList(String txt_product_name_history_order, String txt_order_history_date, String txt_Direction, String txt_Type, String txt_Quantity, String txt_LimitPrice, String txt_ExpiryDate,String type) {
        this.txt_product_name_history_order = txt_product_name_history_order;
        this.txt_order_history_date = txt_order_history_date;
        this.txt_Direction = txt_Direction;
        this.txt_Type = txt_Type;
        this.txt_Quantity = txt_Quantity;
        this.txt_LimitPrice = txt_LimitPrice;
        this.txt_ExpiryDate = txt_ExpiryDate;
        this.type = type;
    }

    public int getImg_order_history() {
        return img_order_history;
    }

    public String getTxt_product_name_history_order() {
        return txt_product_name_history_order;
    }

    public String getTxt_order_history_date() {
        return txt_order_history_date;
    }

    public String getTxt_Direction() {
        return txt_Direction;
    }

    public String getTxt_Type() {
        return txt_Type;
    }

    public String getTxt_Quantity() {
        return txt_Quantity;
    }

    public String getTxt_LimitPrice() {
        return txt_LimitPrice;
    }

    public String getTxt_ExpiryDate() {
        return txt_ExpiryDate;
    }

    public String getType() {
        return type;
    }
}
