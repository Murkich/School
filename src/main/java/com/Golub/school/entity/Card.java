package com.Golub.school.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int idcard;

    @Length(max=16)
    @NotBlank(message = "Номер карты не может быть пустым!")
    private String card1;

    @Length(max=16)
    private String card2;

    @Length(max=16)
    private String card3;

    @Length(max=16)
    private String card4;

    private double cost;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idstudents")
    private Students students;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        Card card = (Card) o;
        return  Objects.equals(idcard, card.idcard) &&
                Objects.equals(card1, card.card1) &&
                Objects.equals(card2, card.card2) &&
                Objects.equals(card3, card.card3) &&
                Objects.equals(card4, card.card4) &&
                Objects.equals(cost, card.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcard, card1, card2, card3, card4, cost);
    }
}
