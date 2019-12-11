package com.lzlm.cn.feign;

import com.lzlm.cn.dto.plan.AddPlanDto;
import com.lzlm.cn.dto.plan.SelPlanDto;
import com.lzlm.cn.feign.fallback.PlanFeignServiceImpl;
import com.lzlm.cn.util.CommonResult;
import com.lzlm.cn.util.group.AddGroup;
import com.lzlm.cn.util.group.SelGroup;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
@FeignClient(value = "serve-plan", fallback = PlanFeignServiceImpl.class)
public interface PlanFeignService {

    /**
     * 添加权限
     * @param planDto
     * @return
     */
    @PostMapping("/plan/addPlan")
    CommonResult addPlan(@RequestBody @Validated(value = AddGroup.class) AddPlanDto planDto);

    /**
     * 查询计划信息
     * @param planDto
     * @return
     */
    @PostMapping("/plan/getPlanList")
    CommonResult getPlanList(@RequestBody @Validated(value = SelGroup.class) SelPlanDto planDto);


}
