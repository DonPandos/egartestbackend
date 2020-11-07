package com.work.egartest.service;

import com.work.egartest.entity.Company;

public interface CompanyService {
    Long save(Company company);
    Company findById(Long id);
    Company findByName(String name);
}
