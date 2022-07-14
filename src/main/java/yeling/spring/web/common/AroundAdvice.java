package yeling.spring.web.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {
	public Object aroundLog(ProceedingJoinPoint joinPoint)throws Throwable{
		System.out.println("[BEFORE] : ����Ͻ� �޼��� ���� �� ó���� ����!!!");
		Object returnObj = joinPoint.proceed(); //�ٽɷ��� �����ϼ���
		System.out.println("[AFTER] ����Ͻ� �޼��� ���� �� ó���� ����~~");
		return returnObj;
	}
}
