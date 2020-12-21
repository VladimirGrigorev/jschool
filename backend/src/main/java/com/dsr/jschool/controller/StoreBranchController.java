package com.dsr.jschool.controller;

import com.dsr.jschool.data.dto.StoreBranchDto;
import com.dsr.jschool.data.mapper.StoreBranchMapper;
import com.dsr.jschool.service.StoreBranchService;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/store-branches")
public class StoreBranchController {

    private final StoreBranchService storeBranchService;
    private final StoreBranchMapper storeBranchMapper;

    private final StoreBranchMapper mapper = Mappers.getMapper(StoreBranchMapper.class);

    public StoreBranchController(StoreBranchService storeBranchService,
                                 StoreBranchMapper storeBranchMapper) {
        this.storeBranchService = storeBranchService;
        this.storeBranchMapper = storeBranchMapper;
    }

    @GetMapping(path = "")
    public List<StoreBranchDto> getStoreBranches() {
        return storeBranchMapper.storeBranchToStoreBranchDto(storeBranchService.getAllStoreBranches());
    }

    @GetMapping(path = "/:id")
    public StoreBranchDto getStoreBranch(Long id) {
        return storeBranchMapper.storeBranchToStoreBranchDto(storeBranchService.getStoreBranch(id));
    }
}
