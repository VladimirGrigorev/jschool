package com.dsr.jschool.data.mapper;

import com.dsr.jschool.data.dto.StoreBranchDto;
import com.dsr.jschool.data.entity.StoreBranch;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StoreBranchMapper {
    public StoreBranchDto toStoreBranchDto(StoreBranch storeBranch) {
        return new StoreBranchDto(
                storeBranch.getId(),
                storeBranch.getAddress()
        );
    }

    public List<StoreBranchDto> toStoreBranchDto(List<StoreBranch> storeBranches) {
        return storeBranches.stream()
                .map(this::toStoreBranchDto)
                .collect(Collectors.toList());
    }
}
