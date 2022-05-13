package com.Golub.school.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "mentor")
public class Mentor {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int idmentor;

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
    @JoinTable(name = "place_m",
            joinColumns = @JoinColumn(name = "idmentor"),
            inverseJoinColumns = @JoinColumn(name = "idcourse")
    )
    private Set<Course> course;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "iduser")
    private User users;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        Mentor mentor = (Mentor) o;
        return  Objects.equals(idmentor, mentor.idmentor) &&
                Objects.equals(email, mentor.email) &&
                Objects.equals(surname, mentor.surname) &&
                Objects.equals(name, mentor.name) &&
                Objects.equals(number, mentor.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idmentor, name, surname, email, number);
    }
}
