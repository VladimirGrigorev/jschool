package com.dsr.jschool.data.mapper;

import com.dsr.jschool.data.dto.SparePartDto;
import com.dsr.jschool.data.entity.SparePart;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SparePartMapper{

    SparePartDto sparePartToSparePartDto(SparePart sparePart);
    List<SparePartDto> sparePartToSparePartDto(List<SparePart> sparePart);
}