package com.leekoy.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author pd 2018/3/22.
 */
public class LinuxCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        boolean bValue = conditionContext.getEnvironment().getProperty("os.name").contains("Linux");
        System.out.println("linux .......");
        System.out.println(bValue);
        return bValue;
    }

}
