package com.dsr.jschool.service;

import com.dsr.jschool.data.entity.SparePart;
import com.dsr.jschool.data.repository.SparePartRepository;
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
}
