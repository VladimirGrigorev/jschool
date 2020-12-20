package com.dsr.jschool.data.mapper;

import com.dsr.jschool.data.dto.SparePartDto;
import com.dsr.jschool.data.entity.SparePart;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SparePartMapper {
    public SparePartDto toSparePartDto(SparePart sparePart) {
        return new SparePartDto(
                sparePart.getId(),
                sparePart.getName(),
                sparePart.getCount()
        );
    }

    public List<SparePartDto> toSparePartDto(List<SparePart> spareParts) {
        return spareParts.stream()
                .map(this::toSparePartDto)
                .collect(Collectors.toList());
    }
}
