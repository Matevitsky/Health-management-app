package ru.javawebinar.topjava.to;

import ru.javawebinar.topjava.model.BaseEntity;

import java.time.LocalDateTime;

/**
 * Created by Sergey on 03.08.16.
 */
public class UserMealTo extends BaseEntity {


    private LocalDateTime dateTime;


    private String description;


    protected int calories;


    public UserMealTo() {
    }

    public UserMealTo(LocalDateTime dateTime, String description, int calories, Integer id) {
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
        this.id = id;
    }

    public UserMealTo(Integer id, LocalDateTime dateTime, String description, int calories) {
        super(id);
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
    }


    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

   /* public Integer getId() {
        return super.getId();
    }*/


    public boolean isNew() {
        return this.getId() == null;
    }

    @Override
    public String toString() {
        return "UserMealTo{" +
                "dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                ", id=" + id +
                '}';
    }
}
