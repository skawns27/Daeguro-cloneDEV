package com.daeguro.service;
import com.daeguro.user.service.UserService;
import com.daeguro.user.vo.UserVO;
import com.daeguro.lib.CodeType;

import static org.assertj.core.api.Assertions.assertThat;

import com.daeguro.lib.MsgType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.HashMap;


@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;
//    MessageDigest md = MessageDigest.getInstance("SHA-512");
    /*20220517: DB연결 에러 발견 및 워크벤치 업데이트 후 해결*/

    @Test
    @Transactional
    @Rollback
    void 회원가입() {
        /*정상가입 */

        String pw = "";
        UserVO newUser = new UserVO(
                null,
                "남준섭",
                "skawns27@naver.com",
                pw,
                "01033147959",
                "1997-04-23",
                'M',
                "대구광역시 수성구 신매로51 229동 509호");

        HashMap<String, Object> res = userService.userAcc01(newUser);
        assertThat(res.get("resCode")).isEqualTo(CodeType.OK);
        assertThat(res.get("userId")).isEqualTo(newUser.getUserId());

        /*중복회원가입*/

        UserVO newUser2 = new UserVO(
                null,
                "남준섭",
                "skawns27@naver.com",
                pw,
                "01033147959",
                "1997-04-23",
                'M',
                "대구광역시 수성구 신매로51 229동 509호");

        HashMap<String, Object> res2 = userService.userAcc01(newUser);
        assertThat(res2.get("resCode")).isEqualTo(CodeType.dupUser);
    }

    @Test
    @Transactional
    @Rollback
    void 로그인_정보_업데이트() {
        UserVO loginUserVO = new UserVO();
        loginUserVO.setUserEm("skawns27@naver.com");
        loginUserVO.setUserPw("1234");

        /*로그인*/
        HashMap<String, Object> res = userService.userAcc02(loginUserVO);
        assertThat(res.get("resCode")).isEqualTo(MsgType.OK); //결과코드 확인
        assertThat(res.get("resMsg")).isEqualTo(loginUserVO.getUserId()); //결과 사용자 ID 확인


        /* *//*미등록 로그인*//*
        UserAccReq02 loginReq1 = new UserAccReq02();
        loginReq1.setUserEm("skawns28@naver.com");
        loginReq1.setUserPw("1234");
        UserAccRes02 loginRes = userService.userAcc02(loginReq1.getUserEm(), loginReq1.getUserPw(), "04");
        assertThat(loginRes.getResCode()).isEqualTo(CodeType.noUserData);*/

        /*틀린 비밀번호*/
        /*UserAccReq02 loginReq2 = new UserAccReq02();
        loginReq2.setUserEmail("skawns27@naver.com");
        loginReq2.setUserPw("1234");
        loginRes = userService.userAcc02(loginReq2.getUserEmail(), loginReq2.getUserPw());
        assertThat(loginRes.getResCode()).isEqualTo(CodeType.wrongPw);
*/
        /*초기 로그인*/
      /*  UserAccReq02 loginReq3 = new UserAccReq02();
        loginReq3.setUserEmail("skawns27@naver.com");
        loginReq3.setUserPw("4321");
        loginRes = userService.userAcc02(loginReq3.getUserEmail(), loginReq3.getUserPw());
        assertThat(loginRes.getResCode()).isEqualTo(CodeType.OK);*/
    }
}
