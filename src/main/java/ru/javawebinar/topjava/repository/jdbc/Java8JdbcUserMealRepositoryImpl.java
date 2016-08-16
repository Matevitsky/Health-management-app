package ru.javawebinar.topjava.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import ru.javawebinar.topjava.model.UserMeal;

import javax.sql.DataSource;
import java.time.LocalDateTime;

/**
 * Created by Sergey on 14.07.16.
 */
public class Java8JdbcUserMealRepositoryImpl extends AbstractJdbcUserMealRepositoryImpl<LocalDateTime> {

    @Autowired
    public Java8JdbcUserMealRepositoryImpl(DataSource dataSource) {
        super(BeanPropertyRowMapper.newInstance(UserMeal.class), dataSource);
    }

    @Override
    protected LocalDateTime toDbValue(LocalDateTime ldt) {
        return ldt;
    }
}
