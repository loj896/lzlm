package com.lzlm.cn.service.role.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.lzlm.cn.dto.role.AddRoleAuthDto;
import com.lzlm.cn.dto.role.RoleAuthDto;
import com.lzlm.cn.model.role.RoleAuthRel;
import com.lzlm.cn.service.role.RoleAuthDaoService;
import com.lzlm.cn.service.role.RoleAuthService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
@Service
public class RoleAuthServiceImpl implements RoleAuthService {

    @Resource
    private RoleAuthDaoService roleAuthDaoService;

    @Override
    public boolean addRoleAuth(List<AddRoleAuthDto> roleAuthDtoList) {
        if(CollectionUtils.isEmpty(roleAuthDtoList)){
            return false;
        }
        List<RoleAuthRel> relList = new ArrayList<>();
        RoleAuthRel rel = null;
        for (AddRoleAuthDto roleAuthDto : roleAuthDtoList){
            rel = new RoleAuthRel();
            BeanUtils.copyProperties(roleAuthDto, rel);
            rel.setRelState(1);
            relList.add(rel);
        }
        return roleAuthDaoService.saveBatch(relList);
    }

    @Override
    public List<RoleAuthDto> getAuthByRoleId(String roleId) {
        return roleAuthDaoService.getAuthByRoleId(roleId);
    }
}
