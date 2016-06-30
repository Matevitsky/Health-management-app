package ru.javawebinar.topjava.to;

import java.time.LocalDateTime;

/**
 *
 */
public class UserMealWithExceed {

    private final Integer id;

    private final LocalDateTime dateTime;

    private final String description;


    private final int calories;

    private final boolean exceed;

    public UserMealWithExceed(Integer id, LocalDateTime dateTime, String description, int calories, boolean exceed) {
        this.id = id;
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
        this.exceed = exceed;
    }

    public UserMealWithExceed(LocalDateTime dateTime, String description, int calories, boolean exceed) {
        this(null, dateTime, description, calories, exceed);
    }

    public Integer getId() {
        return id;
    }

    public int getCalories() {
        return calories;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public boolean isExceed() {
        return exceed;
    }


    @Override
    public String toString() {
        return "UserMealWithExceed{" +

                "id=" + id +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                ", exceed=" + exceed +
                '}';
    }
}