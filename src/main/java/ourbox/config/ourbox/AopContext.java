package ourbox.config.ourbox;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;

/*
 <!-- kr.or.ddit 패키지 하위의 클래스중 @Service, @Repository 어노테이션이 붙은 클래스를 스캔하여 스프링 빈으로 생성 -->
	<context:component-scan base-package="kr.or.ddit" use-default-filters="false">
		<context:include-filter type="annotation" expression="org.springframework.stereotype.Service"/>
		<context:include-filter type="annotation" expression="org.springframework.stereotype.Repository"/>
	</context:component-scan> 
 */
@Configuration
@ComponentScan(basePackages = {"ourbox"}, useDefaultFilters=false,
				includeFilters = {@Filter(type=FilterType.ANNOTATION,
				classes = {Aspect.class, Repository.class})})
@EnableAspectJAutoProxy
public class AopContext {
	
	


}
