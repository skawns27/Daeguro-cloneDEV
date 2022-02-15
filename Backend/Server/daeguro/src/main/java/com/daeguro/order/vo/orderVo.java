package com.daeguro.order.vo;

import java.util.Date;
import java.util.List;

public class orderVo {
    private long orderId;
    private long userId;
    private long storeId;
    private long sumPrice;
    private int totalPrice;
    private Date orderDate;
    private String orderAddr;
    private String orderReq;
    private List<menuVo> orderMenu;


    public long getOrderId() {
        return orderId;
    }

    public long getUserId() {
        return userId;
    }

    public long getStoreId() {
        return storeId;
    }

    public long getSumPrice() {
        return sumPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getOrderAddr() {
        return orderAddr;
    }

    public String getOrderReq() {
        return orderReq;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public void setSumPrice(long sumPrice) {
        this.sumPrice = sumPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderAddr(String orderAddr) {
        this.orderAddr = orderAddr;
    }

    public void setOrderReq(String orderReq) {
        this.orderReq = orderReq;
    }
}
