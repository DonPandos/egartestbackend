package com.work.egartest.repository;

import com.work.egartest.entity.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {
    Company findByName(String name);
    void deleteById(Long id);
}
