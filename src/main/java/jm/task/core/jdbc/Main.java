package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

        UserService userService = new UserServiceImpl();

//        userService.createUsersTable();
//
//        userService.saveUser("Garmoniya", "Kuular", (byte) 3);

//        userService.removeUserById(1);
//        userService.cleanUsersTable();
        List<User> allUsers = userService.getAllUsers();

        System.out.println(allUsers);
        userService.dropUsersTable();

    }
}
