package com.dsr.jschool.data.mapper;

import com.dsr.jschool.data.dto.sparepart.CreateOrUpdateSparePartDto;
import com.dsr.jschool.data.dto.sparepart.SparePartDto;
import com.dsr.jschool.data.dto.sparepart.SparePartWithStoreBranchDto;
import com.dsr.jschool.data.entity.SparePart;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SparePartMapper{

    SparePartDto sparePartToSparePartDto(SparePart sparePart);
    List<SparePartDto> sparePartToSparePartDto(List<SparePart> sparePart);

    SparePart createOrUpdateSparePartDtoToSparePart(CreateOrUpdateSparePartDto createOrUpdateSparePartDto);
    List<SparePart> createOrUpdateSparePartDtoToSparePart(
            List<CreateOrUpdateSparePartDto> createOrUpdateSparePartDto);

    SparePartWithStoreBranchDto sparePartToSparePartWithStoreBranchDto(SparePart sparePart);
    List<SparePartWithStoreBranchDto> sparePartToSparePartWithStoreBranchDto(List<SparePart> sparePart);
}