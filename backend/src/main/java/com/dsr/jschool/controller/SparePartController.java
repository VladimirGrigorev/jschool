package com.dsr.jschool.controller;

import com.dsr.jschool.data.dto.sparepart.CreateOrUpdateSparePartDto;
import com.dsr.jschool.data.dto.sparepart.SparePartDto;
import com.dsr.jschool.data.mapper.SparePartMapper;
import com.dsr.jschool.service.SparePartService;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/spare-parts")
public class SparePartController {

    private final SparePartService sparePartService;
    private final SparePartMapper sparePartMapper;

    private final SparePartMapper mapper = Mappers.getMapper(SparePartMapper.class);

    public SparePartController(SparePartService sparePartService,
                               SparePartMapper sparePartMapper) {
        this.sparePartService = sparePartService;
        this.sparePartMapper = sparePartMapper;
    }

    @GetMapping(path = "")
    public List<SparePartDto> getSpareParts() {
        return sparePartMapper.sparePartToSparePartDto(sparePartService.getAllSpareParts());
    }

    @GetMapping(path = "/{id}")
    public SparePartDto getSparePart(Long id) {
        return sparePartMapper.sparePartToSparePartDto(sparePartService.getSparePart(id));
    }

    @PostMapping(path = "")
    public SparePartDto createSparePart(@RequestBody CreateOrUpdateSparePartDto dto) {
        var createdSparePart = sparePartService.createOrUpdateSparePart(
                mapper.createOrUpdateSparePartDtoToSparePart(dto));
        return mapper.sparePartToSparePartDto(createdSparePart);
    }

    @PutMapping(path = "/{id}")
    public SparePartDto updateSparePart(
            @PathVariable Long id,
            @RequestBody CreateOrUpdateSparePartDto dto
    ) {
        return mapper.sparePartToSparePartDto(sparePartService.updateSparePart(id, dto));
    }

    @DeleteMapping(path = "/{id}")
    public void deleteSparePart(@PathVariable Long id) {
        sparePartService.deleteSparePartById(id);
    }
}
