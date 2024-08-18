package org.example.final_project.config_app;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ConfigApp.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/anton/*"};
    }
}
