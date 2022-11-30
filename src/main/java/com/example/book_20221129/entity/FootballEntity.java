package com.example.book_20221129.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "football_player_table")
public class FootballEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String playerName;

    @Column(length = 50, nullable = false)
    private String playerTeam;

    @Column(length = 20)
    private String playerPosition;

    @Column
    private int playerAge;

    @Column
    private int playerSalary;

}
