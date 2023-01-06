package com.example.coursclassroomexam.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class Logging {

//    public class PerformanceAspect {
//
//        @Around("execution(* tn.esprit.spring.services.*.*(..))")
//        public void profile(ProceedingJoinPoint pjp) throws Throwable {
//            long start = System.currentTimeMillis();
//            pjp.proceed();
//            long elapsedTime = System.currentTimeMillis() - start;
//            log.info("Method execution time: " + elapsedTime + " milliseconds.");
//        }
//    }

//    public class afficheMessage {
//        @Pointcut("execution(* com.example.coursclassroomexam.Controllers.CcController.ajouter*(..))")
//        public void loggingPoint() {}
//        @Before("loggingPoint")
//        public void logMethodEntry(JoinPoint joinPoint) {
//            String name = joinPoint.getSignature().getName();
//            log.info("Début Execution : " + name + " : ");
//        }
//    }
@AfterReturning("execution(void com.example..*(..))")
public void logMethodEntry(JoinPoint joinPoint) {
    String name = joinPoint.getSignature().getName();
    log.info("With success " + name );
}
}