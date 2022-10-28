package com.example.personalproject.dao.jdbc;

import com.example.personalproject.dao.UserDao;
import com.example.personalproject.domain.User;
import com.example.personalproject.mapper.UserRowMapper;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public abstract class UserDaoJDBC implements UserDao {
    JdbcTemplate jdbcTemplate;
    UserRowMapper userRowMapper;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private static final List<User> users;

    static {
        users = new ArrayList<>();
    }

    public UserDaoJDBC() {}
    @Autowired
    public UserDaoJDBC(JdbcTemplate jdbcTemplate, UserRowMapper userRowMapper, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.userRowMapper = userRowMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public User getUserByID(int userID) {
        // For Hibernate
        return null;
    }
    @Override
    public void updateUser(User user) {
        // For Hibernate
    }

    @Override
    public List<User> getAllUser() {
        String query = "SELECT * FROM User";
        List<User> users = jdbcTemplate.query(query, userRowMapper);
        return users;
    }
    @Override
    public Optional<User> validateLogin(User user) {
        String query = "SELECT * FROM User";
        List<User> users = jdbcTemplate.query(query, userRowMapper);
        return users.stream().filter(
                a -> a.getUserName().equals(user.getUserName()) &&
                        a.getPassword().equals(user.getPassword())
        ).findAny();
    }

    @Override
    public void createNewUser(User user) {
        String query = "INSERT INTO User (userName, password, firstName, lastName, email, address, phoneNum) " +
                "values (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, user.getUserName(), user.getPassword(), user.getFirstName(), user.getLastName(),
                user.getEmail(), user.getAddress(), user.getPhoneNum());
    }
}
