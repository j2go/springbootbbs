package xyz.stg.bbs.controllers.dto;

/**
 * Created by shitiangao on 16/7/7.
 */
public class Result {
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_FAILED = 1;

    private int code;

    private String msg;

    private Object data;

    public Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result succeed(Object data) {
        return new Result(CODE_SUCCESS, null, data);
    }

    public static Result succeed() {
        return new Result(CODE_SUCCESS, null, null);
    }

    public static Result succeed(String msg, Object data) {
        return new Result(CODE_SUCCESS, msg, data);
    }

    public static Result succeed(String msg) {
        return new Result(CODE_SUCCESS, msg, null);
    }

    public static Result failed(String msg) {
        return new Result(CODE_FAILED, msg, null);
    }

    public static Result failed() {
        return new Result(CODE_FAILED, null, null);
    }

    public static Result failed(String msg, Object data) {
        return new Result(CODE_FAILED, msg, data);
    }

    public Object getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public int getCode() {
        return code;
    }

}
