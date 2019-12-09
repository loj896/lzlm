package com.lzlm.cn.dto.auth;

import com.lzlm.cn.util.group.AddGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import java.util.List;

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
@ApiModel(description = "添加权限集合模板")
public class AddAuthListDto {

    @NotEmpty(message = "权限集合不能为空", groups = AddGroup.class)
    @ApiModelProperty(name = "addAuthDtoList", value = "权限集合不能为空")
    private List<AddAuthDto> addAuthDtoList;

    public List<AddAuthDto> getAddAuthDtoList() {
        return addAuthDtoList;
    }

    public void setAddAuthDtoList(List<AddAuthDto> addAuthDtoList) {
        this.addAuthDtoList = addAuthDtoList;
    }
}
