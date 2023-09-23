package com.in28minutes.learnspringframework.e1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
class NormalClass {

}

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototyeClass {

}

@Configuration
@ComponentScan
public class BeanScopeApplicationLauncher {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(BeanScopeApplicationLauncher.class)) {

            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));

            System.out.println(context.getBean(PrototyeClass.class));
            System.out.println(context.getBean(PrototyeClass.class));
            System.out.println(context.getBean(PrototyeClass.class));
        }
    }
}
