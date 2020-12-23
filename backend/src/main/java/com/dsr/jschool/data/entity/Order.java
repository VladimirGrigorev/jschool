package com.dsr.jschool.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "order", schema = "public")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;

    @ManyToOne()
    @JoinColumn(name = "customerId")
    private User customer;

    @ManyToOne()
    @JoinColumn(name = "sparePartId")
    private SparePart sparePart;
}
