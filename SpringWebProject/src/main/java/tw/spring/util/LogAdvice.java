package tw.spring.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("logAdvice")
@Aspect
public class LogAdvice {
	@Pointcut(value = "execution(* tw.spring.model.HouseService.selectBy*(..))")
	public void pointcut1() {
		
	}
	
	@Before(value = "pointcut1()")
	public void logBefore(JoinPoint p) {
		System.out.println("before at " + p.getTarget().getClass() + " ");
		System.out.println("calling " + p.getSignature().getName() + " ");
		System.out.println("using " + p.getArgs()[0]);
		System.out.println("before: going into Joinpoint Method ");
	}
	
	@Around(value = "pointcut1()")
	public Object logAround(ProceedingJoinPoint p) throws Throwable {
		System.out.println("around at " + p.getTarget().getClass() + " ");
		System.out.println("calling " + p.getSignature().getName() + " ");
		System.out.println("using " + p.getArgs()[0]);
		Object result = p.proceed();
		System.out.println("result: " + result);
		return result;
	}
	
	@AfterReturning(pointcut = "pointcut1()", returning = "result")
	public void logAfter(JoinPoint p, Object result) {
		System.out.println("after: " + result);
	}
	
	@AfterThrowing(pointcut = "pointcut1()", throwing = "e")
	public void logThrow(JoinPoint p, Throwable e) {
		System.out.println("exception: " + e);
	}
	
}
