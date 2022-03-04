package com.daeguro.order.service;

import com.daeguro.order.vo.orderVo;
import com.daeguro.client.vo.UserVo;

public class userOrderService implements orderService{
    @Override
    public int DlvrOrder(UserVo user, orderVo order) {
        return 0;
    }

    @Override
    public int PkgOrder(UserVo user, orderVo order) {
        return 0;
    }
}
