package aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class ApiPerformanceAspect {
    @Before("aopdemo.aspect.AopExpressions.excludeGetterAndSetter()")
    public void performAPIAnalytics(){
        System.out.println("[P] Performing Analytics");
    }
}
