package com.lzlm.cn.controller;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.lzlm.cn.dto.role.AddRoleAuthDto;
import com.lzlm.cn.dto.role.AddRoleDto;
import com.lzlm.cn.dto.role.RoleAuthDto;
import com.lzlm.cn.service.role.RoleAuthService;
import com.lzlm.cn.service.role.RoleService;
import com.lzlm.cn.util.CommonResult;
import com.lzlm.cn.util.Rest;
import com.lzlm.cn.util.group.AddGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-12-01 16:46
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
@Api(tags = "角色接口", description = "角色管理")
@RestController
@RequestMapping("/sys/role")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleAuthService roleAuthService;

    @ApiOperation(value = "添加角色")
    @PostMapping("/addRole")
    public CommonResult addRole(@RequestBody @Validated(value = AddGroup.class) List<AddRoleDto> roleDtoList){
        boolean addResult = roleService.addRole(roleDtoList);
        if(addResult){
            return Rest.success("添加成功");
        }
        return Rest.fail("添加失败");
    }

    @ApiOperation(value = "添加角色权限")
    @PostMapping("/addRoleAuth")
    public CommonResult addRoleAuth(@RequestBody @Validated(value = AddGroup.class) List<AddRoleAuthDto> roleAuthDtoList){
        boolean addResult = roleAuthService.addRoleAuth(roleAuthDtoList);
        if(addResult){
            return Rest.success("添加成功");
        }
        return Rest.fail("添加失败");
    }

    @ApiOperation(value = "根据角色Id查询权限")
    @PostMapping("/getAuthByRoleId")
    @ApiImplicitParam(name = "roleId", value = "角色ID", required = true, dataType = "String", paramType = "query")
    public CommonResult getAuthByRoleId(@RequestParam(value = "roleId") String roleId){
        List<RoleAuthDto> roleAuthDtoList = roleAuthService.getAuthByRoleId(roleId);
        if(!CollectionUtils.isEmpty(roleAuthDtoList)){
            return Rest.successWithData(roleAuthDtoList);
        }
        return Rest.fail("未查询到权限信息");
    }


}
