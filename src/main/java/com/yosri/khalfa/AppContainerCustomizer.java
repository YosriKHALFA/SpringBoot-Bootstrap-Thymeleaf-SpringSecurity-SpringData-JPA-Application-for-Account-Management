package com.yosri.khalfa;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.stereotype.Component;

@Component
public class AppContainerCustomizer implements EmbeddedServletContainerCustomizer {
 
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
 
        container.setPort(9000);
 
    }
}