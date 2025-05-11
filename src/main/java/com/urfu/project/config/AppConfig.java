package com.urfu.project.config;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Log4j2
@Configuration
public class AppConfig {

    @Bean
    @Profile("test")
    public TestOnlyBean testOnlyBean() {
        log.info("Создается TestOnlyBean, потому что активен профиль 'test'");
        return new TestOnlyBean();
    }

    @Bean
    @ConditionalOnBean(name = "testOnlyBean")
    public DependentBean dependentBean() {
        log.info("Создается DependentBean, потому что существует TestOnlyBean");
        return new DependentBean();
    }

    @Bean
    @ConditionalOnExpression("#{'${app.example-test}' != 'default'}")
    public EnvDependentBean envDependentBean() {
        log.info("Создается EnvDependentBean, потому что EXAMPLE_TEST не 'default'");
        return new EnvDependentBean();
    }

    @Getter @Setter
    public static class TestOnlyBean {}

    @Getter @Setter
    public static class DependentBean {}

    @Getter @Setter
    public static class EnvDependentBean {}
}