package com.dsr.jschool.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "spare_part", schema = "public")
public class SparePart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Integer count;
    private Integer cost;

    @ManyToOne()
    @JoinColumn(name = "storeBranchId")
    private StoreBranch storeBranch;

    @OneToMany(mappedBy = "sparePart")
    private List<Order> orders;
}
