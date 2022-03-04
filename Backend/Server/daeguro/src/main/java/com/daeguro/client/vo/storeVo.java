package com.daeguro.client.vo;

import lombok.Data;
import javax.persistence.*;

@Data
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

}
