package com.daeguro.order.service;

import com.daeguro.order.vo.orderVo;
import com.daeguro.order.vo.userVo;

public interface orderService {

    /**
     * 배달주문 서비스
     * @param userVo
     * @param orderVo
     * @version 2022-02-14
     */
    public int DlvrOrder(userVo user, orderVo order);

    /**
     * 포장주문 서비스
     * @param userVo
     * @param orderVo
     * @version 2022-02-14
     */
    public int PkgOrder(userVo user, orderVo order);
}
