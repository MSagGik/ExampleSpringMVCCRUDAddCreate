package ru.msaggik.spring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMVCDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringConfig.class}; // spring конфигурация для замены web.xml
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"}; // все http запросы посылаются на диспетчер сервлет
    }
}
