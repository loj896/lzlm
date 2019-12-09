package com.lzlm.cn.feign.fallback;

import com.lzlm.cn.dto.auth.AddAuthDto;
import com.lzlm.cn.dto.auth.SelAuthClientDto;
import com.lzlm.cn.dto.user.AddUserRoleDto;
import com.lzlm.cn.dto.user.LoginDto;
import com.lzlm.cn.feign.SysFeignService;
import com.lzlm.cn.util.CommonResult;
import com.lzlm.cn.util.Rest;
import org.springframework.stereotype.Component;

import java.util.List;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-11-25 9:42
 *           '::::::::::::'           @description
 *             .:::::::::: 
 *        '::::::::::::::.. 
 *             ..::::::::::::. 
 *           ``:::::::::::::::: 
 *            ::::``:::::::::'        .:::. 
 *           ::::'   ':::::'       .::::::::. 
 *         .::::'      ::::     .:::::::'::::. 
 *        .:::'       :::::  .:::::::::' ':::::. 
 *       .::'        :::::.:::::::::'      ':::::. 
 *      .::'         ::::::::::::::'         ``::::. 
 *  ...:::           ::::::::::::'              ``::. 
 * ```` ':.          ':::::::::'                  ::::.. 
 *                    '.:::::'                    ':'````.. 
 */
@Component
public class SysFeignServiceFallImpl implements SysFeignService {

    @Override
    public String hello(String name) {
        return "hello "+ name+" this is serve-auth , request error";
    }

    @Override
    public CommonResult getUserByPwdAndName(LoginDto loginDto) {
        return Rest.fail("查询失败，网路异常");
    }

    @Override
    public CommonResult addAuth(List<AddAuthDto> authDtoList) {
        return Rest.fail("查询失败，网路异常");
    }

    @Override
    public CommonResult getAuthClient(SelAuthClientDto clientDto) {
        return Rest.fail("查询失败，网路异常");
    }

    @Override
    public CommonResult getAuthByRoleId(String roleId) {
        return Rest.fail("查询失败，网路异常");
    }

    @Override
    public CommonResult getUserAuth(String userId) {
        return Rest.fail("查询失败，网路异常");
    }

    @Override
    public CommonResult addUserRole(List<AddUserRoleDto> userRoleDtoList) {
        return Rest.fail("查询失败，网路异常");
    }

    @Override
    public CommonResult getUserRole(String userId) {
        return Rest.fail("查询失败，网路异常");
    }
}
