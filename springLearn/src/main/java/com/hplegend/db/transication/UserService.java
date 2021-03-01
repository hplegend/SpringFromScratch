package com.hplegend.db.transication;

import com.hplegend.common.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * @author hp.he
 * @date 2021/1/4 20:23
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    TransactionTemplate transactionTemplate;

    public void saveAndQuery() {
        User user = new User();
        user.setName("阿巴阿巴");
        user.setTel("123654789");


        TransactionCallback callback = (status) -> {

            userDao.save(user);

            int i = 1 / 0;

            List<User> userList = userDao.findAll();
            System.out.println(userList);
            return null;
        };


        // template帮助我们管理了事务
        transactionTemplate.execute(callback);
    }
}