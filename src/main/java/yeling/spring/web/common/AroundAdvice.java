package yeling.spring.web.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
	
	@Around("PointcutCommon.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint joinPoint)throws Throwable{
		String method = joinPoint.getSignature().getName();
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object returnObj = joinPoint.proceed();
		stopWatch.stop();
		System.out.println(method + "() �޼��� ���࿡ �ɸ� �ð� : " + stopWatch.getTotalTimeMillis() + "(ms)��" );
//		System.out.println("[BEFORE] : ����Ͻ� �޼��� ���� �� ó���� ����!!!");
//		Object returnObj = joinPoint.proceed(); //�ٽɷ��� �����ϼ���
//		System.out.println("[AFTER] ����Ͻ� �޼��� ���� �� ó���� ����~~");
		return returnObj;
	}
}
