package yeling.spring.web.common;

public class AfterThrowingAdvice {
	public void exceptionLog() {
		System.out.println("[예외처리] :  비즈니스 로직 수행 중 예외 발생");
	}
}
