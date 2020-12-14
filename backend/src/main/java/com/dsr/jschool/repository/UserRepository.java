package com.dsr.jschool.repository;

import com.dsr.jschool.data.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
}
