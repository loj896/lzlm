package com.lzlm.cn.service.role.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzlm.cn.dao.role.RoleAuthRelMapper;
import com.lzlm.cn.dto.role.RoleAuthDto;
import com.lzlm.cn.model.role.RoleAuthRel;
import com.lzlm.cn.service.role.RoleAuthDaoService;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-11-28 22:59
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
public class RoleAuthDaoServiceImpl extends ServiceImpl<RoleAuthRelMapper, RoleAuthRel> implements RoleAuthDaoService {

    @Override
    public List<RoleAuthDto> getAuthByRoleId(String roleId) {
        return this.baseMapper.getAuthByRoleId(roleId);
    }
}
