package com.dsr.jschool.service;

import com.dsr.jschool.data.entity.StoreBranch;
import com.dsr.jschool.data.repository.StoreBranchRepository;
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
        return storeBranchRepository.findById(id).orElseThrow();
    }

    public StoreBranch createOrUpdateStoreBranch(StoreBranch storeBranch) {
        return storeBranchRepository.save(storeBranch);
    }
}
