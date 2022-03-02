package com.daeguro.common;

public class MsgType {

    public String OK;
    public String unKnownErr;
    public String dupUser;
    public String wrongPw;
    public String unValidReq;

    public MsgType() {
        this.OK = "결과처리 완료";
        this.unKnownErr = "알수없는 오류";
        this.dupUser = "중복사용자 신청";
        this.wrongPw = "잘못된 비밀번호";
        this.unValidReq = "허용되지 않은 요청";
    }

}
