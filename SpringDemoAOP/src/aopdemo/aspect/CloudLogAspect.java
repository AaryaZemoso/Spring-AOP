package aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class CloudLogAspect {
    @Before("aopdemo.aspect.AopExpressions.excludeGetterAndSetter()")
    public void logToCloud(){
        System.out.println("[C] Logging to cloud");
    }
}
