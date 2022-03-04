package com.daeguro.order.service;

import com.daeguro.order.vo.orderVo;
import com.daeguro.client.vo.UserVo;

public interface orderService {

    /**
     * 배달주문 서비스
     * @param user
     * @param order
     * @version 2022-02-14
     */
    public int DlvrOrder(UserVo user, orderVo order);

    /**
     * 포장주문 서비스
     * @param user
     * @param order
     * @version 2022-02-14
     */
    public int PkgOrder(UserVo user, orderVo order);
}
