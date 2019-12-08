package com.lzlm.cn.service.auth.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.lzlm.cn.dto.auth.AddAuthDto;
import com.lzlm.cn.dto.auth.SelAuthClientDto;
import com.lzlm.cn.model.auth.Auth;
import com.lzlm.cn.model.auth.AuthClientDetails;
import com.lzlm.cn.service.auth.AuthClientDaoService;
import com.lzlm.cn.service.auth.AuthDaoService;
import com.lzlm.cn.service.auth.AuthService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-11-27 10:26
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
public class AuthServiceImpl implements AuthService {

    @Resource
    private AuthDaoService authDaoService;
    @Resource
    private AuthClientDaoService authClientDaoService;

    @Override
    public boolean addAuth(List<AddAuthDto> authDtoList) {
        if(CollectionUtils.isEmpty(authDtoList)){
            return false;
        }
        List<Auth> addList = new ArrayList<>();
        Auth auth = null;
        for (AddAuthDto authDto : authDtoList){
            auth = new Auth();
            BeanUtils.copyProperties(authDto, auth);
            auth.setAuthState(1);
            addList.add(auth);
        }
        return authDaoService.saveBatch(addList);
    }

    @Override
    public AuthClientDetails getAuthClient(SelAuthClientDto selAuthClientDto) {
        QueryWrapper<AuthClientDetails> wrapper = new QueryWrapper<>();
        wrapper.eq("scope", selAuthClientDto.getScope());
        return authClientDaoService.getOne(wrapper);
    }
}
