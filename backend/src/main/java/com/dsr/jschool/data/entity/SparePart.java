package com.dsr.jschool.data.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "spare_part", schema = "public")
public class SparePart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
