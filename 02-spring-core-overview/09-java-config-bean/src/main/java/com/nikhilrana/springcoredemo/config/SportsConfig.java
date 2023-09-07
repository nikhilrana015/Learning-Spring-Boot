package com.nikhilrana.springcoredemo.config;

import com.nikhilrana.springcoredemo.common.Coach;
import com.nikhilrana.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
    This type of bean creation is called as java-code bean creation.
    It is useful to create the beans for third-party classes which are not accessible.
    So, code of third-party is not accessible, hence we can't create beans using the
    component annotation. So in that case we have to create the configClass and then creates
    bean by using the new keyword and using the configuration and bean annotation.

    One thing to remember, id of the bean is the methodName. So when using the bean
    at the DemoController and injecting the dependency using the qualifier annotation
    we provide this methodName beans is tracked by id which is methodName in our case.

    We can also provide the bean id with the bean annotation
    @Bean(beanId). Then in that case, methodName is not our beanId.

    @Bean use case:
    Take existing third party class and expose as a spring bean

 */
@Configuration
public class SportsConfig {
    @Bean("nikhilBean")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
