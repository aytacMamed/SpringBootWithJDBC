package com.changeside.jdbcspringboot.controller;

import com.changeside.jdbcspringboot.entity.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class JDBCController {
    private final DataSource dataSource;
    @PostMapping
    public Person create(Person person) throws SQLException {
        String sql="insert into person(name,surname) values(?,?)"  ;

      Connection  connection= dataSource.getConnection();
     PreparedStatement preparedStatement= connection.prepareStatement(sql);
     preparedStatement.setString(1, person.getName());
     preparedStatement.setString(2, person.getSurname());
     preparedStatement.executeUpdate();
 // todo:
     return person;
    }

}
