package com.lzlm.cn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lzlm.cn.dto.plan.AddPlanDto;
import com.lzlm.cn.dto.plan.SelPlanDto;
import com.lzlm.cn.model.plan.Plan;
import com.lzlm.cn.service.PlanService;
import com.lzlm.cn.service.plan.PlanDaoService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-12-10 9:49
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
@Service
public class PlanServiceImpl implements PlanService {

    @Resource
    private PlanDaoService planDaoService;

    @Override
    public List<Plan> getPlanList(SelPlanDto planDto) {
        QueryWrapper<Plan> wrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(planDto.getPlanId())){
            wrapper.eq("plan_id", planDto.getPlanId());
        }
        if(!StringUtils.isEmpty(planDto.getTypeCode())){
            wrapper.eq("type_code", planDto.getTypeCode());
        }
        if(!StringUtils.isEmpty(planDto.getPlanName())){
            wrapper.like("plan_name", planDto.getPlanName());
        }
        if(!StringUtils.isEmpty(planDto.getUserId())){
            wrapper.eq("create_id", planDto.getUserId());
        }
        if(!StringUtils.isEmpty(planDto.getPlanStatus())){
            wrapper.eq("plan_status",planDto.getPlanStatus());
        }
        return planDaoService.list(wrapper);
    }

    @Override
    public boolean addPlan(AddPlanDto planDto) {
        Plan plan = new Plan();
        BeanUtils.copyProperties(planDto, plan);
        plan.setCreateId(planDto.getUserId());
        plan.setCreateDate(new Date());
        plan.setPlanStatus("1");
        return planDaoService.save(plan);
    }
}
