package com.daeguro.order.service;

import com.daeguro.order.vo.orderVo;
import com.daeguro.user.vo.UserVO;

public class userOrderService implements orderService{
    @Override
    public int DlvrOrder(UserVO user, orderVo order) {
        return 0;
    }

    @Override
    public int PkgOrder(UserVO user, orderVo order) {
        return 0;
    }
}
