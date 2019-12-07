# lzlm
## 总体情况
项目框架使用Spring Boot + Spring Cloud ，注册中心使用Eureka，集成spring-boot-admin进行项目监控，
添加zipkin进行全链路跟踪，使用Feign进行服务间的通讯，利用Feign集成的hystrix进行熔断出来，
添加hystrix-dashboard可视化熔断监控，相关版本、依赖包及配置如下：

#### <a href="#title1">1、依赖包及版本</a>
#### <a href="#title2">2、注册中心</a>
#### <a href="#title3">3、链路跟踪</a>
#### <a href="#title4">4、项目监控</a>
#### <a href="#title5">5、公共模块</a>
#### <a href="#title6">6、系统管理服务</a>
#### <a href="#title7">7、鉴权认证</a>
#### <a href="#title8">8、服务网关</a>
## <a name="title1">1、依赖包及版本</a>
| 名称  | 版本  |
| --- | --- |
| Spring Boot| 2.1.5.RELEASE |
| Spring Cloud| Greenwich.SR1 |
| zipkin | 2.10.1 |
| spring-boot-admin | 2.1.5 |
| mysql | 8.0.11 |
| mybatis-plus | 3.1.0 |
| swagger2 | 2.5.0 |
| fastjson | 1.2.47 |
| validation-api | 2.0.1.Final |

##
## <a name="title2">2、注册中心</a>
> * 模块：serve-eureka
> * 端口：9601
### 依赖包 
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
```
### application.yml 配置文件
```
spring:
  application:
    name: serve-eureka
server:
  port: @eureka.port@
eureka:
  instance:
    # Eureka注册中心HOST主机地址，可以采用：1.直接配置IP；2.配置本地域名并修改本地hosts文件
    hostname: localhost
  server:
    wait-time-in-ms-when-sync-empty: 0
    enable-self-preservation: false
    #剔除过期实例时间 30s
    eviction-interval-timer-in-ms: 30000
  client:
    # 是否将自己注册到注册中心。因为项目中只有一个注册中心就是自己，所以无需再注册
    register-with-eureka: false
    # 是否从远程拉取其他注册中心，因为注册中心只有自己所以不需要。如果注册中心有多个，可以相互暴露，相互拉取
    fetch-registry: false
    service-url:
      # 该注册中心连接地址
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
```
### 入口注解
> * @EnableEurekaServer
> * @SpringBootApplication

##
## <a name="title3">3、链路跟踪</a>
> * 模块：serve-zipkin
> * 端口：9602
### 依赖包 
```
<!--Eureka-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
<!--admin client-->
<dependency>
    <groupId>de.codecentric</groupId>
    <artifactId>spring-boot-admin-starter-client</artifactId>
</dependency>
<!--zipkin-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-zipkin</artifactId>
</dependency>
<dependency>
    <groupId>io.zipkin.java</groupId>
    <artifactId>zipkin</artifactId>
</dependency>
<dependency>
    <groupId>io.zipkin.java</groupId>
    <artifactId>zipkin-server</artifactId>
    <exclusions>
        <exclusion>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-slf4j-impl</artifactId>
        </exclusion>
    </exclusions>
</dependency>
<dependency>
    <groupId>io.zipkin.java</groupId>
    <artifactId>zipkin-autoconfigure-ui</artifactId>
</dependency>
```
### application.yml 配置文件
```
spring:
  application:
    name: serve-zipkin
  main:
    allow-bean-definition-overriding: true
  boot:
    admin:
      client:
        url: @admin.url@
server:
  port: @zipkin.port@
eureka:
  client:
    service-url:
      # Eureka注册中心连接地址
      # 如果注册中心地址配置的域名，这里使用 http://域名/eureka/ 格式
      defaultZone: @eureka.url@
management:
  metrics:
    web:
      # 解决Zipkin报错IllegalArgumentException: Prometheus requires that all meters
      server:
        auto-time-requests: false
