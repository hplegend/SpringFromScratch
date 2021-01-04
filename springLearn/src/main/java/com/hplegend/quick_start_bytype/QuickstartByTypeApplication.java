package com.hplegend.quick_start_bytype;

import com.hplegend.common.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hp.he
 * @date 2020/10/3 11:58
 */
public class QuickstartByTypeApplication {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("quickstart-bytype.xml");
        Person person = factory.getBean(Person.class);
        System.out.println(person);
    }
}