package com.keiba_app.app.domain.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@Table(name = "t_race_with_race_name")
public class RaceHistory {

    @Id
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String raceCourse;

    @Column(nullable = false)
    private String placeCondition;

    @Column(nullable = false)
    private String raceName;

    @Column(nullable = false)
    private Long courseLength;

    @Column(nullable = false)
    private String round;

    @Column(nullable = false)
    private String year;

    @Column(nullable = false)
    private String horseName;

    @Column(nullable = false)
    private String sex;

    @Column(nullable = false)
    private Long old;

    @Column(nullable = false)
    private String jockeyName;

}
