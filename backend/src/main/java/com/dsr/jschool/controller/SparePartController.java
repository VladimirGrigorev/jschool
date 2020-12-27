package com.dsr.jschool.controller;

import com.dsr.jschool.data.dto.sparepart.CreateOrUpdateSparePartDto;
import com.dsr.jschool.data.dto.sparepart.SparePartDto;
import com.dsr.jschool.data.dto.sparepart.SparePartWithStoreBranchDto;
import com.dsr.jschool.data.mapper.SparePartMapper;
import com.dsr.jschool.service.SparePartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/spare-parts")
public class SparePartController {

    private final SparePartService sparePartService;
    private final SparePartMapper sparePartMapper;

    public SparePartController(SparePartService sparePartService, SparePartMapper sparePartMapper) {
        this.sparePartService = sparePartService;
        this.sparePartMapper = sparePartMapper;
    }

    @GetMapping(path = "/positive/{storeBranchId}")
    public List<SparePartWithStoreBranchDto> getSparePartsWithPositiveCount(@PathVariable Long storeBranchId) {
        return sparePartMapper.sparePartToSparePartWithStoreBranchDto(
                sparePartService.getAllSparePartsWithPositiveCount(storeBranchId));
    }

    // CR:DB: Для get all в REST не принято выделять дополнительный эндпоинт.
    // Можно просто использовать GET /api/v1/spare-parts
    @GetMapping(path = "/all")
    public List<SparePartWithStoreBranchDto> getSpareParts() {
        return sparePartMapper.sparePartToSparePartWithStoreBranchDto(sparePartService.getAllSpareParts());
    }

    @GetMapping(path = "/{id}")
    public SparePartWithStoreBranchDto getSparePart(@PathVariable Long id) {
        return sparePartMapper.sparePartToSparePartWithStoreBranchDto(sparePartService.findById(id));
    }

    @PostMapping(path = "/{storeBranchId}")
    public SparePartDto createSparePart(@PathVariable Long storeBranchId,
                                        @RequestBody CreateOrUpdateSparePartDto dto) {
        var createdSparePart = sparePartService.createOrUpdateSparePart(
                sparePartMapper.createOrUpdateSparePartDtoToSparePart(dto), storeBranchId);
        return sparePartMapper.sparePartToSparePartDto(createdSparePart);
    }

    @PutMapping(path = "/{id}/{storeBranchId}")
    public SparePartDto updateSparePart(
            @PathVariable Long id,
            @PathVariable Long storeBranchId,
            @RequestBody CreateOrUpdateSparePartDto dto
    ) {
        return sparePartMapper.sparePartToSparePartDto(sparePartService.updateSparePart(id, dto, storeBranchId));
    }

    @DeleteMapping(path = "/{id}")
    public void deleteSparePart(@PathVariable Long id) {
        sparePartService.deleteSparePartById(id);
    }
}
