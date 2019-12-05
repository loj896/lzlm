package com.lzlm.cn.service.role.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.lzlm.cn.dto.role.AddRoleDto;
import com.lzlm.cn.model.role.Role;
import com.lzlm.cn.service.role.RoleDaoService;
import com.lzlm.cn.service.role.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-12-01 15:54
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
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDaoService roleDaoService;

    @Override
    public boolean addRole(List<AddRoleDto> roleDtoList) {
        if(CollectionUtils.isEmpty(roleDtoList)){
            return false;
        }
        List<Role> roleList = new ArrayList<>();
        Role role = null;
        for (AddRoleDto roleDto : roleDtoList){
            role = new Role();
            BeanUtils.copyProperties(roleDto, role);
            role.setRoleState(1);
            roleList.add(role);
        }
        return roleDaoService.saveBatch(roleList);
    }
}
