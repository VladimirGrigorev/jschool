package com.dsr.jschool.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SparePartDto {

    private Long id;
    private String name;
    private Integer count;
}
