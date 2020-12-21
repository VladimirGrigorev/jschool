package com.dsr.jschool.data.dto.sparepart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SparePartDto {

    private Long id;
    private String name;
    private String description;
    private Integer count;
    private Integer cost;
}
