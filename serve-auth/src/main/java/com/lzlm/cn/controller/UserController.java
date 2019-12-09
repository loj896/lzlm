package com.lzlm.cn.controller;

import com.lzlm.cn.dto.user.AddUserRoleDto;
import com.lzlm.cn.dto.user.LoginDto;
import com.lzlm.cn.feign.SysFeignService;
import com.lzlm.cn.util.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-11-22 17:18
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
@RequestMapping("/lzlm/sys/user")
public class UserController {

    @Resource
    private SysFeignService sysFeignService;

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        //return userFeignService.hello(name);
        return "hello "+name+" this is serve-auth";
    }

    @GetMapping("/login")
    public String login(){
        //return userFeignService.hello(name);
        return "login method";
    }

    @ApiOperation(value = "根据用户名和密码查询用户信息")
    @PostMapping("/getUserByPwdAndName")
    public CommonResult getUserByPwdAndName(@RequestBody @Validated LoginDto loginDto){
        return sysFeignService.getUserByPwdAndName(loginDto);
    }

    @ApiOperation(value = "查询用户权限")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "String", paramType = "query")
    @PostMapping("/getUserAuth")
    public CommonResult getUserAuth(@RequestParam(value = "userId") String userId){
        return sysFeignService.getUserAuth(userId);
    }

    @ApiOperation(value = "添加用户角色")
    @PostMapping("/addUserRole")
    public CommonResult addUserRole(@RequestBody @Validated List<AddUserRoleDto> userRoleDtoList){
        return sysFeignService.addUserRole(userRoleDtoList);
    }

    @ApiOperation(value = "查询用户角色")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "String", paramType = "query")
    @PostMapping("/getUserRole")
    public CommonResult getUserRole(@RequestParam(value = "userId") String userId){
        return sysFeignService.getUserRole(userId);
    }

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public CommonResult login(@RequestBody @Validated LoginDto loginDto, Model model){
        //封装Token信息=用户名+密码
//        UsernamePasswordToken token = new UsernamePasswordToken(loginDto.getUserName(), loginDto.getPassword());
//
//        String info = null;
//        //获取Shiro Subject实例
//        Subject subject = SecurityUtils.getSubject();
//        try {
//            subject.login(token);
//            info = String.valueOf(subject.isAuthenticated());
//            model.addAttribute("info", "登录状态 ==> " + info);
//            return Rest.successWithData("/index");
//        } catch (UnknownAccountException e) {
//            e.printStackTrace();
//            info = "未知账户异常";
//        } catch (AuthenticationException e) {
//            e.printStackTrace();
//            info = "账户名或密码错误";
//        } catch (Exception e) {
//            e.printStackTrace();
//            info = "其他异常";
//        }
//        model.addAttribute("info", "登录状态 ==> " + info);
//        logger.info("登录状态 ==> {}", info);
//        return Rest.failWithData(info);
        return null;
    }
}
