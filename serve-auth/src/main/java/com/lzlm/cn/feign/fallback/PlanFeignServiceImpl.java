package com.lzlm.cn.feign.fallback;

import com.lzlm.cn.dto.plan.AddPlanDto;
import com.lzlm.cn.dto.plan.SelPlanDto;
import com.lzlm.cn.feign.PlanFeignService;
import com.lzlm.cn.util.CommonResult;
import com.lzlm.cn.util.Rest;
import org.springframework.stereotype.Component;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-12-10 10:32
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
public class PlanFeignServiceImpl implements PlanFeignService {

    @Override
    public CommonResult addPlan(AddPlanDto planDto) {
        return Rest.fail("添加计划失败，网路异常");
    }

    @Override
    public CommonResult getPlanList(SelPlanDto planDto) {
        return Rest.fail("查询计划列表失败，网路异常");
    }
}
