package com.lzlm.cn.feign.fallback;

import com.lzlm.cn.dto.auth.AddAuthListDto;
import com.lzlm.cn.dto.auth.SelAuthClientDto;
import com.lzlm.cn.dto.user.AddUserRoleListDto;
import com.lzlm.cn.dto.user.LoginDto;
import com.lzlm.cn.feign.SysFeignService;
import com.lzlm.cn.util.CommonResult;
import com.lzlm.cn.util.Rest;
import org.springframework.stereotype.Component;

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
        return Rest.fail("根据用户名和密码查询用户失败，网路异常");
    }

    @Override
    public CommonResult getUserByUserName(String userName) {
        return Rest.fail("根据用户名查询用户失败，网路异常");
    }

    @Override
    public CommonResult addAuth(AddAuthListDto authDtoList) {
        return Rest.fail("添加权限失败，网路异常");
    }

    @Override
    public CommonResult getAuthClient(SelAuthClientDto clientDto) {
        return Rest.fail("查询用户授权信息失败，网路异常");
    }

    @Override
    public CommonResult getAuthByRoleId(String roleId) {
        return Rest.fail("根据角色ID查询权限失败，网路异常");
    }

    @Override
    public CommonResult getUserAuth(String userId) {
        return Rest.fail("查询用户权限失败，网路异常");
    }

    @Override
    public CommonResult addUserRole( AddUserRoleListDto roleListDto) {
        return Rest.fail("添加用户角色失败，网路异常");
    }

    @Override
    public CommonResult getUserRole(String userId) {
        return Rest.fail("查询用户角色失败，网路异常");
    }
}
