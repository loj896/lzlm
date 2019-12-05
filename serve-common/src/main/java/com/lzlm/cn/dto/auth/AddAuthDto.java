package com.lzlm.cn.dto.auth;

import com.lzlm.cn.util.group.AddGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-11-27 10:19
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
@ApiModel(description = "添加权限模板")
public class AddAuthDto {

    @NotBlank(message = "权限编码不能为空", groups = AddGroup.class)
    @ApiModelProperty(name = "authCode", value = "权限编码")
    private String authCode;

    @NotBlank(message = "权限名称不能为空", groups = AddGroup.class)
    @ApiModelProperty(name = "authName", value = "权限名称")
    private String authName;

    @NotBlank(message = "权限父级编码不能为空", groups = AddGroup.class)
    @ApiModelProperty(name = "authPcode", value = "权限父级编码")
    private String authPcode;

    @NotBlank(message = "是否叶子节点不能为空", groups = AddGroup.class)
    @ApiModelProperty(name = "isLeaf", value = "是否叶子节点")
    private Integer isLeaf;

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getAuthPcode() {
        return authPcode;
    }

    public void setAuthPcode(String authPcode) {
        this.authPcode = authPcode;
    }

    public Integer getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Integer isLeaf) {
        this.isLeaf = isLeaf;
    }
}
