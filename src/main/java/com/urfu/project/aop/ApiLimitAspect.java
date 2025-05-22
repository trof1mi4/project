package com.urfu.project.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class ApiLimitAspect {
    @Value("${api.max-calls}")
    private int maxCalls;
    private final Map<String, Integer> callCounters = new HashMap<>();

    @Around("@annotation(com.urfu.project.annotation.ApiLimit)")
    public Object enforceLimit(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();

        var currentCount = callCounters.getOrDefault(methodName, 0) + 1;
        callCounters.put(methodName, currentCount);

        if (currentCount > maxCalls)
            return "Превышен лимит вызовов (" + maxCalls + ") для метода: " + methodName;

        return joinPoint.proceed();
    }
}
