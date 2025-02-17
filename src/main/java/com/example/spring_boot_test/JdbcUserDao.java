package com.example.spring_boot_test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class JdbcUserDao implements  UserDao {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    private InMemoryUserDao inMemoryUserDao;
    private User user;
    public JdbcUserDao(InMemoryUserDao inMemoryUserDao) {
        this.inMemoryUserDao = inMemoryUserDao;
    }



    public Stream<User> findAll() {
        String SELECT_ALL = "SELECT * FROM users";
        Map<String, Object> params = new HashMap<>();

        return jdbcTemplate.queryForStream(SELECT_ALL, params,
                (rs, rowNum) -> {
            return new User(
                    rs.getString("id"),
                    rs.getString("email"),
                    rs.getString("password")
            );
                });

    }


    public User getById(String id) {
        String SELECT_BY_ID = "SELECT * FROM users WHERE id =:id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        jdbcTemplate.queryForObject(SELECT_BY_ID, params,
                (rs, rowNum) -> {
                    User user = new User(null, null, null);
                    user.setId(rs.getString("id"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    return user;
                }
                );
        return null;
    }


    public User add(User user) {
        String ADD_USER = "INSERT INTO users VALUES (:id, :email, :password)";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", user.getId());
        map.put("email", user.getEmail());
        map.put("password", user.getPassword());
        jdbcTemplate.execute(ADD_USER, map, (PreparedStatementCallback) ps -> ps.executeUpdate());
        return user;
    }

    public void delete(String id) {
        String DELETE_USER = "DELETE FROM users WHERE id = :id";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        jdbcTemplate.execute(DELETE_USER, map, (PreparedStatementCallback) ps -> ps.executeUpdate());
        return;
    }
}
