package org.sample.springmvc.config;

import java.net.URL;

import javax.servlet.ServletContext;

import org.apache.commons.validator.ValidatorResources;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="org.sample.springmvc.extra")
public class AppConfig extends WebMvcConfigurationSupport implements ServletContextAware {

    private ServletContext servletContext;
    
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
    
    @Bean
    public ViewResolver setupViewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        UrlBasedViewResolver resolver = new UrlBasedViewResolver(); 
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    @Bean(name = "messageSource")
    public MessageSource setMessageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        /*
         * <value>classpath:i18n/global</value>
         */
        System.out.println("Set Basenames");
        messageSource.setBasenames("WEB-INF/classes/i18n/global",
                "WEB-INF/classes/i18n/org/sample/springmvc/extra/ExtraTest2");
        messageSource.setFallbackToSystemLocale(false);
        return messageSource;
    }
    
    @Bean(name = "validatorResource")
    public ValidatorResources validator() {
        ValidatorResources validator = null;
        try {
            // 読み込むリソースファイルのURLリストを作成
            URL[] urlList = {servletContext.getResource("/WEB-INF/validation.xml")};
            validator = new ValidatorResources(urlList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return validator;
    }
}
