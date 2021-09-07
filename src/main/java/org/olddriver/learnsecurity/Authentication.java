package org.olddriver.learnsecurity;

/**
 * SpringSecurity认证
 * 20210830
 * 第二部分
 */
public class Authentication {
    /**
     * 认证   验证用户身份
     * 启用spring security配置后可实现所有资源必须认证通过后才能访问
     * i.单体应用采用有状态会话的表单认证
     * 配置用户名密码
     * spring security默认用户名为user，密码为随机生成uuid
     * 可通过配置文件配置用户名，密码
     * 配置内存中用户数据
     * a.重写WebSecurityConfigurerAdapter configure方法，通过AuthenticationManagerBuilder对象设置内存中用户。
     * b.通过InMemoryUserDetailsManager对象配置用户，之后将InMemoryUserDetailsManager对象加入容器
     * InMemoryUserDetailsManager通过createUser方法在内存中创建User，User中包含用户名密码。
     * c.重写WebSecurityConfigurerAdapter userDetailsService方法，方法中配置UserDetailsService，即InMemoryUserDetailsManager
     * 配置数据库中用户数据
     * a.使用默认数据库模型
     * 使用JdbcUserDetailsManager创建用户，查询用户
     * JdbcUserDetailsManager对应的表结构定义在users.ddl中
     * 创建JdbcUserDetailsManager对象时需要DataSource对象
     * 表中以username为主键，可能发生主键冲突
     * b.使用自定义数据库模型
     * 实体类需实现UserDetails接口，重写所有抽象方法
     * 自定义UserDetailsService实现类，重写loadUserByUsername方法定义从数据库查询用户数据逻辑，为认证提供数据
     * 自定义认证逻辑
     * 若需用户名密码以外的认证逻辑，需自定义AuthenticationProvider实现类
     * AuthenticationProvider对Authentication进行认证
     * authenticate方法封装对Authentication认证逻辑
     * supports方法用于判断AuthenticationProvider是否支持对具体Authentication进行认证
     * 通过AuthenticationManagerBuilder配置自定义UserDetailsService，AuthenticationProvider
     * 密码加密
     * 认证过程中使用PasswordEncoder对象加密明文密码，需在容器中配置密码加密对象
     * NoOpPasswordEncoder对象不对密码进行加密
     * 配置登录表单
     * 重写WebSecurityConfigurerAdapter configure方法，获取HttpSecurity对象，通过HttpSecurity对象进行配置
     * formLogin方法用于配置登录表单，不配置属性使用默认配置
     * a.loginPage方法配置登录页面url，默认/login
     * b.loginProcessingUrl方法配置登录接口，默认与loginPage一致。spring security拦截指定url校验凭证，不会将请求传递到controller
     * c.usernameParameter方法配置用户名对应参数名，默认username
     * d.passwordParameter方法配置密码对应参数名，默认password
     * e.successForwardUrl方法配置认证成功后转发url，使用请求转发方式
     * f.defaultSuccessUrl方法配置认证成功后默认跳转url，有限跳转Referer。使用请求重定向方式
     * g.failureForwardUrl方法配置认证失败后转发url，使用请求转发方式
     * h.failureUrl方法配置认证失败后跳转url，使用请求重定向方式
     * i.successHandler方法配置认证成功Handler，前后端分离情况下返回json
     * j.failureHandler方法配置认证失败Handler，前后端分离情况下返回json
     * logout方法用于配置注销功能
     * 关闭csrf防御时为get请求，开启csrf防御时为post请求
     * a.logoutUrl方法配置注销url，默认logout
     * b.logoutSuccessHandler方法配置注销成功Handler，前后端分离情况下返回json
     * c.addLogoutHandler方法配置注销处理器，注销时执行清理动作
     * exceptionHandling方法用于配置异常处理器
     * a.authenticationEntryPoint方法处理匿名用户访问无权限资源异常
     *
     * ii.分布式应用采用无状态会话，结合oauth2.0的表单认证
     * oauth2.0授权协议，一种认证授权通用标准。
     * 服务提供商实现oauth授权服务，客户端应用借助服务提供商的授权服务完成认证授权，获取到授权服务下发的令牌
     * 客户端携带令牌才能访问服务提供商的资源服务，资源服务通过令牌可以获取用户信息
     * 角色划分
     * client   前端应用，app应用
     * resource owner   用户
     * authorization server 授权服务
     * resource server  受保护的资源服务
     * 认证流程
     * 客户端请求授权服务，授权服务要求用户进行授权并认证
     * 授权服务认证通过，为客户端下发令牌
     * 客户端使用令牌请求资源服务，获取资源
     * 术语
     * 客户凭证
     * 令牌
     * 作用域
     * 令牌分类
     * 授权码
     * 访问令牌
     * 刷新令牌
     * bearertoken
     * 四种授权模式
     * a.授权码模式
     * 客户端请求授权服务，授权服务要求用户进行授权并认证
     * 授权服务认证通过，为客户端下发授权码
     * 客户端使用授权码请求授权服务，换取token
     * 客户端携带token访问资源服务
     * b.简化授权模式
     * c.密码模式
     * 客户端携带用户的用户名密码请求授权服务进行认证授权
     * 认证通过，授权服务下发访问令牌，刷新令牌
     * d.客户端模式
     * 刷新令牌
     * 令牌过期后，客户端可以通过刷新令牌向授权服务换取新令牌和刷新令牌，简化流程
     * spring cloud oauth2
     * spring cloud提供的基于oauth2的认证授权组件，包括授权服务和资源服务两部分
     * 授权服务搭建
     * i.创建授权服务配置类，继承AuthorizationServerConfigurerAdapter，配置类上添加@EnableAuthorizationServer
     * 重写configure方法，获取ClientDetailsServiceConfigurer对象配置允许访问授权服务的客户端信息
     * 重写configure方法，获取AuthorizationServerSecurityConfigurer对象
     * allowFormAuthenticationForClients方法配置/oauth/token接口(换取token接口)通过表单参数认证客户端
     * checkTokenAccess方法配置开启/oauth/check_token端点，资源服务通过此端点验证token
     * ii.创建security配置类，继承WebSecurityConfigurerAdapter，配置认证相关配置
     * 资源服务搭建
     * i.创建资源服务配置类，继承ResourceServerConfigurerAdapter，配置类上添加@EnableResourceServer
     * 重写configure方法，获取HttpSecurity对象配置请求认证后才能访问
     * ii.配置RemoteTokenServices对象，配置授权服务信息？？？？
     *
     * iii.分布式应用采用无状态会话，结合oauth2.0，jwt的表单认证
     * jwt(json web token)，json对象，包含用户信息及权限信息，可用于认证
     * 基于jwt认证流程
     * 客户端请求认证服务进行认证
     * 认证通过后认证服务生成jwt，下发给客户端，客户端存储jwt
     * 客户端携带jwt访问受保护资源
     * jwt结构
     * header.payload.signature
     * 头部   一个json对象，包含token类型，签名部分采用算法。使用base64编码
     * 负载   一个json对象，包含传递的数据。使用base64编码
     * 签名   使用头部，负载，密钥进行加密获得；服务端校验token时会重新生成签名进行比较
     * 头部，负载中不应包含敏感信息
     *
     *
     */
}
