package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    Util util = new Util();
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Connection connection = util.getConnection()){
            connection
                    .prepareStatement("CREATE TABLE IF NOT EXISTS users (id serial not null , name varchar(10), lastName varchar(10), age int)")
                    .executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try (Connection connection = util.getConnection()){
            connection
                    .prepareStatement("DROP TABLE if exists users")
                    .executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {

    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {
        try (Connection connection = util.getConnection()){
            connection
                    .prepareStatement("TRUNCATE TABLE users")
                    .executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
