package aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* add*(..))")
    public void allAddMethods(){}

    @Pointcut("execution(* aopdemo.dao.*.*(..))")
    public void everyMethod(){}

    @Pointcut("execution(* aopdemo.dao.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(* aopdemo.dao.*.set*(..))")
    public void setter(){}

    @Pointcut("everyMethod() && !(getter() || setter())")
    public void excludeGetterAndSetter(){}

}
