package com.Golub.school.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idcourse;

    @Length(max=90)
    @NotBlank(message = "Наименование не может быть пустым!")
    private String name;

    @Length(max=20)
    @NotBlank(message = "Язык не может быть пустой!")
    private String language;

    @NotBlank(message = "Стоимость не может быть пустой!")
    private double cost;

    @NotBlank(message = "Кол-во мест не может быть пустой!")
    private int numberofseats;

    private int numberoffreeseats;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_begin", nullable = false)
    private Date dateOfBegin;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_end", nullable = false)
    private Date dateOfEnd;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "course")
    private Set<Students> students;

    public Course(String name, String language, double cost, int genCount, int freeCount, Date dateOfBegin, Date dateOfEnd) {
        this.name = name;
        this.language = language;
        this.cost = cost;
        this.numberofseats = genCount;
        this.numberoffreeseats = freeCount;
        this.dateOfBegin = dateOfBegin;
        this.dateOfEnd = dateOfEnd;
    }
}