package com.dsr.jschool.service;

import com.dsr.jschool.data.dto.storebranch.CreateOrUpdateStoreBranchDto;
import com.dsr.jschool.data.entity.StoreBranch;
import com.dsr.jschool.data.repository.StoreBranchRepository;
import com.dsr.jschool.exeption.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreBranchService {

    private final StoreBranchRepository storeBranchRepository;

    public StoreBranchService(StoreBranchRepository storeBranchRepository) {
        this.storeBranchRepository = storeBranchRepository;
    }

    public List<StoreBranch> getAllStoreBranches() {
        var result = new ArrayList<StoreBranch>();
        storeBranchRepository.findAll().forEach(result::add);
        return result;
    }

    public StoreBranch getStoreBranch(Long id) {
        return storeBranchRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public StoreBranch createOrUpdateStoreBranch(StoreBranch storeBranch) {
        return storeBranchRepository.save(storeBranch);
    }

    public StoreBranch findById(Long id) {
        return storeBranchRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteStoreBranchById(Long id) {
        var storeBranch = findById(id);
        storeBranchRepository.delete(storeBranch);
    }

    public StoreBranch updateStoreBranch(Long id, CreateOrUpdateStoreBranchDto dto){
        var storeBranch = findById(id);

        storeBranch.setAddress(dto.getAddress());
        storeBranch.setDescription(dto.getDescription());

        return createOrUpdateStoreBranch(storeBranch);
    }
}
