package com.lzlm.cn.util;

/**
 * 标准数据返回格式
 */
public class CommonResult {

    private int code = Constant.RESCODE_SUCCESS;

    private Object data;

    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "CommonResult [code=" + code + ", data=" + data + ", msg=" + msg
                 + "]";
    }

    public CommonResult() {
    }

    public CommonResult(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public CommonResult(int code, Object data, String msg) {
        super();
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

}
