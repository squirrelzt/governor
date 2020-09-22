package com.governer.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCodeEnums {

    /**
     * 200， 成功
     */
    SUCCESS(200, "操作成功"),

    /**
     * -1000, 系统繁忙，请稍后再试！
     */
    FAIL(-1000, "系统繁忙，请稍后再试！"),

    /**
     * 401, 未授权
     */
    UNAUTHORIZED(401, "未经授权的访问"),

    /**
     * 403, 禁止
     */
    FORBIDDEN(403, "禁止"),

    /**
     * 500, 服务器错误
     */
    SERVER_ERROR(500, "服务器错误");

    private Integer code;
    private String message;

}
