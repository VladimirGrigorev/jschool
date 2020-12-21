package com.dsr.jschool.data.dto.storebranch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreBranchDto {

    private Long id;
    private String address;
    private String description;
}
