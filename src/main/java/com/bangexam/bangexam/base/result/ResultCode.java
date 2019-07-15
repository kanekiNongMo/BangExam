package com.bangexam.bangexam.base.result;

/**
 * @author kaneki
 * @date 2019/7/13 17:11
 */
public enum ResultCode {
    /**
     * 返回状态码及信息
     */
    SUCCESS(200, "成功"),
    TABLE_SUCCESS(0, "请求成功"),
    FAIL(500, "失败"),
    USER_LOGIN_USERNAME_ERROR(500201, "登录失败，用户名不存在，请重新输入"),
    USER_LOGIN_PASSWORD_ERROR(500202, "登录失败，密码错误，请重新输入"),
    IP_TIMEOUT(500105, "你的请求过于频繁，请1分钟后再试。");

    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
