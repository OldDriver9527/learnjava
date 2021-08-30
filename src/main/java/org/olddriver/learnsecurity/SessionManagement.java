package org.olddriver.learnsecurity;

/**
 * 会话管理
 * 20210822
 * 第一部分
 */
public class SessionManagement {
    /**
     * Session Management
     * 一个用户与web服务器之间发生一系列请求和响应的过程称为会话。web服务器能够把属于同一会话的请求和响应过程关联起来，
     * 使得他们之间可以相互依赖和传递信息。
     * web应用低并发时可使用session，cookie技术维持会话，高并发时使用jwt维持会话
     * 移动端应用天生无cookie，需要使用jwt维持会话
     * cookies
     * 用户访问服务器某个资源时，web服务器在HTTP响应头中附带传给浏览器的一些数据，浏览器会把Cookie保存起来。
     * 当用户再次请求同一站点的资源，浏览器连同Cookie一同提交给服务器
     * 浏览器发送请求时，会携带属于当前域名或属于上级域名的cookie。ajax请求不会携带cookie
     * session
     * 当用户访问服务器特定资源时，服务器创建session容器，为该容器生成唯一sessionid，
     * 并将sessionid发送给客户端，以cookie形式存储
     *
     * 同源策略 same origin policy
     * 同源策略限制一个站点的JavaScript脚本访问另一个站点的资源。
     * 同源指两个url中协议，域名，端口一致。
     *
     * sso
     * single sign on
     *
     * XSS Cross Site Scripting
     * 跨站脚本攻击
     * 攻击者将恶意脚本注入到页面中，当用户浏览页面会导致脚本执行，对用户发起攻击
     * i.网站运营者在页面中嵌入第三方提供JavaScript脚本，其中包含恶意代码
     * ii.页面部分内容根据外界输入值决定，输入值中包含恶意脚本。如web邮件客户端或社交网站
     * CSRF Cross-site request forgery
     * 跨站请求伪造
     * 用户登录信任站点后打开一个新标签页访问恶意站点，恶意站点页面中访问信任站点资源
     * i.在用户不知情情况下，恶意利用form元素的action属性进行跨域访问
     *
     * Shiro，SpringSecurity核心功能
     * 认证，授权
     * 防御csrf攻击
     */
}
