package com.lzlm.cn.feign;

import com.lzlm.cn.dto.auth.AddAuthListDto;
import com.lzlm.cn.dto.auth.SelAuthClientDto;
import com.lzlm.cn.dto.user.AddUserRoleListDto;
import com.lzlm.cn.dto.user.LoginDto;
import com.lzlm.cn.feign.fallback.SysFeignServiceFallImpl;
import com.lzlm.cn.util.CommonResult;
import com.lzlm.cn.util.group.AddGroup;
import com.lzlm.cn.util.group.SelGroup;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-11-25 9:25
 *           '::::::::::::'           @description Feign 服务通信，开启 hystrix 熔断器
 *             .::::::::::                      1、pom.xml 文件添加 Feign 依赖
 *        '::::::::::::::..                     2、启动类添加 @EnableFeignClients 注解
 *             ..::::::::::::.                  3、调用接口添加 @FeignClient 注解，value 指定已注册服务名称 ,
 *           ``::::::::::::::::                 4、方法和服务提供方参数、返回值一致，@RequestMapping 指定具体路径
 *            ::::``:::::::::'        .:::.     5、熔断处理：配置文件添加feign.hystrix.enabled=true @FeignClient 添加属性 fallback=实现类.class
 *           ::::'   ':::::'       .::::::::.      在实现的方法体中处理调用失败逻辑
 *         .::::'      ::::     .:::::::'::::. 
 *        .:::'       :::::  .:::::::::' ':::::. 
 *       .::'        :::::.:::::::::'      ':::::. 
 *      .::'         ::::::::::::::'         ``::::. 
 *  ...:::           ::::::::::::'              ``::. 
 * ```` ':.          ':::::::::'                  ::::.. 
 *                    '.:::::'                    ':'````.. 
 */
@FeignClient(value = "serve-sys", fallback = SysFeignServiceFallImpl.class)
public interface SysFeignService {

    @GetMapping("/sys/user/hello/{name}")
    String hello(@PathVariable(name = "name") String name);

    /**
     * 根据用户名和登录密码查询用户信息
     * @param loginDto
     * @return
     */
    @PostMapping("/sys/user/getUserByPwdAndName")
    CommonResult getUserByPwdAndName(@RequestBody @Validated(value = SelGroup.class) LoginDto loginDto);

    /**
     * 查询用户权限
     * @param userId
     * @return
     */
    @PostMapping("/sys/user/getUserAuth")
    CommonResult getUserAuth(@RequestParam("userId") String userId);

    /**
     * 新增用户角色
     * @param roleListDto
     * @return
     */
    @PostMapping("/sys/user/addUserRole")
    CommonResult addUserRole(@RequestBody @Validated(value = AddGroup.class) AddUserRoleListDto roleListDto);

    /**
     * 查询用户角色
     * @param userId
     * @return
     */
    @PostMapping("/sys/user/getUserRole")
    CommonResult getUserRole(@RequestParam("userId") String userId);

    /**
     * 添加权限
     * @param authDtoList
     * @return
     */
    @PostMapping("/sys/auth/addAuth")
    CommonResult addAuth(@RequestBody @Validated(value = AddGroup.class) AddAuthListDto authDtoList);

    /**
     * 查询权限认证信息
     * @param clientDto
     * @return
     */
    @PostMapping("/sys/auth/getAuthClient")
    CommonResult getAuthClient(@RequestBody @Validated(value = SelGroup.class) SelAuthClientDto clientDto);

    /**
     * 根据角色ID查询权限信息
     * @param roleId
     * @return
     */
    @PostMapping("/sys/role/getAuthByRoleId")
    CommonResult getAuthByRoleId(@RequestParam("roleId") String roleId);

}
