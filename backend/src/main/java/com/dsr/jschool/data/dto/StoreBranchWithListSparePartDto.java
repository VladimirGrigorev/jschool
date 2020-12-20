package com.dsr.jschool.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreBranchWithListSparePartDto {

    private Long id;
    private String address;
    private List<SparePartDto> sparePartDtos;
}
