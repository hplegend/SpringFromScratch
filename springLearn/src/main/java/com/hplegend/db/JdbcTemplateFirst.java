package com.hplegend.db;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

/**
 * @author hp.he
 * @date 2021/1/4 15:44
 */
public class JdbcTemplateFirst {

    public static void main2(String[] args) {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost/spring_dao");
        dataSource.setUsername("postgres");
        dataSource.setPassword("");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);


        List ret = jdbcTemplate.queryForList("select * from tbl_user");
        System.out.println(ret);
    }

    public static void main(String[] args) {
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:spring-jdbc.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) classPathXmlApplicationContext.getBean("jdbcTemplate");
        List ret = jdbcTemplate.queryForList("select * from tbl_user");
        System.out.println(ret);
    }


}
