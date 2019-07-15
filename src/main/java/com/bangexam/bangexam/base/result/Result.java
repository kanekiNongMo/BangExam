package com.bangexam.bangexam.base.result;

import lombok.Data;

import java.util.List;

/**
 * @author kaneki
 * @date 2019/7/13 17:16
 */
@Data
public class Result<T> {
    /**
     * 数据数量
     */
    int count;
    /**
     * 代码
     */
    Integer code;
    /**
     * 信息
     */
    String msg;
    /**
     * 返回数据
     */
    List<T> datas;
    /**
     * 任何类型条件
     */
    T data;

    private Result() {
    }

    private Result(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    private Result(Integer code, String msg, T data, Integer count, List<T> datas) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.count = count;
        this.datas = datas;
    }

    /**
     * 无数据传输的 成功返回
     *
     * @param <T> 任意类型
     * @return 成功返回
     */
    public static <T> Result<T> success() {
        return new Result<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage());
    }

    public static <T> Result<T> success(String msg) {
        return new Result<>(ResultCode.SUCCESS.getCode(), msg);
    }

    public static <T> Result<T> success(ResultCode resultCode) {
        return new Result<>(resultCode.getCode(), resultCode.getMessage());
    }

    /**
     * 单个数据传输的 成功返回
     *
     * @param data 数据
     * @param <T>  任意类型
     * @return 成功返回
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data, 0, null);
    }

    public static <T> Result<T> success(String msg, T data) {
        return new Result<>(ResultCode.SUCCESS.getCode(), msg, data, 0, null);
    }

    public static <T> Result<T> success(ResultCode resultCode, T data) {
        return new Result<>(resultCode.getCode(), resultCode.getMessage(), data, 0, null);
    }

    /**
     * 分页数据传输的 成功返回
     *
     * @param count 数量
     * @param datas 数据
     * @param <T>   任意类型
     * @return 成功返回
     */
    public static <T> Result<T> success(Integer count, List<T> datas) {
        return new Result<>(ResultCode.TABLE_SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), null, count, datas);
    }

    public static <T> Result<T> success(String msg, Integer count, List<T> datas) {
        return new Result<>(ResultCode.TABLE_SUCCESS.getCode(), msg, null, count, datas);
    }

    public static <T> Result<T> success(ResultCode resultCode, Integer count, List<T> datas) {
        return new Result<>(resultCode.getCode(), resultCode.getMessage(), null, count, datas);
    }

    /**
     * 无数据传输的 失败返回
     *
     * @param <T> 任意类型
     * @return 失败返回
     */
    public static <T> Result<T> failure() {
        return new Result<>(ResultCode.FAIL.getCode(), ResultCode.FAIL.getMessage());
    }

    public static <T> Result<T> failure(ResultCode resultCode) {
        return new Result<>(resultCode.getCode(), resultCode.getMessage());
    }

    public static <T> Result<T> failure(Integer code, String msg) {
        return new Result<>(code, msg);
    }

    public static Result ok() {
        return new Result();
    }
}
