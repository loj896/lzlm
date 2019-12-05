package com.lzlm.cn.service.user;

import com.lzlm.cn.dto.user.AddUserRoleDto;
import com.lzlm.cn.dto.user.LoginDto;
import com.lzlm.cn.dto.user.UserAuthDto;
import com.lzlm.cn.dto.user.UserRoleDto;
import com.lzlm.cn.model.user.User;

import java.util.List;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-11-26 15:48
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
public interface UserService {

    /**
     * 根据用户名和密码获取用户信息
     * @param loginDto
     * @return
     */
    User getUserByPwdAndName(LoginDto loginDto);

    /**
     * 添加用户角色
     * @param userRoleDtoList
     * @return
     */
    boolean addUserRole(List<AddUserRoleDto> userRoleDtoList);

    /**
     * 查询用户拥有的角色
     * @param userId
     * @return
     */
    List<UserRoleDto> getUserRole(String userId);

    /**
     * 查询用户权限
     * @param userId
     * @return
     */
    List<UserAuthDto> getUserAuth(String userId);
}
