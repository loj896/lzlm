package com.lzlm.cn.service.role;

import com.lzlm.cn.dto.role.AddRoleAuthDto;
import com.lzlm.cn.dto.role.RoleAuthDto;

import java.util.List;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-12-01 15:55
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
public interface RoleAuthService {

    /**
     * 添加角色权限
     * @param roleAuthDtoList
     * @return
     */
    boolean addRoleAuth(List<AddRoleAuthDto> roleAuthDtoList);

    /**
     * 根据角色ID查询权限
     * @param roleId
     * @return
     */
    List<RoleAuthDto> getAuthByRoleId(String roleId);
}
