package com.codeup.springpractice.models;

import com.codeup.springpractice.repositories.ParksRepository;

import javax.persistence.*;

@Entity
@Table(name="national_parks")
public class NationalPark {
    //Instance Variables

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;



    //Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    //Constructors

    public NationalPark(){

    }

    public NationalPark(String name){
        this.name = name;
    }




}//End of National Park class
