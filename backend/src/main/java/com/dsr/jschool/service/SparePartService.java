package com.dsr.jschool.service;

import com.dsr.jschool.data.dto.sparepart.CreateOrUpdateSparePartDto;
import com.dsr.jschool.data.entity.SparePart;
import com.dsr.jschool.data.entity.StoreBranch;
import com.dsr.jschool.data.repository.SparePartRepository;
import com.dsr.jschool.exeption.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SparePartService {

    private final SparePartRepository sparePartRepository;
    private final StoreBranchService storeBranchService;

    public SparePartService(SparePartRepository sparePartRepository, StoreBranchService storeBranchService) {
        this.sparePartRepository = sparePartRepository;
        this.storeBranchService = storeBranchService;
    }

    public List<SparePart> getAllSpareParts() {
        var result = new ArrayList<SparePart>();
        sparePartRepository.findAll().forEach(result::add);
        return result;
    }

    public List<SparePart> getAllSparePartsWithPositiveCount(Long storeBranchId) {
        var result = new ArrayList<SparePart>();
        sparePartRepository.findAllByStoreBranchId(storeBranchId).forEach(sparePart -> {
            if(sparePart.getCount() > 0)
                result.add(sparePart);
        });
        return result;
    }

    public SparePart getSparePart(Long id) {
        return sparePartRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public SparePart createOrUpdateSparePart(SparePart sparePart, Long storeBranchId) {
        if(storeBranchService.findById(storeBranchId) == null)
            throw new NotFoundException();
        StoreBranch storeBranch = storeBranchService.findById(storeBranchId);
        sparePart.setStoreBranch(storeBranch);
        return sparePartRepository.save(sparePart);
    }

    public SparePart findById(Long id) {
        return sparePartRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteSparePartById(Long id) {
        var sparePart = findById(id);
        sparePartRepository.delete(sparePart);
    }

    public SparePart updateSparePart(Long id, CreateOrUpdateSparePartDto dto, Long storeBranchId){
        var sparePart = findById(id);

        sparePart.setName(dto.getName());
        sparePart.setDescription(dto.getDescription());
        sparePart.setCount(dto.getCount());
        sparePart.setCount(dto.getCost());

        if(!storeBranchId.equals(sparePart.getStoreBranch().getId())) {
            return createOrUpdateSparePart(sparePart, sparePart.getStoreBranch().getId());
        }

        return createOrUpdateSparePart(sparePart, storeBranchId);
    }
}
