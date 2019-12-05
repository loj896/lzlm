package com.lzlm.cn.util;

import org.springframework.util.StringUtils;

public class Rest {

    /**
     * 成功请求不带数据
     *
     * @return
     */
    public static CommonResult success() {
        return new CommonResult(Constant.RESCODE_SUCCESS, "success");
    }

    public static CommonResult success(String msg) {
        return new CommonResult(Constant.RESCODE_SUCCESS, msg);
    }

    /**
     * 成功请求带返回数据
     *
     * @param data
     * @return
     */
    public static CommonResult successWithData(Object data) {
        return new CommonResult(Constant.RESCODE_SUCCESS, data, "success");
    }

    /**
     * 失败请求带返回数据
     *
     * @param msg
     * @return
     */
    public static CommonResult fail(String msg) {
        return new CommonResult(Constant.RESCODE_FAILURE, msg);
    }

    /**
     * 失败请求带返回数据
     *
     * @param data
     * @return
     */
    public static CommonResult failWithData(Object data) {
        return new CommonResult(Constant.RESCODE_FAILURE, data, "fail");
    }

    /**
     * 参数缺失
     *
     * @return
     */
    public static CommonResult missingParameter(String msg) {
        if (!StringUtils.hasLength(msg)) {
            msg = "参数缺失";
        }
        return new CommonResult(Constant.RESCODE_MISSING_PARAMETER, msg);
    }


    /**
     * 服务器异常不带数据
     *
     * @return
     */
    public static CommonResult err() {
        return new CommonResult(Constant.RESCODE_EXCEPTION, "请稍后再试");
    }

    /**
     * 服务器异常带数据
     *
     * @param data
     * @return
     */
    public static CommonResult errWithData(Object data) {
        return new CommonResult(Constant.RESCODE_EXCEPTION, data, "请稍后再试");
    }

    /**
     * 服务器异常带数据和消息
     *
     * @param data
     * @return
     */
    public static CommonResult errWithData(String msg, Object data) {
        return new CommonResult(Constant.RESCODE_EXCEPTION, data, msg);
    }

    /**
     * 用户未登录
     *
     * @return
     */
    public static CommonResult noLogin() {
        return new CommonResult(Constant.RESCODE_NOLOGIN, "由于您长时间未进行操作，请重新登录");
    }

    /**
     * 成功请求带返回数据
     *
     * @param data
     * @return
     */
    public static CommonResult successWithMsgAndData(String msg , Object data) {
        return new CommonResult(Constant.RESCODE_SUCCESS , data , msg);
    }

}
