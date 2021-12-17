package org.olddriver.learnspring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 面向切面
 * 20211216
 * 第四部分
 */
public class AOP {
    /**
     * 切面(Aspect)   对某个功能的封装
     * 连接点(Join point)  程序中插入切面的位置，spring aop仅支持方法作为连接点
     * 通知(Advice)   切面在连接点执行的动作
     * 切点(Pointcut) 匹配连接点的断言
     * 目标对象(Target object)  被插入切面的对象
     * 代理对象(AOP proxy) 将切面和目标对象组合后生成的对象
     * 织入(Weaving)  将切面应用到目标对象的过程
     * 引入(Introduction) 让代理对象实现指定接口
     *
     * types of advice
     * 前置通知(before advice)  在join point前执行
     * 后置返回通知(after returning advice)   在join point正常退出后执行
     * 后置异常通知(after throwing advice)    在join point异常退出后执行
     * 最终通知(finally advice) 在join point后执行
     * 环绕通知(around advice)  在join point前后执行
     *
     * 代理对象
     * spring默认使用基于接口的jdk api创建代理对象，连接点只能是接口中方法
     * 当目标对象未实现接口，会使用基于类的cglib api创建代理对象，连接点可以是所有方法
     *
     * jdk 动态代理
     * 基于接口的动态代理，代理对象与目标对象均实现指定接口，无其他关系
     * cglib 动态代理
     * 基于类的动态代理，代理对象是目标对象子类
     *
     * @Aspect
     * 用于切面的声明，并将自身排除在自动代理范围之外
     *
     * 切点声明
     * 切点由切点签名和切点表达式组成，切点签名是返回值为void的方法，切点表达式由@Pointcut指定
     *
     * @Before
     * 用于声明前置通知
     * @AfterReturning
     * 用于声明后置返回通知，可通过参数注入连接点返回值
     * @AfterThrowing
     * 用于声明后置异常通知，可通过参数注入连接点抛出异常
     * @After
     * 用于声明最终通知
     * @Around
     * 用于声明环绕通知
     *
     * 为通知传递参数
     * 在切点表达式中追加args表达式指定参数名，args表达式中参数名无要求，顺序类型要与连接点参数一致
     * 在通知中使用相同参数名接收参数
     *
     * 通知优先级
     * 以切面为单位为通知设置优先级
     *
     * 引入
     * @DeclareParents 声明引入
     * 为匹配的类型生成代理对象，代理对象实现指定接口，需提供接口中抽象方法的具体实现
     *
     * 切面实例化模型，prethis，pretarget
     * 切面默认是单例bean
     */

    private static final Log log = LogFactory.getLog(AOP.class);

    interface TargetInterface{
        void targetMethod();
    }

    class Target implements TargetInterface{
        @Override
        public void targetMethod() {
            log.info("This is Target's targetMethod");
        }
    }

    static class TargerWithOutInterface{
        public void targetMethod() {
            log.info("This is TargerWithOutInterface's targetMethod");
        }
    }

    @Test
    public void testProxy(){
        TargetInterface proxyObject = (TargetInterface) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{TargetInterface.class},
                (proxy, method, args) -> {
                    log.info("This is proxyObject's targetMethod");
                    return method.invoke(new Target(),args);
                });
        proxyObject.targetMethod();
    }

    @Test
    public void testEnhancer(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TargerWithOutInterface.class);
        enhancer.setCallback(new MethodInterceptor(){
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                log.info("This is proxyObject's targetMethod");
                return methodProxy.invokeSuper(o, args);
            }
        });

        TargerWithOutInterface proxy = (TargerWithOutInterface) enhancer.create();
        proxy.targetMethod();
    }
}
