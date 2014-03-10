package org.jbehave.model;

import javax.persistence.*;

//@Entity
//@Table(name="player")
public class Player {

//    @Id
//    @GeneratedValue
//    @Column(name="player_id")
//    private Long id;

//    @Column
    private String name;

//    @Column
    private String team;

//    @Column
    private int number;

//    @Column
    private int age;

    public Player(){

    }

    public Player(String name, String team, int number, int age) {
        this.name = name;
        this.team = team;
        this.number = number;
        this.age = age;
    }

    public Player setName(String name) {
        this.name = name;
        return this;
    }
}