package com.daeguro.common;

public class CodeType {
    public char OK;
    public char unKnownErr;
    public char dupUser;
    public char wrongPw;
    public char unValidReq;

    public CodeType() {
        this.OK = '0';
        this.unKnownErr = '1';
        this.dupUser = '2';
        this.wrongPw = '3';
        this.unValidReq = '4';
    }
}
