package com.daeguro.common.vo;

import javax.persistence.*;

@Entity
@Table(schema = "storeTB")
public class storeVo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long storeId;
    private long catId;
    private long brandId;
    private String storeName;
    private String storeAddr;
    private String mop;
    private String ceoCmnt;
    private String storeRegDate;
    private String storeTel;
    private String storeBn;
    private String oed;
    private String dlvrMin; /*배달시 최소주문 금액*/
    private String dlvrFree; /*무료배달 주문금액*/
    private int dlvrTip; /*배달 팁*/
    private String dlvrLt; /**/
    private String toLt; /**/

    /*2022-02-16: 가게 조회 기능 */
    public storeVo(long storeId) {
        this.storeId = storeId;// DB
    }

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public long getCatId() {
        return catId;
    }

    public void setCatId(long catId) {
        this.catId = catId;
    }

    public long getBrandId() {
        return brandId;
    }

    public void setBrandId(long brandId) {
        this.brandId = brandId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddr() {
        return storeAddr;
    }

    public void setStoreAddr(String storeAddr) {
        this.storeAddr = storeAddr;
    }

    public String getMop() {
        return mop;
    }

    public void setMop(String mop) {
        this.mop = mop;
    }

    public String getCeoCmnt() {
        return ceoCmnt;
    }

    public void setCeoCmnt(String ceoCmnt) {
        this.ceoCmnt = ceoCmnt;
    }

    public String getStoreRegDate() {
        return storeRegDate;
    }

    public void setStoreRegDate(String storeRegDate) {
        this.storeRegDate = storeRegDate;
    }

    public String getStoreTel() {
        return storeTel;
    }

    public void setStoreTel(String storeTel) {
        this.storeTel = storeTel;
    }

    public String getStoreBn() {
        return storeBn;
    }

    public void setStoreBn(String storeBn) {
        this.storeBn = storeBn;
    }

    public String getOed() {
        return oed;
    }

    public void setOed(String oed) {
        this.oed = oed;
    }

    public String getDlvrMin() {
        return dlvrMin;
    }

    public void setDlvrMin(String dlvrMin) {
        this.dlvrMin = dlvrMin;
    }

    public String getDlvrFree() {
        return dlvrFree;
    }

    public void setDlvrFree(String dlvrFree) {
        this.dlvrFree = dlvrFree;
    }

    public int getDlvrTip() {
        return dlvrTip;
    }

    public void setDlvrTip(int dlvrTip) {
        this.dlvrTip = dlvrTip;
    }

    public String getDlvrLt() {
        return dlvrLt;
    }

    public void setDlvrLt(String dlvrLt) {
        this.dlvrLt = dlvrLt;
    }

    public String getToLt() {
        return toLt;
    }

    public void setToLt(String toLt) {
        this.toLt = toLt;
    }
}
