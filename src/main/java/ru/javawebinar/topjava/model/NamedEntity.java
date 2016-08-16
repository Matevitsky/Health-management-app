package ru.javawebinar.topjava.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by Sergey on 30.06.16.
 */

@MappedSuperclass
public class NamedEntity extends BaseEntity {


    @NotEmpty
    @Column(name = "name",nullable = false)
    protected String name;

    public NamedEntity() {

    }

    protected NamedEntity(Integer id, String name){
        super(id);
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
