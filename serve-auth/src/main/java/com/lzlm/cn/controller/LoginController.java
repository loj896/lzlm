package com.lzlm.cn.controller;

import com.lzlm.cn.dto.user.LoginDto;
import com.lzlm.cn.feign.SysFeignService;
import com.lzlm.cn.model.user.User;
import com.lzlm.cn.util.BeanConvert;
import com.lzlm.cn.util.CommonResult;
import com.lzlm.cn.util.Rest;
import com.lzlm.cn.util.group.SelGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
@Api(tags = "登录接口", description = "用户登录")
@RestController
@RequestMapping("/login")
public class LoginController {

    @Resource
    private SysFeignService sysFeignService;

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public CommonResult login(@RequestBody @Validated(value = SelGroup.class) LoginDto loginDto){
        CommonResult rest = sysFeignService.getUserByPwdAndName(loginDto);
        User user = BeanConvert.beanConvert(rest.getData(), User.class);
        if(null != user){
            InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
            UserDetails details = org.springframework.security.core.userdetails.User.withUsername(user.getUserName()).password(user.getPassword())
                    .authorities("USER").build();
            if (manager.userExists(user.getUserName())){
                manager.updateUser(details);
            }else {
                manager.createUser(details);
            }
            return Rest.successWithData(manager);
        }
        return Rest.fail("登录失败");
    }
}
