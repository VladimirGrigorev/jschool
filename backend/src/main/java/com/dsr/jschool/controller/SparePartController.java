package com.dsr.jschool.controller;

import com.dsr.jschool.data.dto.sparepart.CreateOrUpdateSparePartDto;
import com.dsr.jschool.data.dto.sparepart.SparePartDto;
import com.dsr.jschool.data.dto.sparepart.SparePartWithStoreBranchDto;
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
    public List<SparePartWithStoreBranchDto> getSpareParts() {
        return sparePartMapper.sparePartToSparePartWithListStoreBranchDto(sparePartService.getAllSpareParts());
    }

    @GetMapping(path = "/{id}")
    public SparePartWithStoreBranchDto getSparePart(@PathVariable Long id) {
        return sparePartMapper.sparePartToSparePartWithListStoreBranchDto(sparePartService.getSparePart(id));
    }

    @PostMapping(path = "/{storeBranchId}")
    public SparePartDto createSparePart(@PathVariable Long storeBranchId,
                                        @RequestBody CreateOrUpdateSparePartDto dto) {
        var createdSparePart = sparePartService.createOrUpdateSparePart(
                mapper.createOrUpdateSparePartDtoToSparePart(dto), storeBranchId);
        return mapper.sparePartToSparePartDto(createdSparePart);
    }

    @PutMapping(path = "/{id}/{storeBranchId}")
    public SparePartDto updateSparePart(
            @PathVariable Long id,
            @PathVariable Long storeBranchId,
            @RequestBody CreateOrUpdateSparePartDto dto
    ) {
        return mapper.sparePartToSparePartDto(sparePartService.updateSparePart(id, dto, storeBranchId));
    }

    @DeleteMapping(path = "/{id}")
    public void deleteSparePart(@PathVariable Long id) {
        sparePartService.deleteSparePartById(id);
    }
}
