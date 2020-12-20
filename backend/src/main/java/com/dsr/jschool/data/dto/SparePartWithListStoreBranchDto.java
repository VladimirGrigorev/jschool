package com.dsr.jschool.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SparePartWithListStoreBranchDto {

    private Long id;
    private String name;
    private Integer count;
    private List<StoreBranchDto> storeBranchDtos;
}
