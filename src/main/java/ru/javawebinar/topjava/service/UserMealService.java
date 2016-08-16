package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.to.UserMealTo;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;

/**
 * Created by Sergey on 30.06.16.
 */

public interface UserMealService {

    UserMeal get(int id, int userId) throws NotFoundException;

    void delete(int id, int userId);

    UserMeal save(UserMeal userMeal, int userId);

    UserMeal getWithUser(Integer id, Integer userId);

    UserMeal update(UserMeal userMeal, int userId);

    UserMeal update(UserMealTo userMealTo, int userId);

    Collection<UserMeal> getAll(int userId);

    Collection<UserMeal> getBetweenDateTimes(LocalDateTime startDateTime, LocalDateTime endDateTime, int userId);

    default Collection<UserMeal> getBetweenDates(LocalDate startDate, LocalDate endDate, int userId) {
        return getBetweenDateTimes(LocalDateTime.of(startDate, LocalTime.MIN), LocalDateTime.of(endDate, LocalTime.MAX), userId);
    }
}
