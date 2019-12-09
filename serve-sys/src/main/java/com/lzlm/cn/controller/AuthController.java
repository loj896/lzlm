package com.lzlm.cn.controller;

import com.lzlm.cn.dto.auth.AddAuthListDto;
import com.lzlm.cn.dto.auth.SelAuthClientDto;
import com.lzlm.cn.model.auth.AuthClientDetails;
import com.lzlm.cn.service.auth.AuthService;
import com.lzlm.cn.util.CommonResult;
import com.lzlm.cn.util.Rest;
import com.lzlm.cn.util.group.AddGroup;
import com.lzlm.cn.util.group.SelGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-11-27 10:46
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
@Api(tags = "权限接口", description = "权限管理")
@RestController
@RequestMapping("/sys/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @ApiOperation(value = "添加权限")
    @PostMapping("/addAuth")
    public CommonResult addAuth(@RequestBody @Validated(value = AddGroup.class) AddAuthListDto authDtoList){
        boolean addResult = authService.addAuth(authDtoList.getAddAuthDtoList());
        if(addResult){
            return Rest.success("添加成功");
        }
        return Rest.fail("添加失败");
    }

    @ApiOperation(value = "获取权限认证")
    @PostMapping("/getAuthClient")
    public CommonResult getAuthClient(@RequestBody @Validated(value = SelGroup.class) SelAuthClientDto clientDto){
        AuthClientDetails clientDetails = authService.getAuthClient(clientDto);
        if(null != clientDetails){
            return Rest.successWithData(clientDetails);
        }
        return Rest.fail("未查询到权限认证信息");
    }


}
