package ourbox.config.ourbox;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class InterceptorContext extends WebMvcConfigurerAdapter{
	
//	/*
//	 <!-- intercepter 설정 -->
//		<!-- <mvc:interceptors>
//			<mvc:interceptor>
//				<mvc:mapping path="/**"/>
//				<bean class="kr.or.ddit.mvc.interceptor.PerformanceCheckInterceptor"></bean>
//			</mvc:interceptor>
//			
//			//안티패턴 -> 해당 경로에 대해서는 pattern을 적용하지 않겠다
//			<mvc:interceptor>
//				<mvc:mapping path="/**"/>
//				<mvc:exclude-mapping path="/login/**"/>
//				<mvc:exclude-mapping path="/js/**"/>
//				<mvc:exclude-mapping path="/resources/**"/>
//				<bean class="kr.or.ddit.mvc.interceptor.SessionCheckInterceptor"></bean>
//			</mvc:interceptor>
//		</mvc:interceptors> -->
//	 */
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(new PerformanceCheckInterceptor()).addPathPatterns("/**");
//		registry.addInterceptor(new SessionCheckInterceptor()).addPathPatterns("/**")
//				.excludePathPatterns("/login/**", "/js/**", "/css/**", "/resources/**");
//	}

}
