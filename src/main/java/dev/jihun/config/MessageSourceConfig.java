package dev.jihun.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class MessageSourceConfig {

    // Bean 등록시 이름은 꼭 messageSource가 되어야 한다. 만약 Bean 이름이 messageSource가 아니라면 messageSource가 정상적으로 동작하지 않는다.
    @Bean(name = "messageSource")
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    // Spring Boot 2.0.5 이상 2.3.0 미만 사용시에는 Validator 중 스프링이 제공해 주는 LocalValidatorFactoryBean Bean이 자동 등록 된다.
    // Spring Boot 2.3.0 이상 버전에는 validation 모듈이 분리되서, 추가로 의존성을 설정해 주어야 Validator 중 스프링이 제공해 주는 LocalValidatorFactoryBean Bean이 자동 등록 된다.
    /*@Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }*/
}
