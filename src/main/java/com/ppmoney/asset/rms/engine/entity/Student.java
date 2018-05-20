package com.ppmoney.asset.rms.engine.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by paul on 2018/5/20.
 */
@Setter
@Getter
@Entity
public class Student {
    @Id
    private Long id;
    private String name;
    private String sex;
    private int age;
}
