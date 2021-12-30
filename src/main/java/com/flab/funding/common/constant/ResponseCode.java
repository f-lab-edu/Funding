package com.flab.funding.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCode {
    SUCCESS(200, "성공"),
    NO_USER_EXIST(400, "해당 아이디가 존재하지 않습니다."),
    WRONG_PASSWORD(400, "패스워드가 올바르지 않습니다."),
    INTERNAL_SERVER_ERROR(500, "시스템 오류가 발생했습니다. 잠시 후에 다시 시도해주세요.");

    private int resCd;
    private String resMsg;

}
