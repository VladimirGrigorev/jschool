package com.dsr.jschool.data.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user", schema = "public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
