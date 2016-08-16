package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;
import ru.javawebinar.topjava.to.UserMealTo;
import ru.javawebinar.topjava.util.UserMealsUtil;
import ru.javawebinar.topjava.util.exception.ExceptionUtil;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Created by Sergey on 30.06.16.
 */

@Service
public class UserMealServiceImpl implements UserMealService {

    @Autowired
    private UserMealRepository repository;

    @Override
    public UserMeal get(int id, int userId) {
        return ExceptionUtil.checkNotFoundWithId(repository.get(id, userId), id);
    }

    @Override
    public void delete(int id, int userId) {
        ExceptionUtil.checkNotFoundWithId(repository.delete(id, userId), id);
    }

    @Override
    public Collection<UserMeal> getBetweenDateTimes(LocalDateTime startDateTime, LocalDateTime endDateTime, int userId) {
        return repository.getBetween(startDateTime, endDateTime, userId);
    }

    @Override
    public Collection<UserMeal> getAll(int userId) {
        return repository.getAll(userId);
    }

    @Override
    public UserMeal update(UserMeal meal, int userId) {
        return ExceptionUtil.checkNotFoundWithId(repository.save(meal, userId), meal.getId());
    }

    @Override
    public UserMeal update(UserMealTo userMealTo, int userId) {
        UserMeal userMeal = new UserMeal();
        userMeal = UserMealsUtil.updateFromTo(userMeal, userMealTo);

        return repository.save(userMeal,userId);

    }

    @Override
    public UserMeal save(UserMeal meal, int userId) {
        return repository.save(meal, userId);
    }

    @Override
    public UserMeal getWithUser(Integer id, Integer userId) {
        return ExceptionUtil.checkNotFoundWithId(repository.getWithUser(id, userId), id);
    }
}