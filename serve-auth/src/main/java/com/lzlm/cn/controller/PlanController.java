package com.lzlm.cn.controller;

import com.lzlm.cn.dto.plan.AddPlanDto;
import com.lzlm.cn.dto.plan.SelPlanDto;
import com.lzlm.cn.feign.PlanFeignService;
import com.lzlm.cn.util.CommonResult;
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
@Api(tags = "计划接口", description = "计划任务管理")
@RestController
@RequestMapping("/lzlm/plan/plan")
public class PlanController {

    @Autowired
    private PlanFeignService planFeignService;

    @ApiOperation(value = "添加计划")
    @PostMapping("/addPlan")
    public CommonResult addPlan(@RequestBody @Validated(value = AddGroup.class) AddPlanDto planDto){
        return planFeignService.addPlan(planDto);
    }

    @ApiOperation(value = "查询计划信息")
    @PostMapping("/getPlanList")
    public CommonResult getPlanList(@RequestBody @Validated(value = SelGroup.class) SelPlanDto planDto){
        return planFeignService.getPlanList(planDto);
    }

}
