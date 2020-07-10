package com.sheng.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


// 切面类(代理类)
@Component
@Aspect
public class MyAspect {
    /**
     * 切面，定义切入点，切入点表达式
     * execution：用于匹配执行的方法
     * 切入点表达式：
     * * 匹配任意字符
     * 方法的修饰符，返回值类型， 方法所在的类的路径，方法（参数列表）
     */
    @Pointcut(value = "execution(public * com.sheng.service.UserService.login(..))")
    public void pointcut() {
    }

    /**
     * 重要的属性：value：切入点表达式，或者切入点方法
     */
    @Before(value = "pointcut()")
    public void before() {
        System.out.println("2、核心方法之前：@before 前置增强");
    }

    @AfterReturning(value = "pointcut()")
    public void afterReturning() {
        System.out.println("4、在核心方法正常之后：@AfterReturning 后置增强");
    }

    /**
     * 如果处理了异常，不会执行异常通知
     *
     * @param e 异常
     */
    @AfterThrowing(value = "pointcut()", throwing = "e")
    public void AfterThrowing(Exception e) {
        System.out.println(e.getMessage());
        if (e instanceof ArithmeticException) {
            System.out.println("3、ArithmeticException");
        }
        System.out.println("3、核心方法异常之后：@AfterThrowing 异常通知");
    }

    /**
     * 后置通知，最终通知
     */
    @After("pointcut()")
    public void after() {
        System.out.println("5、最终通知：@After 最终通知");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint){
        Object proceed = null;
        try {
            System.out.println("1、环绕通知 --> 核心方法之前");
            proceed = joinPoint.proceed();
            System.out.println("6、环绕通知 --> 核心方法之后");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;
    }
}
