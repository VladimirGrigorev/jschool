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

    @ManyToMany()
    @JoinTable(
            name = "spare_part_store_branch",
            joinColumns = @JoinColumn(name = "spare_part_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "store_branch_id", referencedColumnName = "id")
    )
    private List<SparePart> spareParts;
}
