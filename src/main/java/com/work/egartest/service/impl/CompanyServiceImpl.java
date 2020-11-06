package com.work.egartest.service.impl;

import com.work.egartest.entity.Company;
import com.work.egartest.repository.CompanyRepository;
import com.work.egartest.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    @Override
    public Long save(Company company) {
        return companyRepository.save(company).getId();
    }

    @Override
    public Company findById(Long id) {
        return companyRepository.findById(id).get();
    }

    public Company findByName(String name) {
        return companyRepository.findByName(name);
    }
}
