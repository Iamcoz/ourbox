package ourbox.config.ourbox;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.method.ControllerAdviceBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/*
 <!-- kr.or.ddit 패키지 하위의 클래스중 @Service, @Repository 어노테이션이 붙은 클래스를 스캔하여 스프링 빈으로 생성 -->
<context:component-scan base-package="kr.or.ddit" use-default-filters="false">
		<context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
		<context:include-filter type="annotation" expression="org.springframework.web.method.ControllerAdviceBean"/>
	</context:component-scan>
 */
@Configuration
@ComponentScan(basePackages = {"ourbox"}, useDefaultFilters=false,
				includeFilters = {@Filter(type=FilterType.ANNOTATION, classes = {Controller.class, ControllerAdviceBean.class})})

//<mvc:annotation-driven/>
@EnableAspectJAutoProxy
public class ApplicationContext extends WebMvcConfigurerAdapter{

	//<mvc:default-servlet-handler/> ==> extends 구현(WebMvcConfigurerAdapter)
	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

	
	@Bean()
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		
		messageSource.setBasenames("classpath:kr/or/ddit/config/message/error",
								   "classpath:kr/or/ddit/config/message/msg");
		return messageSource;
	}
	
	//<bean id="excelView" class="kr.or.ddit.mvc.view.ExcelDownloadView"></bean>
//	@Bean()
//	public ExcelDownloadView excelView() {
//		return new ExcelDownloadView();
//	}
//	
//	//<bean id="downloadView" class="kr.or.ddit.mvc.view.DownloadView"></bean>
//	@Bean()
//	public DownloadView downloadView() {
//		return new DownloadView();
//	}
//	
//	//<bean id="profileImgView" class="kr.or.ddit.mvc.view.ProfileImgView"></bean>
//	@Bean()
//	public ProfileImgView profileImgView() {
//		return new ProfileImgView();
//	}
//	
//	//<bean id="jsonView" class="org.springframework.web.servlet.view.json.MappingJackson2JsonView"/>
//	@Bean()
//	public MappingJackson2JsonView jsonView() {
//		return new MappingJackson2JsonView();
//	}

	/*
	<bean class="org.springframework.web.servlet.view.BeanNameViewResolver">
      <property name="order" value="1"></property>
   	</bean>
	 */
	@Bean()
	public BeanNameViewResolver beanNameViewResolver() {
		BeanNameViewResolver beanNameViewResolver = new BeanNameViewResolver();
		beanNameViewResolver.setOrder(1);
		return beanNameViewResolver;
	}
	
	/*
	 <bean id="tilesConfigurer" class="org.springframework.web.servlet.view.tiles3.TilesConfigurer">
		<property name="definitions">
			<list>
				<value>classpath:kr/or/ddit/config/tiles/tiles-definition.xml</value>
			</list>
		</property>
	</bean>
	 */
//	@Bean()
//	public TilesConfigurer tilesConfigurer() {
//		TilesConfigurer tilesConfigurer = new TilesConfigurer();
//		tilesConfigurer.setDefinitions("classpath:kr/or/ddit/config/tiles/tiles-definition.xml");
//		return tilesConfigurer;
//	}
	
	/*
	<bean class="org.springframework.web.servlet.view.tiles3.TilesViewResolver">
	    <property name="order" value="0"></property>
		<property name="viewClass" value="org.springframework.web.servlet.view.tiles3.TilesView"></property>
	</bean> 
	 */
//	@Bean()
//	public TilesViewResolver tilesViewResolver() {
//		TilesViewResolver tilesViewResolver = new TilesViewResolver();
//		tilesViewResolver.setOrder(0);
//		tilesViewResolver.setViewClass(TilesView.class);
//		return tilesViewResolver;
//	}
	
	/*
	 <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="order" value="2"></property>
		<property name="prefix" value="/WEB-INF/views/"/>
		<property name="suffix" value=".jsp"/>
	</bean>
	 */
	
	@Bean()
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setOrder(2);
		internalResourceViewResolver.setPrefix("/WEB-INF/view/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}
	
	//<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver"></bean>
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		
		return multipartResolver;
	}
	
	//<bean id="localeResolver" class="org.springframework.web.servlet.i18n.SessionLocaleResolver"></bean>
	@Bean
	public SessionLocaleResolver localeResolver() {
		return new SessionLocaleResolver();
	}
	
	//<mvc:resources mapping="/resources/**" location="/WEB-INF/views/error/"/>
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/view/error/");
	}
	
	
	/*
	 <mvc:interceptors>
			<mvc:interceptor>
				<mvc:mapping path="/**"/>
				<bean class="org.springframework.web.servlet.i18n.LocaleChangeInterceptor">
					<property name="paramName" value="lang"></property>
				</bean>
			</mvc:interceptor>
	</mvc:interceptors>
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		registry.addInterceptor(localeChangeInterceptor).addPathPatterns("/**");
	}
}
