package com.lzlm.cn.config.auth;

import com.lzlm.cn.exception.CustomOAuth2WebResponseExceptionTranslator;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import javax.annotation.Resource;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-12-09 9:59
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
@Configuration
@EnableAuthorizationServer
public class OAuth2ServerConfig extends AuthorizationServerConfigurerAdapter {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Resource
    private UserDetailsService userDetailsService;

    @Resource
    private CustomOAuth2WebResponseExceptionTranslator customOAuth2WebResponseExceptionTranslator;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer)  {
        // 自定义异常处理端口
        oauthServer.authenticationEntryPoint(new CustomAuthenticationEntryPoint());
        oauthServer.realm("oauth2-resources") // code授权添加
                .tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()") // allow check token
                .allowFormAuthenticationForClients();
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                // 允许 GET、POST 请求获取 token，即访问端点：oauth/token
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
        // 要使用refresh_token的话，需要额外配置userDetailsService
        // endpoints.userDetailsService(userDetailsService);
        // 处理 ExceptionTranslationFilter 抛出的异常
        endpoints.exceptionTranslator(customOAuth2WebResponseExceptionTranslator);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients)  {
        try {
            clients.inMemory().withClient("demoApp").secret(bCryptPasswordEncoder.encode("demoAppSecret"))
                    .redirectUris("http://baidu.com")// code授权添加
                    .authorizedGrantTypes("authorization_code", "client_credentials", "password", "refresh_token")
                    .scopes("all").resourceIds("oauth2-resource").accessTokenValiditySeconds(1200)
                    .refreshTokenValiditySeconds(50000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
