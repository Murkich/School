package com.Golub.school.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@Table (name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int iduser;

    @Length(max=200)
    @Length(min = 3, message = "Логин должен содержать более 3 символов!")
    @Column(name="login")
    private String username;

    @Length(min=6, max=200, message="Пароль должен содержать более 5 символов!")
    private String password;

    private String status;

    private boolean active;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)//Подгружаем данные со свзянной таблицы, Eager полная подгрузка, лайзи - по обращению
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "iduser"))//Указываем через что будет происходить подгрузка
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public User(){}

    public boolean isAdmin(){
        return status.contains("admin");
    }

    public boolean isMentor(){
        return status.contains("mentor");
    }

    public boolean isUser(){
        return status.contains("user");
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { return getRoles(); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return  Objects.equals(iduser, user.iduser) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(status, user.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iduser, username, password, status);
    }
}