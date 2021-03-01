package com.hplegend.db.transication;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hp.he
 * @date 2021/1/4 20:24
 */
public class TransicationMain {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:spring-jdbc.xml");

         UserService userService = (UserService) classPathXmlApplicationContext.getBean("userService");

         userService.saveAndQuery();


    }
}
