package com.hplegend.quick_start_byname;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hp.he
 * @date 2020/10/3 11:58
 */
public class QuickstartByNameApplication {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("quickstart-byname.xml");
        Person person = (Person) factory.getBean("person");
        System.out.println(person);
    }
}
