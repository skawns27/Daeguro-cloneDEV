package com.daeguro.order.vo;

import com.daeguro.common.vo.storeVo;

import javax.persistence.GeneratedValue;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class orderVo {
    @GeneratedValue()
    private long orderId;
    private long userId;
    private long storeId;
    private long sumPrice;
    private int totalPrice;
    private String orderDate;
    private String orderAddr;
    private String orderReq;
    private List<menuVo> orderMenu;

    /*getter*/
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

    public String getOrderDate() {
        return orderDate;
    }

    public String getOrderAddr() {
        return orderAddr;
    }

    public String getOrderReq() {
        return orderReq;
    }

    /*setter*/
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

    public void setTotalPrice() {
        this.totalPrice = 0;
    }

    /*주문접수 시간*/
    public void setOrderDate(Date orderDate) {
        Date nowTime = new Date();
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); //주문시간
        this.orderDate = timeFormat.format(nowTime);
    }

    public void setOrderAddr(String orderAddr) {
        this.orderAddr = orderAddr;
    }

    public void setOrderReq(String orderReq) {
        this.orderReq = orderReq;
    }
}
