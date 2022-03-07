package com.daeguro.service;

import com.daeguro.client.controller.userAcc.UserAccRes01;
import com.daeguro.client.dao.UserDao;
import com.daeguro.client.protocol.UserAccProto;
import com.daeguro.client.service.UserService;
import com.daeguro.client.vo.UserVo;
import com.daeguro.lib.CodeType;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.security.MessageDigest;

@SpringBootTest
@Transactional
public class userServiceTest {
    @Autowired UserService userService;
    @Autowired UserDao userDao;
    UserAccRes01 userAccRes01 = new UserAccRes01();
//    MessageDigest md = MessageDigest.getInstance("SHA-512");

    @Test
    @Rollback
    void 회원가입() {
        /*정상가입*/
        String pw = "";
        UserVo newUser = new UserVo("남준섭",
                "skawns27@naver.com",
                pw,
                "01033147959",
                "1997-04-23",
                'M',
                "대구광역시 수성구 신매로51 229동 509호" );

        UserAccRes01 res = userService.userAcc01(newUser);
        assertThat(res.getResCode()).isEqualTo(CodeType.OK);

        /*중복회원가입*/
        UserVo newUser2 = new UserVo("남준섭",
                "skawns27@naver.com",
                pw,
                "01033147959",
                "1997-04-23",
                'M',
                "대구광역시 수성구 신매로51 229동 509호" );

        UserAccRes01 res2 = userService.userAcc01(newUser);
        assertThat(res2.getResCode()).isEqualTo(CodeType.dupUser);

    }



    @Test
    void 회원기능_점검() {
        MockHttpServletRequest req = new MockHttpServletRequest();
    }

}
