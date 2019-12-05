package com.lzlm.cn.service.user.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzlm.cn.dao.user.UserRoleRelMapper;
import com.lzlm.cn.dto.user.UserRoleDto;
import com.lzlm.cn.model.user.UserRoleRel;
import com.lzlm.cn.service.user.UserRoleDaoService;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-11-27 10:13
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
public class UserRoleDaoServiceImpl extends ServiceImpl<UserRoleRelMapper, UserRoleRel> implements UserRoleDaoService {

    @Override
    public List<UserRoleDto> getUserRole(String userId) {
        return this.baseMapper.getUserRole(userId);
    }
}
