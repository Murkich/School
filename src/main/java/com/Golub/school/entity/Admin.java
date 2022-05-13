package com.Golub.school.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int idadmin;

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

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "iduser")
    private User users;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        Admin admin = (Admin) o;
        return  Objects.equals(idadmin, admin.idadmin) &&
                Objects.equals(email, admin.email) &&
                Objects.equals(surname, admin.surname) &&
                Objects.equals(name, admin.name) &&
                Objects.equals(number, admin.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idadmin, name, surname, email, number);
    }
}
