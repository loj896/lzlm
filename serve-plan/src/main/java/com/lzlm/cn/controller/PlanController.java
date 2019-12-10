package com.lzlm.cn.controller;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.lzlm.cn.dto.plan.AddPlanDto;
import com.lzlm.cn.dto.plan.SelPlanDto;
import com.lzlm.cn.model.plan.Plan;
import com.lzlm.cn.service.PlanService;
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

import java.util.List;

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
@Api(tags = "计划接口", description = "计划管理")
@RestController
@RequestMapping("/plan")
public class PlanController {

    @Autowired
    private PlanService planService;

    @ApiOperation(value = "添加计划")
    @PostMapping("/addPlan")
    public CommonResult addPlan(@RequestBody @Validated(value = AddGroup.class) AddPlanDto planDto){
        boolean addResult = planService.addPlan(planDto);
        if(addResult){
            return Rest.success("添加成功");
        }
        return Rest.fail("添加失败");
    }

    @ApiOperation(value = "查询计划信息")
    @PostMapping("/getPlanList")
    public CommonResult getPlanList(@RequestBody @Validated(value = SelGroup.class) SelPlanDto planDto){
        List<Plan> planList = planService.getPlanList(planDto);
        if(!CollectionUtils.isEmpty(planList)){
            return Rest.successWithData(planList);
        }
        return Rest.fail("未查询到计划信息");
    }


}
