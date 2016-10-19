package dev.valentinpichavant.configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/**
 * Created by dev.valentinpichavant on 10/17/16.
 */
@Configuration
@ComponentScan(basePackages = "dev.valentinpichavant")
@EnableWebMvc
class ApplicationConfiguration extends WebMvcConfigurerAdapter {

    private SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure("/dev/valentinpichavant/configuration/hibernate.cfg.xml") // configures settings
            // from
            // hibernate.cfg.xml
            .buildSessionFactory();


    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Scope("application")
    @Bean(destroyMethod = "close")
    public Session getSession() {
        return sessionFactory.openSession();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/WEB-INF/jsp/index.jsp");
    }
}
