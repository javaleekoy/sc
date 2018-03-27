package com.leekoy;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author pd
 */
@SpringBootApplication
public class App{
    public static void main( String[] args ){
        new SpringApplicationBuilder(App.class).web(true).run(args);
    }
}