```
### 入口注解
> * @EnableEurekaClient
> * @EnableZipkinServer
> * @SpringBootApplicati

##
## <a name="title4">4、项目监控</a>
> * 模块：serve-admin
> * 端口：9603
### 依赖包 
```
<!--Eureka-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
<!--admin service-->
<dependency>
    <groupId>org.jolokia</groupId>
    <artifactId>jolokia-core</artifactId>
</dependency>
<dependency>
    <groupId>de.codecentric</groupId>
    <artifactId>spring-boot-admin-starter-server</artifactId>
</dependency>
<!--去掉tomcat依赖，添加jetty依赖，解决报错：Calling [asyncError()] is not valid for a request with Async state -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <exclusions>
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
        </exclusion>
    </exclusions>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jetty</artifactId>
</dependency>
<!--zipkin-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-zipkin</artifactId>
</dependency>
```
### application.yml 配置文件
```
spring:
  application:
    name: serve-admin
  zipkin:
    # base-url: @zipkin.url@  #若在同一个注册中心的话可以启用自动发现，省略base-url
    locator:
      discovery:
        enabled: true #自动发现
server:
  port: @admin.port@
eureka:
  client:
    service-url:
      # Eureka注册中心连接地址
      # 如果注册中心地址配置的域名，这里使用 http://域名/eureka/ 格式
      defaultZone: @eureka.url@
# admin
management:
  endpoint:
    health:
      show-details: ALWAYS
  endpoints:
    web:
      exposure:
        include: "*" # health,info
```
### 入口注解
> * @EnableAdminServer
> * @EnableEurekaClient
> * @SpringBootApplication

##
## <a name="title5">5、公共模块</a>
> * 模块：serve-common
### 依赖包 
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<!--Eureka-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
<!--admin client-->
<dependency>
    <groupId>de.codecentric</groupId>
    <artifactId>spring-boot-admin-starter-client</artifactId>
</dependency>
<!--mysql 8.0-->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.11</version>
    <scope>runtime</scope>
</dependency>
<!--druid数据库连接池-->
<!--<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid-spring-boot-starter</artifactId>
    <version>${druid.version}</version>
</dependency>-->
<!--mybatis plus-->
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.1.0</version>
</dependency>
<!--swagger2-->
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.5.0</version>
</dependency>
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.5.0</version>
</dependency>
<!--fastjson 格式化数据-->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>1.2.47</version>
</dependency>
<!--zipkin-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-zipkin</artifactId>
</dependency>
<dependency>
    <groupId>javax.validation</groupId>
    <artifactId>validation-api</artifactId>
    <version>2.0.1.Final</version>
</dependency>
```

##
## <a name="title6">6、系统管理服务</a>
> * 模块：serve-sys
> * 端口：9701
### 依赖包 
```
<!--引入公共模块-->
<dependency>
    <groupId>com.lzlm.cn</groupId>
    <artifactId>serve-common</artifactId>
</dependency>
```
### application.yml 配置文件
```
spring:
  application:
    name: serve-sys
  zipkin:
    # base-url: @zipkin.url@  #若在同一个注册中心的话可以启用自动发现，省略base-url
    locator:
      discovery:
        enabled: true #自动发现
  boot:
    admin:
      client:
        url: @admin.url@
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://47.105.161.199:3306/mydb?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true&allowPublicKeyRetrieval=true
    username: @db.user@
    password: @db.pwd@
mybatis-plus:
  mapper-locations: classpath*:mapper/**/*.xml
  type-aliases-package: com.lzlm.cn.model.*.*
  global-config:
    db-config:
      db-type: mysql
      id-type: uuid
      field-strategy: not_null
      logic-delete-value: 1
      logic-not-delete-value: 0
      table-underline: true
  configuration:
    map-underscore-to-camel-case: true
    cache-enabled: false
    call-setters-on-nulls: true
server:
  port: @serve.sys.port@
eureka:
  client:
    service-url:
      # Eureka注册中心连接地址
      # 如果注册中心地址配置的域名，这里使用 http://域名/eureka/ 格式
      defaultZone: @eureka.url@
logging:
  level:
    root: info
    com.lzlm.cn: debug
```
### 入口注解
> * @EnableEurekaClient
> * @SpringBootApplication
### 添加Swagger2配置类
```
@Configuration
@EnableSwagger2
public class Swagger2 {
    private static final String VERSION = "1.0.0";

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //指定扫描的包路径来定义指定要建立API的目录
                .apis(RequestHandlerSelectors.basePackage("com.lzlm.cn.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SERVE-SYS")
                .contact("liuhai")
                .version(VERSION)
                .build();
    }
}
```

