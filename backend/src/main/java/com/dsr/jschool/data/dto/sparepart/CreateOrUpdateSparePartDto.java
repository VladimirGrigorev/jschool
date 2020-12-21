package com.dsr.jschool.data.dto.sparepart;

import lombok.Data;

@Data
public class CreateOrUpdateSparePartDto {

    private String name;
    private String description;
    private Integer count;
    private Integer cost;
}
