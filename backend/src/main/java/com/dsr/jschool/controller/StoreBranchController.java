package com.dsr.jschool.controller;

import com.dsr.jschool.data.dto.storebranch.CreateOrUpdateStoreBranchDto;
import com.dsr.jschool.data.dto.storebranch.StoreBranchDto;
import com.dsr.jschool.data.dto.storebranch.StoreBranchWithListSparePartDto;
import com.dsr.jschool.data.mapper.StoreBranchMapper;
import com.dsr.jschool.service.StoreBranchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/store-branches")
public class StoreBranchController {

    private final StoreBranchService storeBranchService;
    private final StoreBranchMapper storeBranchMapper;

    public StoreBranchController(StoreBranchService storeBranchService,
                                 StoreBranchMapper storeBranchMapper) {
        this.storeBranchService = storeBranchService;
        this.storeBranchMapper = storeBranchMapper;
    }

    @GetMapping(path = "")
    public List<StoreBranchDto> getStoreBranches() {
        return storeBranchMapper.storeBranchToStoreBranchDto(storeBranchService.getAllStoreBranches());
    }

    @GetMapping(path = "/{id}")
    public StoreBranchWithListSparePartDto getStoreBranch(@PathVariable Long id) {
        return storeBranchMapper.storeBranchToStoreBranchWithListSparePartDto(storeBranchService.getStoreBranch(id));
    }

    @PostMapping(path = "")
    public StoreBranchDto createStoreBranch(@RequestBody CreateOrUpdateStoreBranchDto dto) {
        var createdStoreBranch = storeBranchService.createOrUpdateStoreBranch(
                storeBranchMapper.createOrUpdateStoreBranchDtoToStoreBranch(dto));
        return storeBranchMapper.storeBranchToStoreBranchDto(createdStoreBranch);
    }

    @PutMapping(path = "/{id}")
    public StoreBranchDto updateStoreBranch(
            @PathVariable Long id,
            @RequestBody CreateOrUpdateStoreBranchDto dto
    ) {
        return storeBranchMapper.storeBranchToStoreBranchDto(storeBranchService.updateStoreBranch(id, dto));
    }

    @DeleteMapping(path = "/{id}")
    public void deleteStoreBranch(@PathVariable Long id) {
        storeBranchService.deleteStoreBranchById(id);
    }
}
