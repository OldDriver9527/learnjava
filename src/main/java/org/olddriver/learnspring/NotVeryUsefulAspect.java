package org.olddriver.learnspring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class NotVeryUsefulAspect {

    private static final Log log = LogFactory.getLog(NotVeryUsefulAspect.class);

    @Pointcut("within(org.olddriver.learnspring.controller..*)") // the pointcut expression
    private void anyMethod() {
    } // the pointcut signature

    @Pointcut("execution(* org.olddriver.learnspring.controller.ValidationController.addDept(..)) ") // the pointcut expression
    private void addDept() {
    } // the pointcut signature

    //@Before("anyMethod()")
    public void printParam(JoinPoint joinPoint){
        Arrays.stream(joinPoint.getArgs()).forEach((ele)->{
            log.info(joinPoint.getSignature()+" "+ele);
        });
    }

    @Before(value = "addDept() && args(d)")
    public void printParam(JoinPoint joinPoint,Dept d){
        log.info(joinPoint.getSignature()+" "+d);
    }

    @Before(value = "addDept() && args(d)")
    public void printCurrentTime(Dept d){
        log.info(LocalDateTime.now());
    }

    @Before(value = "execution(* org.olddriver.learnspring.controller.ValidationController.findDept(..)) && args(id,name)")
    public void printParam(JoinPoint joinPoint,String name,Integer id){
        log.info(joinPoint.getSignature()+" "+id + " " + name);
    }

    @Before(value = "execution(* org.olddriver.learnspring.controller.ValidationController.addDeptList(..)) && args(deptList)")
    public void printParam(JoinPoint joinPoint, List<Dept> deptList){
        log.info(joinPoint.getSignature()+" "+deptList);
    }

    @AfterReturning(value = "anyMethod()",returning = "retVal")
    public void printReturn(JoinPoint joinPoint , Object retVal){
        log.info(joinPoint.getSignature()+" "+retVal);
    }

    @AfterThrowing(value = "anyMethod()",throwing = "ex")
    public void printException(JoinPoint joinPoint , Object ex){
        log.info(joinPoint.getSignature()+" "+ex);
    }
}
