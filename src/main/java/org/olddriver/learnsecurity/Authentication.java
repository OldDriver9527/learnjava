package org.olddriver.learnsecurity;

/**
 * SpringSecurity认证
 * 20210830
 * 第二部分
 */
public class Authentication {
    /**
     * 认证   验证用户身份
     * 启用spring security配置后可实现所有资源必须认证通过后才能访问，默认用户名为user，密码为随机生成uuid
     * i.基于内存认证(用户名密码存储在内存中，未持久化到数据库)
     * 配置用户名密码方式
     * a.通过配置文件配置用户名，明文密码
     * b.重写WebSecurityConfigurerAdapter configure方法
     * 通过AuthenticationManagerBuilder对象设置用户名密文密码。
     * c.通过InMemoryUserDetailsManager对象配置用户名，密文密码
     * 容器中加入InMemoryUserDetailsManager对象
     * InMemoryUserDetailsManager实现UserDetailsService接口，通过createUser方法在内存中创建User，User中包含用户名，密文密码。
     * d.重写userDetailsService方法，方法中配置UserDetailsService
     * 密码加密
     * 当配置密文密码时，认证过程中使用PasswordEncoder对象加密明文，需在容器中配置密码加密对象
     * NoOpPasswordEncoder对象不对密码进行加密
     * 自定义登录表单
     * 重写WebSecurityConfigurerAdapter configure方法，获取HttpSecurity对象，通过HttpSecurity对象进行配置
     * formLogin方法用于配置登录表单
     * a.loginPage方法配置登录页面属性，默认login
     * b.loginProcessingUrl方法配置登录接口属性，默认与loginPage一致
     * c.usernameParameter方法配置用户名对应参数名属性，默认username
     * d.passwordParameter方法配置密码对应参数名属性，默认password
     * e.successForwardUrl方法配置认证成功后转发url属性，使用请求转发方式
     * f.defaultSuccessUrl方法配置认证成功后跳转url属性，使用请求重定向方式
     * g.failureForwardUrl方法配置认证失败后转发url属性，使用请求转发方式
     * h.failureUrl方法配置认证失败后跳转url属性，使用请求重定向方式
     * i.successHandler方法配置认证成功Handler，前后端分离情况下返回json
     * j.failureHandler方法配置认证失败Handler，前后端分离情况下返回json
     * logout方法用于配置注销功能
     * a.logoutUrl方法注销url属性，默认logout，get请求
     * b.logoutSuccessHandler方法配置注销成功Handler，前后端分离情况下返回json
     * exceptionHandling方法用于配置异常处理器
     * a.authenticationEntryPoint方法处理匿名用户访问无权限资源异常
     *
     * ii.基于数据库认证
     * a.使用默认数据库模型
     * 将JdbcUserDetailsManager加入容器，使用users.ddl中数据库模型持久化数据。
     * JdbcUserDetailsManager实现UserDetailsService接口，通过createUser方法将User对象持久化到数据库，
     * 通过loadUserByUsername方法查询用户
     * 创建JdbcUserDetailsManager对象时需要DataSource对象
     * 表中以username为主键，可能发生主键冲突
     * b.使用自定义数据库模型
     * 自定义UserDetailsService实现类，重写loadUserByUsername方法。
     * 自定义UserDetails实现类，重写所有抽象方法
     * 将自定义实现加入容器
     */
}
