package yeling.spring.web.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {
	@Pointcut("execution(* yeling.spring.web..*Impl.*(..))")
	public void allPointcut() {
		
	}
	@Pointcut("execution(* yeling.spring.web..*Impl.get*(..))")
	public void getPointcut() {
		
	}
}
