package com.dsr.jschool.data.mapper;

import com.dsr.jschool.data.dto.storebranch.CreateOrUpdateStoreBranchDto;
import com.dsr.jschool.data.dto.storebranch.StoreBranchDto;
import com.dsr.jschool.data.entity.StoreBranch;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StoreBranchMapper{

    StoreBranchDto storeBranchToStoreBranchDto(StoreBranch storeBranch);
    List<StoreBranchDto> storeBranchToStoreBranchDto(List<StoreBranch> storeBranches);

    StoreBranch createOrUpdateStoreBranchDtoToStoreBranch(CreateOrUpdateStoreBranchDto createOrUpdateStoreBranchDto);
    List<StoreBranch> createOrUpdateStoreBranchDtoToStoreBranch(
            List<CreateOrUpdateStoreBranchDto> createOrUpdateStoreBranchDto);
}