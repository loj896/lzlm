package com.lzlm.cn.service.auth;


import com.lzlm.cn.dto.auth.AddAuthDto;
import com.lzlm.cn.dto.auth.SelAuthClientDto;
import com.lzlm.cn.model.auth.AuthClientDetails;

import java.util.List;


/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-11-27 10:18
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
public interface AuthService {

    /**
     * 新增权限
     * @param authDtoList
     * @return
     */
    boolean addAuth(List<AddAuthDto> authDtoList);

    /**
     * 查询权限认证
     * @param selAuthClientDto
     * @return
     */
    AuthClientDetails getAuthClient(SelAuthClientDto selAuthClientDto);
}
