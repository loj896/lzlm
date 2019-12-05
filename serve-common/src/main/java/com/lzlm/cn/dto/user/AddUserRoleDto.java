package com.lzlm.cn.dto.user;

import com.lzlm.cn.util.group.AddGroup;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-12-01 16:57
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
public class AddUserRoleDto {

    @NotBlank(message = "用户ID不能为空", groups = AddGroup.class)
    @ApiModelProperty(name = "userId", value = "用户ID")
    private String userId;

    @NotBlank(message = "角色ID不能为空", groups = AddGroup.class)
    @ApiModelProperty(name = "roleId", value = "角色ID")
    private String roleId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
