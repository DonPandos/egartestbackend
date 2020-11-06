package com.work.egartest.init;

import com.work.egartest.entity.Company;
import com.work.egartest.entity.PaperCost;
import com.work.egartest.repository.CompanyRepository;
import com.work.egartest.repository.PaperCostRepository;
import com.work.egartest.service.CompanyService;
import com.work.egartest.service.PaperCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class DbDataInit implements ApplicationRunner {

    private PaperCostService paperCostService;
    private CompanyService companyService;

    @Autowired
    public DbDataInit(PaperCostService paperCostService, CompanyService companyService){
        this.companyService = companyService;
        this.paperCostService = paperCostService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Company company = new Company();
        company.setName("Газпром");
        companyService.save(company);
        company = new Company();
        company.setName("Автоваз");
        companyService.save(company);
        company = new Company();
        company.setName("Сбербанк");
        companyService.save(company);

        PaperCost paperCost = new PaperCost();
        paperCost.setCompany(company);
        paperCost.setCost(2000);
        paperCost.setDate(new Date(new java.util.Date().getTime()));
        paperCostService.save(paperCost);

//        PaperCost result;
//        Optional<PaperCost> paperCost1 = paperCostRepository.findById(4L);
//        result = paperCost1.get();
//        System.out.println(result.getCompany().getName());
    }
}
