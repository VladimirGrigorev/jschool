package com.dsr.jschool.controller;

import com.dsr.jschool.data.dto.SparePartDto;
import com.dsr.jschool.data.mapper.SparePartMapper;
import com.dsr.jschool.service.SparePartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/spare-parts")
public class SparePartController {

    private final SparePartService sparePartService;
    private final SparePartMapper sparePartMapper;

    public SparePartController(SparePartService sparePartService,
                               SparePartMapper sparePartMapper) {
        this.sparePartService = sparePartService;
        this.sparePartMapper = sparePartMapper;
    }

    @GetMapping(path = "")
    public List<SparePartDto> getSpareParts() {
        return sparePartMapper.toSparePartDto(sparePartService.getAllSpareParts());
    }

    @GetMapping(path = "/:id")
    public SparePartDto getSparePart(Long id) {
        return sparePartMapper.toSparePartDto(sparePartService.getSparePart(id));
    }
}
