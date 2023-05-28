package com.example.blog_board.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class LoggingAop {
    @Pointcut("execution(* com.example.blog_board.controller..*.*(..))")
    public void Controller(){}

    @Around("Controller()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        Object result = joinPoint.proceed();
        stopWatch.stop();

        System.out.println(joinPoint.getTarget().getClass().getSimpleName() + "." + joinPoint.getSignature().getName() +" 수행 시간 = " + stopWatch.getTotalTimeMillis() + "ms");

        return result;
    }
}





/* hint
    @Pointcut("execution(* com.example.blog_board.controller..*.*(..))")
    
    @Around("Controller()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        joinPoint.proceed();
    }

 */

