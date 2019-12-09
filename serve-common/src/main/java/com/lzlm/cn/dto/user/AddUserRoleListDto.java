package com.lzlm.cn.dto.user;

import com.lzlm.cn.util.group.AddGroup;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-12-09 14:28
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
public class AddUserRoleListDto {

    @NotEmpty(message = "角色集合不能为空", groups = AddGroup.class)
    @ApiModelProperty(name = "addRoleList", value = "角色集合")
    private List<AddUserRoleDto> addRoleList;

    public List<AddUserRoleDto> getAddRoleList() {
        return addRoleList;
    }

    public void setAddRoleList(List<AddUserRoleDto> addRoleList) {
        this.addRoleList = addRoleList;
    }
}
