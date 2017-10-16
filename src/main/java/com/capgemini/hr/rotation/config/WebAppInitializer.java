package com.capgemini.hr.rotation.config;

import com.capgemini.hr.rotation.config.servlet.ServletContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    public WebAppInitializer() {
    }

    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{HrRotationAppConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ServletContext.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}