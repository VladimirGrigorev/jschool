package com.dsr.jschool.service;

import com.dsr.jschool.data.dto.sparepart.CreateOrUpdateSparePartDto;
import com.dsr.jschool.data.entity.SparePart;
import com.dsr.jschool.data.repository.SparePartRepository;
import com.dsr.jschool.exeption.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SparePartService {

    private final SparePartRepository sparePartRepository;

    public SparePartService(SparePartRepository sparePartRepository) {
        this.sparePartRepository = sparePartRepository;
    }

    public List<SparePart> getAllSpareParts() {
        var result = new ArrayList<SparePart>();
        sparePartRepository.findAll().forEach(result::add);
        return result;
    }

    public SparePart getSparePart(Long id) {
        return sparePartRepository.findById(id).orElseThrow();
    }

    public SparePart createOrUpdateSparePart(SparePart sparePart) {
        return sparePartRepository.save(sparePart);
    }

    public SparePart findById(Long id) {
        return sparePartRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteSparePartById(Long id) {
        var sparePart = findById(id);
        sparePartRepository.delete(sparePart);
    }

    public SparePart updateSparePart(Long id, CreateOrUpdateSparePartDto dto){
        var sparePart = findById(id);

        sparePart.setName(dto.getName());
        sparePart.setDescription(dto.getDescription());
        sparePart.setCount(dto.getCount());
        sparePart.setCount(dto.getCost());

        return createOrUpdateSparePart(sparePart);
    }
}
