package org.olddriver.learnsecurity;

/**
 * SpringSecurity授权
 * 20210830
 * 第三部分
 */
public class Authorization {
    /**
     * 授权   基于url进行鉴权，判断当前用户是否具有权限访问资源
     * i.单体应用采用有状态会话授权方式
     * 配置url权限
     * a.重写WebSecurityConfigurerAdapter中configure方法，通过HttpSecurity对象进行配置
     * authorizeRequests方法用于配置url权限，鉴权时按照声明顺序从上往下进行匹配
     * antMatchers方法配置需授权的ant模式url，ant模式中 ?表示任意单个字符，*表示0个或多个字符，**表示0个或多个目录
     * hasRole方法配置有权限的角色名称
     * b.通过注解配置资源权限
     * security配置类上添加@EnableGlobalMethodSecurity，通过@EnableGlobalMethodSecurity选择配置权限的方式
     * securedEnabled方法返回值设置为true，使用@Secured安全注解配置权限，仅能接收角色名
     * prePostEnabled方法返回值设置为true，使用@PreAuthorize前置注解配置权限，可以接收表达式
     * 最长匹配原则？？？
     * 角色继承
     * 通过RoleHierarchyImpl对象设置角色间层次关系。上层角色具有下层角色权限
     *
     * 忽略静态资源
     */
}
