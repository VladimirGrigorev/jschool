package com.dsr.jschool.data.repository;

import com.dsr.jschool.data.entity.SparePart;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface SparePartRepository extends PagingAndSortingRepository<SparePart, Long> {

    List<SparePart> findAllByStoreBranchId(Long id);
}
