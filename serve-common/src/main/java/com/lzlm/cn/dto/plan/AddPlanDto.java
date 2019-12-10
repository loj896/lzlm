package com.lzlm.cn.dto.plan;

import com.lzlm.cn.util.group.AddGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

@ApiModel(description = "添加计划模板")
public class AddPlanDto {

    @NotBlank(message = "计划类型编码不能为空", groups = AddGroup.class)
    @ApiModelProperty(name = "typeCode", value = "计划类型编码")
    private String typeCode;

    @NotBlank(message = "计划名称不能为空", groups = AddGroup.class)
    @ApiModelProperty(name = "planName", value = "计划名称")
    private String planName;

    @NotBlank(message = "创建人ID不能为空", groups = AddGroup.class)
    @ApiModelProperty(name = "userId", value = "创建人ID")
    private String userId;

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}