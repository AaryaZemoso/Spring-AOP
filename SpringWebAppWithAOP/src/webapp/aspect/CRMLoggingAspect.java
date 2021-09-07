package webapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* webapp.controller.*.*(..))")
    private void controllerExp(){}

    @Pointcut("execution(* webapp.service.*.*(..))")
    private void serviceExp(){}

    @Pointcut("execution(* webapp.dao.*.*(..))")
    private void daoExp(){}

    @Pointcut("controllerExp() || serviceExp() || daoExp()")
    private void appFlowExp(){}

    @Before("appFlowExp()")
    public void before(JoinPoint jp)
    {
        logger.info("\n[I] From @Before called method : " + jp.getSignature().toShortString());

        Object args[] = jp.getArgs();
        for(Object arg : args){
            logger.info("Arguments : " + arg);
        }
    }

    @AfterReturning(
            pointcut = "appFlowExp()",
            returning = "result"
    )
    public void afterReturning(JoinPoint jp, Object result){

        logger.info("\n[I] Inside @AfterReturning, called method : " + jp.getSignature().toShortString());

        Object args[] = jp.getArgs();
        for(Object arg : args){
            logger.info("Arguments : " + arg);
        }

        logger.info("\n[I] Returning data : " + result);

    }


}
