package com.erensayar.HrApp.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author erensayar
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/addJob").setViewName("addJob");
        registry.addViewController("/adminHome").setViewName("adminHome");
        registry.addViewController("/apply").setViewName("apply");
        registry.addViewController("/applyDone").setViewName("applyDone");
        registry.addViewController("/detailsOfApplicant").setViewName("detailsOfApplicant");
        registry.addViewController("/detailsOfJob").setViewName("detailsOfJob");
    }

}
