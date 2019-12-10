package com.lzlm.cn.dto.plan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(description = "查询计划")
public class SelPlanDto {

    @ApiModelProperty(name = "planId", value = "计划ID")
    private String planId;

    @ApiModelProperty(name = "typeCode", value = "计划类型编码")
    private String typeCode;

    @ApiModelProperty(name = "planName", value = "计划名称")
    private String planName;

    @ApiModelProperty(name = "userId", value = "创建人ID")
    private String userId;

    @ApiModelProperty(name = "planStatus", value = "计划状态")
    private String planStatus;

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId == null ? null : planId.trim();
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode == null ? null : typeCode.trim();
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName == null ? null : planName.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(String planStatus) {
        this.planStatus = planStatus == null ? null : planStatus.trim();
    }
}