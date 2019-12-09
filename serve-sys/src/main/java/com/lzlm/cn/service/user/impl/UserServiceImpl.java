package com.lzlm.cn.service.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.lzlm.cn.dto.user.AddUserRoleDto;
import com.lzlm.cn.dto.user.LoginDto;
import com.lzlm.cn.dto.user.UserAuthDto;
import com.lzlm.cn.dto.user.UserRoleDto;
import com.lzlm.cn.model.user.User;
import com.lzlm.cn.model.user.UserRoleRel;
import com.lzlm.cn.service.user.UserDaoService;
import com.lzlm.cn.service.user.UserRoleDaoService;
import com.lzlm.cn.service.user.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-11-26 15:50
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
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDaoService userDaoService;
    @Resource
    private UserRoleDaoService userRoleDaoService;

    @Override
    public User getUserByPwdAndName(LoginDto loginDto) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", loginDto.getUserName());
        wrapper.eq("password", loginDto.getPassword());
        wrapper.eq("user_status", "1");
        return userDaoService.getOne(wrapper);
    }

    @Override
    public User getUserByUserName(String userName) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", userName);
        wrapper.eq("user_status", "1");
        return userDaoService.getOne(wrapper);
    }

    @Override
    public boolean addUserRole(List<AddUserRoleDto> userRoleDtoList) {
        if(CollectionUtils.isEmpty(userRoleDtoList)){
            return false;
        }
        List<UserRoleRel> relList = new ArrayList<>();
        UserRoleRel rel = null;
        for (AddUserRoleDto userRoleRel : userRoleDtoList){
            rel = new UserRoleRel();
            BeanUtils.copyProperties(userRoleRel, rel);
            rel.setRelState(1);
            relList.add(rel);
        }
        return userRoleDaoService.saveBatch(relList);
    }

    @Override
    public List<UserRoleDto> getUserRole(String userId) {
        return userRoleDaoService.getUserRole(userId);
    }

    @Override
    public List<UserAuthDto> getUserAuth(String userId) {
        return userDaoService.getUserAuth(userId);
    }
}