##
## <a name="title7">7、鉴权认证</a>
> * 模块：serve-auth
> * 端口：9801
### 依赖包 
```
<!--引入公共模块-->
<dependency>
    <groupId>com.lzlm.cn</groupId>
    <artifactId>serve-common</artifactId>
</dependency>
<!--调用其它服务，内置了 Hystrix 熔断器-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
<!--熔断监控-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
</dependency>
```
### application.yml 配置文件
```
spring:
  application:
    name: serve-auth
  zipkin:
    # base-url: @zipkin.url@  #若在同一个注册中心的话可以启用自动发现，省略base-url
    locator:
      discovery:
        enabled: true #自动发现
  boot:
    admin:
      client:
        url: @admin.url@
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://47.105.161.199:3306/mydb?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true&allowPublicKeyRetrieval=true
    username: @db.user@
    password: @db.pwd@
server:
  port: @serve.auth.port@
eureka:
  client:
    service-url:
      # Eureka注册中心连接地址
      # 如果注册中心地址配置的域名，这里使用 http://域名/eureka/ 格式
      defaultZone: @eureka.url@
feign:
  hystrix:
    # 开启Feign的Hystrix熔断器支持
    enabled: true
```
### 入口注解
> * @EnableDiscoveryClient
> * @EnableFeignClients
> * @EnableHystrixDashboard
> * @SpringBootApplication
### 添加熔断监控配置类
```
@Configuration
public class HystrixConfig {

    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
```
### 添加Swagger2配置类
```
@Configuration
@EnableSwagger2
public class Swagger2 {
    private static final String VERSION = "1.0.0";

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //指定扫描的包路径来定义指定要建立API的目录
                .apis(RequestHandlerSelectors.basePackage("com.lzlm.cn.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SERVE-SYS")
                .contact("liuhai")
                .version(VERSION)
                .build();
    }
}
```

##
## <a name="title8">8、服务网关</a>
> * 模块：serve-gateway
> * 端口：9901
### 依赖包 
```
<!--Eureka-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
<!--admin client-->
<dependency>
    <groupId>de.codecentric</groupId>
    <artifactId>spring-boot-admin-starter-client</artifactId>
</dependency>
<!--gateway-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-gateway</artifactId>
</dependency>
<!--zipkin-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-zipkin</artifactId>
</dependency>
```
### application.yml 配置文件
```
spring:
  application:
    name: serve-gateway
  zipkin:
    # base-url: @zipkin.url@  #若在同一个注册中心的话可以启用自动发现，省略base-url
    locator:
      discovery:
        enabled: true #自动发现
  sleuth:
    sampler:
      percentage: 1.0
  boot:
    admin:
      client:
        url: @admin.url@
  cloud:
    gateway:
#      discovery:
#        locator:
#          enabled: true
#          lower-case-service-id: true
      routes:
        - id: lzlm_route
          uri: lb://serve-auth
          predicates:
          - Path=/lzlm/**
          filters:
          - StripPrefix=1
server:
  port: @serve.gateway.port@
eureka:
  instance:
    prefer-ip-address: true
  client:
    service-url:
      # Eureka注册中心连接地址
      # 如果注册中心地址配置的域名，这里使用 http://域名/eureka/ 格式
      defaultZone: @eureka.url@
loggin:
  level:
    root: info
    com.lzlm.cn: debug
```
### 入口注解
> * @EnableDiscoveryClient
> * @SpringBootApplication