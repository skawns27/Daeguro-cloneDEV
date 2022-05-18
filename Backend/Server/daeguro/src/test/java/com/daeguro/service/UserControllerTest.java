package com.daeguro.service;

import com.daeguro.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootTest
@RestController
@RequestMapping("/")
public class UserControllerTest {
    @Autowired
    UserService userService;

    public
    @Test
    void 로그인_통합() {
        MockHttpServletRequest httpReq = new MockHttpServletRequest("POST", "/user/new");
        httpReq.addParameter("userName", "남준섭");
        httpReq.addParameter("userEm","skawns27@naver.com");
        httpReq.addParameter("userTel", "01033147959");
        httpReq.addParameter("userBirth", "1997-04-23");
        httpReq.addParameter("userGender", "M");
        httpReq.addParameter("userAddr","대구광역시 수성구 신매로51 229동 509호");

        /*Mock Req 생성 및 요청 */
        MockHttpServletResponse httpRes = new MockHttpServletResponse();


    }
}
