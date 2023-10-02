package com.springboot.learnjpahibernate.book.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.learnjpahibernate.book.Books;

@Repository
public class BookJdbcRepository {
    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static final String INSERT_QUERY = "insert into books(id, name, author) values(?, ?, ?)";

    private static final String DELETE_QUERY = "DELETE FROM books WHERE id = ?";

    private static final String SELECT_QUERY = "SELECT * FROM books where id = ?";

    public void insert(Books book) {
        springJdbcTemplate.update(INSERT_QUERY, book.getId(), book.getName(), book.getAuthor());
    }

    public void delete(long id) {
        springJdbcTemplate.update(DELETE_QUERY, id);
    }

    public Books findById(long id) {
         // ResultSet ---map---> Bean (Row Mappers)
        return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Books.class), id);
    }

}