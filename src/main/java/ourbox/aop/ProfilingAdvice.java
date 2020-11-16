//package ourbox.aop;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//@Aspect
//public class ProfilingAdvice {
//	private static final Logger logger = LoggerFactory.getLogger(ProfilingAdvice.class);
//	
//	//pointCut 설정을 위한 의미 없는 메소드
//	@Pointcut("execution(* ourbox..service.*.*(..))")
//	public void dummy() {
//		
//	}
//	
//	@Before("dummy()") 	//어느 pointCut을 적용할지 메소드명을 문자열로 입력한다.
//	public void beforMethod(JoinPoint joinPoint) {
//		//getSignature() -> 함수에 대한 이름정보나 접근제어 정보를 알 수 있음
//		logger.debug("beforeMethod : {}", joinPoint.getSignature().getName());
//	}
//	
//	@Around("dummy()")
//	public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//		//메소드 실행 전 공통 관심사항
//		//시간 측정
//		long start = System.currentTimeMillis();
//		
//		//메소드 실행
//		Object ret = joinPoint.proceed(joinPoint.getArgs());
//		// ->어느 타입으로 리턴받을지 arround는 모르기 때문에 obj로 받는다.
//		
//		//메소드 실행 후 공통 관심사항
//		long end = System.currentTimeMillis();
//		
//		logger.debug("profiling : {} {} - {}", joinPoint.getSignature().getDeclaringTypeName(),
//												joinPoint.getSignature().getName(),
//												end-start+"ms");
//		return ret;
//	}
//}
