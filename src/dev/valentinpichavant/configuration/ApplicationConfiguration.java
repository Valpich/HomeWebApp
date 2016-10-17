package dev.valentinpichavant.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;

/**
 * Created by dev.valentinpichavant on 10/17/16.
 */
@Configuration
@ComponentScan(basePackages = "dev.valentinpichavant")
@EnableWebMvc
class ApplicationConfiguration extends WebMvcConfigurerAdapter {

    @PostConstruct
    public void init() {
        System.out.print("Instianciated");
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        return null;
    }

    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
