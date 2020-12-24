package com.dsr.jschool.service;

import com.dsr.jschool.data.dto.FindOptimalStoreBranchDto;
import com.dsr.jschool.data.dto.storebranch.CreateOrUpdateStoreBranchDto;
import com.dsr.jschool.data.entity.StoreBranch;
import com.dsr.jschool.data.repository.SparePartRepository;
import com.dsr.jschool.data.repository.StoreBranchRepository;
import com.dsr.jschool.exeption.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreBranchService {

    private final StoreBranchRepository storeBranchRepository;
    private final SparePartRepository sparePartRepository;

    public StoreBranchService(StoreBranchRepository storeBranchRepository, SparePartRepository sparePartRepository) {
        this.storeBranchRepository = storeBranchRepository;
        this.sparePartRepository = sparePartRepository;
    }

    public List<StoreBranch> getAllStoreBranches() {
        var result = new ArrayList<StoreBranch>();
        storeBranchRepository.findAll().forEach(result::add);
        return result;
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

    public StoreBranch findOptimalStoreBranch(FindOptimalStoreBranchDto dto) {
        double minDistance = 999999;
        long index = -1;
        for(StoreBranch storeBranch : storeBranchRepository.findAll()) {
            if (storeBranch.getSpareParts().stream().anyMatch(
                    sparePart -> sparePart.getName().equals(dto.getName()))) {

                var distance = Math.sqrt(((dto.getX() - storeBranch.getX()) * (dto.getX() - storeBranch.getX()))
                        + ((dto.getY() - storeBranch.getY()) * (dto.getY() - storeBranch.getY())));
                if (distance < minDistance) {
                    index = storeBranch.getId();
                    minDistance = distance;
                }
            }
        }
        if(index == -1 || minDistance == 999999)
            throw new NotFoundException();
        return storeBranchRepository.findById(index).orElseThrow(NotFoundException::new);
    }
}
