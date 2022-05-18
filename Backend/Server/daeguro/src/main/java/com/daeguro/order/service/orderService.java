package com.daeguro.order.service;

import com.daeguro.order.vo.orderVo;
import com.daeguro.user.vo.UserVO;

public interface orderService {

    /**
     * 배달주문 서비스
     * @param user
     * @param order
     * @version 2022-02-14
     */
    public int DlvrOrder(UserVO user, orderVo order);

    /**
     * 포장주문 서비스
     * @param user
     * @param order
     * @version 2022-02-14
     */
    public int PkgOrder(UserVO user, orderVo order);
}
