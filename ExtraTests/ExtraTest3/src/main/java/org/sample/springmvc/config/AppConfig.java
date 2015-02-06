package org.sample.springmvc.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="org.sample.springmvc.extra")
public class AppConfig extends WebMvcConfigurationSupport {

    @Bean(name = "messageSource")
    public MessageSource setMessageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        /*
         * <value>classpath:i18n/global</value>
         * <value>classpath:i18n/org/sample/springmvc/extra/ExtraTest2</value>
         * <value>classpath:i18n/validation/ValidationMessages</value>
         */
        System.out.println("Set Basenames");
        messageSource.setBasenames("WEB-INF/classes/i18n/global",
                "WEB-INF/classes/i18n/org/sample/springmvc/extra/ExtraTest2",
                "WEB-INF/classes/i18n/validation/ValidationMessages");
        messageSource.setFallbackToSystemLocale(false);
        return messageSource;
    }
}
