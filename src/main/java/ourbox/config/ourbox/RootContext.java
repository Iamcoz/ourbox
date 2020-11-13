package ourbox.config.ourbox;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/*
 <!-- kr.or.ddit 패키지 하위의 클래스중 @Service, @Repository 어노테이션이 붙은 클래스를 스캔하여 스프링 빈으로 생성 -->
	<context:component-scan base-package="kr.or.ddit" use-default-filters="false">
		<context:include-filter type="annotation" expression="org.springframework.stereotype.Service"/>
		<context:include-filter type="annotation" expression="org.springframework.stereotype.Repository"/>
	</context:component-scan> 
 */

//@ImportResource({"classpath:kr/or/ddit/config/spring/aop-context.xml"})
//@Import({AopContext.class, DataSourceContext.class, TransactionContext.class})
@Configuration
@ComponentScan(basePackages = {"ourbox"}, useDefaultFilters=false,
				includeFilters = {@Filter(type=FilterType.ANNOTATION, classes = {Service.class, Repository.class})})

public class RootContext {
	/*
	 * <bean id="messageSource" class=
	 * "org.springframework.context.support.ReloadableResourceBundleMessageSource">
	 * 		<property name="basenames"> <list>
	 * <value>classpath:kr/or/ddit/config/message/error</value>
	 * <value>classpath:kr/or/ddit/config/message/msg</value> </list> </property>
	 * </bean>
	 */
	@Bean()
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		
		messageSource.setBasenames("classpath:kr/or/ddit/config/message/error",
								   "classpath:kr/or/ddit/config/message/msg");
		return messageSource;
	}

}
