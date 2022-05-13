package com.Golub.school.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "students")
public class Students {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int idstudents;

    @Length(max=45)
    @NotBlank(message = "Фамилия не может быть пустой!")
    private String surname;

    @Length(max=45)
    @NotBlank(message = "Имя не может быть пустым!")
    private String name;

    @Length(max = 13, min = 10, message = "Некорректный номер!")
    private String number;

    @Length(max=65)
    @Email(message = "Почта не корректна")
    @NotBlank(message = "Почта не может быть пустая!")
    private String email;

    @ManyToMany
    @JoinTable(name = "place",
            joinColumns = @JoinColumn(name = "idstudents"),
            inverseJoinColumns = @JoinColumn(name = "idcourse")
    )
    private Set<Course> course;

    @OneToMany(mappedBy = "students", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Card> cardList;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "iduser")
    private User users;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        Students students = (Students) o;
        return  Objects.equals(idstudents, students.idstudents) &&
                Objects.equals(email, students.email) &&
                Objects.equals(surname, students.surname) &&
                Objects.equals(name, students.name) &&
                Objects.equals(number, students.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idstudents, name, surname, email, number);
    }
}
