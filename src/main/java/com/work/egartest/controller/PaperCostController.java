package com.work.egartest.controller;

import com.work.egartest.dto.*;
import com.work.egartest.entity.PaperCost;
import com.work.egartest.service.CompanyService;
import com.work.egartest.service.PaperCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/egar/papercost/")
public class PaperCostController {
    private PaperCostService paperCostService;
    private CompanyService companyService;

    @Autowired
    public PaperCostController(PaperCostService paperCostService, CompanyService companyService) {
        this.paperCostService = paperCostService;
        this.companyService = companyService;
    }

    @GetMapping("all")
    public ResponseEntity<PaperCostAllDto> getAll() {
        PaperCostAllDto result = new PaperCostAllDto();
        result.setPaperCostList(paperCostService.getAll().stream().map(item -> new UserPaperCost(item)).collect(Collectors.toList()));

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity savePaperCost(@RequestBody PaperCostSaveRequestDto requestDto) {
        if(companyService.findByName(requestDto.getCompanyName()) == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        PaperCost paperCost = new PaperCost();

        paperCost.setDate(new Date(requestDto.getDate().getTime()));
        paperCost.setCost(requestDto.getCost());
        paperCost.setCompany(companyService.findByName(requestDto.getCompanyName()));

        paperCostService.save(paperCost);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("update")
    public ResponseEntity updatePaperCost(@RequestBody PaperCostUpdateRequestDto requestDto) {

        if(paperCostService.findById(requestDto.getPaperCostId()) == null || companyService.findByName(requestDto.getCompanyName()) == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        PaperCost paperCost = new PaperCost();

        paperCost.setId(requestDto.getPaperCostId());
        paperCost.setCost(requestDto.getCost());
        paperCost.setDate(new Date(requestDto.getDate().getTime()));
        paperCost.setCompany(companyService.findByName(requestDto.getCompanyName()));

        paperCostService.update(paperCost);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("delete")
    public ResponseEntity deletePaperCost(@RequestBody PaperCostDeleteRequestDto requestDto) {
        if(paperCostService.findById(requestDto.getPaperCostId()) == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        paperCostService.delete(requestDto.getPaperCostId());
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("date-to-cost-chart-data")
    public ResponseEntity<DateToCostChartResponseDto> getDateToCostChartData() {
        DateToCostChartResponseDto response = new DateToCostChartResponseDto();

        Map<Date, Integer> chartData = new HashMap<>();
        paperCostService.getAll().stream().map(item -> chartData.put(item.getDate(), item.getCost()));
        response.setChartData(chartData);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
