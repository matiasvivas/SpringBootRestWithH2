package com.superheroes.springboot.SpringBootRestWithH2.model;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SUPERHEROE")
public class Superheroe {

    @Column(name = "id")
    @Id
    Integer id;

    @Column(name = "name")
    String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
