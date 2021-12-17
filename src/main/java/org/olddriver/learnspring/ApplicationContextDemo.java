package org.olddriver.learnspring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration("demo")
@ComponentScan(basePackageClasses = {ApplicationContextDemo.class})
@EnableAspectJAutoProxy
public class ApplicationContextDemo {

    public static void main(String[] args){
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ApplicationContextDemo.class);
        A a = (A) applicationContext.getBean("a");
        System.out.println(a.getB());
    }
}
