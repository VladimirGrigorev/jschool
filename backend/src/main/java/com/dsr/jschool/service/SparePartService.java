package com.dsr.jschool.service;

import com.dsr.jschool.data.dto.sparepart.CreateOrUpdateSparePartDto;
import com.dsr.jschool.data.entity.SparePart;
import com.dsr.jschool.data.entity.StoreBranch;
import com.dsr.jschool.data.repository.SparePartRepository;
import com.dsr.jschool.exeption.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        // CR:DB: Не бойтесь использовать Stream API. С ним код становится красивее
//        var result = sparePartRepository.findAllByStoreBranchId(storeBranchId).stream()
//                .filter(part -> part.getCount() > 0)
//                .collect(Collectors.toList());
        sparePartRepository.findAllByStoreBranchId(storeBranchId).forEach(sparePart -> {
            if(sparePart.getCount() > 0)
                result.add(sparePart);
        });
        return result;
    }

    public SparePart createOrUpdateSparePart(SparePart sparePart, Long storeBranchId) {
        // CR:DB: Дважды образаетесь к базе с одним и темже запросом.
        // Проблема 1: Зачем два раза спраштвать у БД одно и тоже?
        // Можно использовать Optional (лучший вариант, на мой взгляд) или выполнить сначала запрос exists
//        StoreBranch storeBranch = Optional.of(storeBranchService.findById(storeBranchId))
//                .orElseThrow(NotFoundException::new);
        // Проблема 2: Запросы не в одной транзакции. Между первым - вторым и вторым - третьим запросами запись могли удалить
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
        sparePart.setCost(dto.getCost());

        if(!storeBranchId.equals(sparePart.getStoreBranch().getId())) {
            return createOrUpdateSparePart(sparePart, sparePart.getStoreBranch().getId());
        }

        return createOrUpdateSparePart(sparePart, storeBranchId);
    }
}
