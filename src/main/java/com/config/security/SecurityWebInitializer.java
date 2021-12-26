package com.config.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/*The SecurityInitializer does the following things:

        Adds a ContextLoaderListener that loads the WebSecurityConfig.

        Finds the bean of type Filter named springSecurityFilterChain
        and registers it to process every URL in the application.*/



public class SecurityWebInitializer extends AbstractSecurityWebApplicationInitializer {
    public SecurityWebInitializer() {
        super(SecurityConfig.class);
    }
}
