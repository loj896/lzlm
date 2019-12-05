package com.lzlm.cn.service.role;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lzlm.cn.dto.role.RoleAuthDto;
import com.lzlm.cn.model.role.RoleAuthRel;

import java.util.List;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-11-28 22:57
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
public interface RoleAuthDaoService extends IService<RoleAuthRel> {

    /**
     * 根据角色ID查询权限
     * @param roleId
     * @return
     */
    List<RoleAuthDto> getAuthByRoleId(String roleId);
}
