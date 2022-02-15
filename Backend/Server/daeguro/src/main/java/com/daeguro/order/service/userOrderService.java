package com.daeguro.order.service;

import com.daeguro.order.vo.orderVo;
import com.daeguro.common.vo.userVo;

public class userOrderService implements orderService{
    @Override
    public int DlvrOrder(userVo user, orderVo order) {
        return 0;
    }

    @Override
    public int PkgOrder(userVo user, orderVo order) {
        return 0;
    }
}
