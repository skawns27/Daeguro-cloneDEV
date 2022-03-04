package com.daeguro.client.controller.userAcc;


import com.daeguro.client.vo.UserVo;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter @Setter
public class UserAccRes02 {
    public char resCode;
    public String resMsg;
    private Optional<Long> userId;

}
