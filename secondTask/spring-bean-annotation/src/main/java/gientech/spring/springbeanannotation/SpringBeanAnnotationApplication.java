package gientech.spring.springbeanannotation;

import gientech.spring.springbeanannotation.controller.UserController;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringBeanAnnotationApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBeanAnnotationApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("config/ApplicationContext.xml");
        UserController userController = (UserController)ac.getBean("userController");
        userController.save();
    }

}
