package com.lzlm.cn.config.auth;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.lzlm.cn.dto.user.UserRoleDto;
import com.lzlm.cn.feign.SysFeignService;
import com.lzlm.cn.model.user.User;
import com.lzlm.cn.util.BeanConvert;
import com.lzlm.cn.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-12-10 10:56
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
@Component(value = "kiteUserDetailsService")
public class KiteUserDetailsService implements UserDetailsService {

    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private SysFeignService sysFeignService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据用户名查询用户信息
        CommonResult userRest = sysFeignService.getUserByUserName(username);
        User user = BeanConvert.beanConvert(userRest.getData(), User.class);
        if(null != user){
            // 线上环境应该通过用户名查询数据库获取加密后的密码
            String password = passwordEncoder.encode(user.getPassword());
            // 获取用户角色
            CommonResult roleRest = sysFeignService.getUserRole(user.getUserId());
            List<UserRoleDto> userRoleDtos = BeanConvert.listConvert((List<UserRoleDto>) roleRest.getData(), UserRoleDto.class);
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            if(!CollectionUtils.isEmpty(userRoleDtos)){
                for (UserRoleDto roleDto : userRoleDtos){
                    authorities.add(new SimpleGrantedAuthority(roleDto.getRoleCode()));
                }
            }
            return new org.springframework.security.core.userdetails.User(username,password, authorities);
        }else {
            throw new UsernameNotFoundException("用户名无效，未查询到用户");
        }
    }
}
