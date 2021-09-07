package aopdemo.aspect;

import aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(1)
public class DemoLoggingAspect {

    private static Logger logger = Logger.getLogger(DemoLoggingAspect.class.getName());

    @Around("execution(* aopdemo.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortuneAdvice(ProceedingJoinPoint pj) throws Throwable{

        logger.info("[I] Inside @Around Method : " + pj.getSignature().toShortString());
        long start = System.currentTimeMillis();

        Object result = null;

        try{
            pj.proceed();
        } catch (Exception e){
            logger.warning("[W] Exception caught in @Around : " + e);
            result = "Rerouting weather";

            // Rethrowing Exceptions
            // throw e;
        }

        long end = System.currentTimeMillis();
        logger.info("[I] Timed function GetFortune() : " + (end - start));

        return result;
    }

    @After("execution(* aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint jp){

        logger.info("[I] Executing @After (finally) : " + jp.getSignature().toShortString());
    }

    @AfterThrowing(pointcut = "execution(* aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "tb")
    public void interceptExceptionAdvice(JoinPoint jp, Throwable tb){

        logger.info("[I] Exception occurred in class : " + jp.getSignature().toShortString());
        logger.info("[I] Exception : " + tb);
    }

    @AfterReturning(
            pointcut = "execution(* aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint jp, List<Account> result){

        String method = jp.getSignature().toShortString();
        logger.info("[I] Executing @AfterReturn Method");

        logger.info("[I] Result is : " + result);

        if(!result.isEmpty()) {
            logger.info("[I] Converting names to uppercase");
            updateAccountNamesToUppercase(result);
            logger.info("[I] Modified data : " + result);
        }

    }

    private void updateAccountNamesToUppercase(List<Account> result) {
        if(!result.isEmpty()){
            for(Account acc : result){
                acc.setName(acc.getName().toUpperCase());
            }
        }
    }


    @Before("aopdemo.aspect.AopExpressions.excludeGetterAndSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){
        logger.info("[A] @Before Advice");

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        logger.info("[A] Info - Signature: " + signature);

        Object args[] = joinPoint.getArgs();
        for(Object arg : args)
        {
            logger.info("[A] Info - Arguments: " + arg);
            if(arg instanceof Account)
                logger.info("[A] Info - Arguments: Accounts: " + ((Account)arg));
        }
    }
}
