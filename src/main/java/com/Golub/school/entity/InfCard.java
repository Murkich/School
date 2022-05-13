package com.Golub.school.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class InfCard {

    private int idcard;

    @Length(max=16)
    private String number1;

    @Length(max=16)
    private String number2;

    @Length(max=16)
    private String number3;

    @Length(max=16)
    private String number4;

    @Length(max=45)
    private String name1;

    @Length(max=45)
    private String name2;

    @Length(max=45)
    private String name3;

    @Length(max=45)
    private String name4;

    private int year1;

    private int year2;

    private int year3;

    private int year4;

    private int month1;

    private int month2;

    private int month3;

    private int month4;

    private int code1;

    private int code2;

    private int code3;

    private int code4;
}
