package com.leekoy.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author pd 2018/3/22.
 */
@Configuration
public class ConditionalConfig {


    @Bean
    @Conditional(WindowsCondition.class)
    public BasicService getWindowsService() {
        return new WindowsService();
    }


    @Bean
    @Conditional(LinuxCondition.class)
    public BasicService getLinuxService() {
        return new LinuxService();
    }

}
