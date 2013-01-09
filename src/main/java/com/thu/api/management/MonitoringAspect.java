package com.thu.api.management;

import java.lang.reflect.Method;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.util.StopWatch;

/**
 *
 * @author liushuai
 */
@Aspect
public class MonitoringAspect {

    private Logger logger = Logger.getLogger(getClass());

    @Around("@annotation(com.thu.api.management.Monitored)")
    public Object monitorPerformance(ProceedingJoinPoint jp) throws Throwable {
        Object returnValue = null;
        Monitored monitored = getAnnotation(jp);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(monitored.value());
        try {
            returnValue = jp.proceed();
        } finally {
            stopWatch.stop();
            logger.info("ELAPSED TIME: " + stopWatch);
        }
        return returnValue;
    }

    public Monitored getAnnotation(ProceedingJoinPoint joinPoint) {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        return method.getAnnotation(Monitored.class);
    }
    
}
