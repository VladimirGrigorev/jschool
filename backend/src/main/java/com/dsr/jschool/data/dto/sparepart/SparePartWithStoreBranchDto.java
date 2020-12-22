package com.dsr.jschool.data.dto.sparepart;

import com.dsr.jschool.data.dto.storebranch.StoreBranchDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SparePartWithStoreBranchDto {

    private Long id;
    private String name;
    private String description;
    private Integer count;
    private Integer cost;
    private StoreBranchDto storeBranch;
}
