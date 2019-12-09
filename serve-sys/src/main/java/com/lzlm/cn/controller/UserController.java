package com.lzlm.cn.controller;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.lzlm.cn.dto.user.AddUserRoleListDto;
import com.lzlm.cn.dto.user.LoginDto;
import com.lzlm.cn.dto.user.UserAuthDto;
import com.lzlm.cn.dto.user.UserRoleDto;
import com.lzlm.cn.model.user.User;
import com.lzlm.cn.service.user.UserService;
import com.lzlm.cn.util.CommonResult;
import com.lzlm.cn.util.Rest;
import com.lzlm.cn.util.group.AddGroup;
import com.lzlm.cn.util.group.SelGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-11-22 17:07
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
@Api(tags = "用户接口", description = "用户管理")
@RestController
@RequestMapping("/sys/user")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "根据用户名和密码查询用户信息")
    @PostMapping("/getUserByPwdAndName")
    public CommonResult getUserByPwdAndName(@RequestBody @Validated(value = SelGroup.class) LoginDto loginDto){
        User user = userService.getUserByPwdAndName(loginDto);
        if(null != user){
            return Rest.successWithData(user);
        }
        return Rest.fail("未查询到用户信息");
    }

    @ApiOperation(value = "根据用户名查询用户信息")
    @PostMapping("/getUserByUserName")
    @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "String", paramType = "query")
    public CommonResult getUserByUserName(@RequestParam("userName") String userName){
        User user = userService.getUserByUserName(userName);
        if(null != user){
            return Rest.successWithData(user);
        }
        return Rest.fail("未查询到用户信息");
    }

    @ApiOperation(value = "查询用户权限")
    @PostMapping("/getUserAuth")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "String", paramType = "query")
    public CommonResult getUserAuth(@RequestParam("userId") String userId){
        List<UserAuthDto> authDtoList = userService.getUserAuth(userId);
        if(CollectionUtils.isEmpty(authDtoList)){
            return Rest.fail("未查询到用户权限信息");
        }
        return Rest.successWithData(authDtoList);
    }

    @ApiOperation(value = "新增用户角色")
    @PostMapping("/addUserRole")
    public CommonResult addUserRole(@RequestBody @Validated(value = AddGroup.class) AddUserRoleListDto roleListDto){
        boolean addResult = userService.addUserRole(roleListDto.getAddRoleList());
        if(addResult){
            return Rest.success("添加成功");
        }
        return Rest.fail("添加失败");
    }

    @ApiOperation(value = "查询用户拥有的角色")
    @PostMapping("/getUserRole")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "String", paramType = "query")
    public CommonResult getUserRole(@RequestParam("userId") String userId){
        List<UserRoleDto> userRoleDtoList = userService.getUserRole(userId);
        if(CollectionUtils.isEmpty(userRoleDtoList)){
            return Rest.fail("未查询到用户角色信息");
        }
        return Rest.successWithData(userRoleDtoList);
    }
}
