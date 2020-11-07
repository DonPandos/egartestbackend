package com.work.egartest.controller;

import com.work.egartest.dto.CompanyAddRequestDto;
import com.work.egartest.entity.Company;
import com.work.egartest.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/egar/company/")
public class CompanyController {

    private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("add")
    public ResponseEntity addCompany(@RequestBody CompanyAddRequestDto requestDto) {

        if(companyService.findByName(requestDto.getCompanyName()) != null) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }

        Company company = new Company();
        company.setName(requestDto.getCompanyName());

        companyService.save(company);

        return new ResponseEntity(HttpStatus.OK);
    }
}
