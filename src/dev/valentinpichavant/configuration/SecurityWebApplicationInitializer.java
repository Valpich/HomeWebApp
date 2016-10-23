package dev.valentinpichavant.configuration;

/**
 * Created by valentinpichavant on 10/22/16.
 */

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityWebApplicationInitializer
        extends AbstractSecurityWebApplicationInitializer {

    public SecurityWebApplicationInitializer() {
        super(SecurityContext.class);
    }
}