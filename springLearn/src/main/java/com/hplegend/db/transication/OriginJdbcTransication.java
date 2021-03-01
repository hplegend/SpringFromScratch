package com.hplegend.db.transication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author hp.he
 * @date 2021/1/4 20:06
 */
public class OriginJdbcTransication {

    public static void main(String[] args) throws SQLException {
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:spring-jdbc.xml");
        DataSource dataSource = (DataSource) classPathXmlApplicationContext.getBean("dataSource");

        // 原生的jdbc
        // 从DriverMannerger获取Connection。而spring的DriveManangerDatesource就是connection管理者
        // 所有的池化技术，解决频繁的生成问题

        Connection connection = dataSource.getConnection();

        // 关闭事务的提交，也就是开启事务
        connection.setAutoCommit(false);

        PreparedStatement preparedStatement = connection.prepareStatement("select * from tbl_user");

        ResultSet resultSet = preparedStatement.executeQuery();

        // 事务需要提交，否则就会一直占用连接
        connection.commit();
    }

}
