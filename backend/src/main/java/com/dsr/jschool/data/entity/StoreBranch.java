package com.dsr.jschool.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "store_branch", schema = "public")
public class StoreBranch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String description;

    @OneToMany(mappedBy = "storeBranch")
    private List<SparePart> spareParts;
}
