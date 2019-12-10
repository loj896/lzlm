package com.lzlm.cn.service;

import com.lzlm.cn.dto.plan.AddPlanDto;
import com.lzlm.cn.dto.plan.SelPlanDto;
import com.lzlm.cn.model.plan.Plan;

import java.util.List;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-12-10 9:48
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
public interface PlanService {

    /**
     * 查询计划信息
     * @param planDto
     * @return
     */
    List<Plan> getPlanList(SelPlanDto planDto);

    /**
     * 添加计划
     * @param planDto
     * @return
     */
    boolean addPlan(AddPlanDto planDto);
}
