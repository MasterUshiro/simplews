package ua.com.simplews.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//https://ru.stackoverflow.com/questions/873216/springboot-aplication-not-a-managed-type-exception
@SpringBootApplication
@EnableJpaRepositories("ua.com.simplews.repos")
@EntityScan(basePackages = "ua.com.simplews.domain")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);


    }

//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
//
//            System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                //System.out.println(beanName);
//            }
//
//        };
//    }

}


