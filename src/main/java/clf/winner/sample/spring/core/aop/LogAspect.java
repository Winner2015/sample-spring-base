package clf.winner.sample.spring.core.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LogAspect {

    //声明切点
//    @Pointcut("@annotation(clf.winner.sample.spring.core.aop.Log)")
//    public void doLog(){};


//    @Around(value = "doLog() && @annotation(log)")
    @Around("@annotation(log)")
    public Object log(ProceedingJoinPoint joinPoint, Log log) throws Throwable {

        Method method = getMethod(joinPoint);
        Object[] args = joinPoint.getArgs();

        // 获取被拦截方法参数名列表(使用Spring支持类库)
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paraNameArr = u.getParameterNames(method);

        // SPEL上下文
        StandardEvaluationContext context = new StandardEvaluationContext();
        for (int i = 0; i < paraNameArr.length; i++) {
            context.setVariable(paraNameArr[i], args[i]);
        }

        ExpressionParser parser = new SpelExpressionParser();
        // 使用SPEL进行key的解析
        String userId = parser.parseExpression(log.id()).getValue(context, String.class);
        String userName = parser.parseExpression(log.name()).getValue(context, String.class);

        System.out.println("AOP for login, userId: " + userId + ", userName: " + userName);

        Object result = joinPoint.proceed();

        return result;
    }

    public Method getMethod(ProceedingJoinPoint pjp) {
        //获取参数的类型
        Class[] argTypes = ((MethodSignature) pjp.getSignature()).getMethod().getParameterTypes();

        Method method = null;
        try {
            method = pjp.getTarget().getClass().getMethod(pjp.getSignature().getName(), argTypes);
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        return method;

    }

}
