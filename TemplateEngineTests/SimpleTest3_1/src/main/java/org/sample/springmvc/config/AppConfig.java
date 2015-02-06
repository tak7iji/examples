package org.sample.springmvc.config;

import java.util.Collections;

import javax.servlet.ServletContext;

import org.sample.springmvc.extra.MessageBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import freemarker.cache.TemplateLoader;
import freemarker.cache.WebappTemplateLoader;
import freemarker.template.Version;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="org.sample.springmvc.extra")
public class AppConfig extends WebMvcConfigurationSupport {

    @Bean
    public FreeMarkerConfigurer freemarkerConfig() {
        FreeMarkerConfigurer freemarkerConfig = new FreeMarkerConfigurer();
        freemarkerConfig.setTemplateLoaderPath("/WEB-INF/ftl");
        return freemarkerConfig;
    }
    
    @Bean
    public ViewResolver setupViewResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setPrefix("");
        resolver.setSuffix(".ftl");
        return resolver;
    }

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
    
    @Bean(name = "mb")
    @Scope("application")
    public MessageBean message() {
        MessageBean mb = new MessageBean();
        mb.setMessage("Hello World!");
        return mb;
    }
}
