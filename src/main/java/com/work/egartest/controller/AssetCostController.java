package com.work.egartest.controller;

import com.work.egartest.dto.*;
import com.work.egartest.entity.Asset;
import com.work.egartest.entity.AssetCost;
import com.work.egartest.service.AssetService;
import com.work.egartest.service.AssetCostService;
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
public class AssetCostController {
    private AssetCostService assetCostService;
    private AssetService assetService;

    @Autowired
    public AssetCostController(AssetCostService assetCostService, AssetService assetService) {
        this.assetCostService = assetCostService;
        this.assetService = assetService;
    }

    @GetMapping("all")
    public ResponseEntity<AssetCostAllDto> getAll() {
        AssetCostAllDto result = new AssetCostAllDto();
        result.setAssetCostList(assetCostService.getAll().stream().map(item -> new UserAssetCost(item)).collect(Collectors.toList()));

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity savePaperCost(@RequestBody AssetCostSaveRequestDto requestDto) {
        if(assetService.findByName(requestDto.getAssetName()) == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        AssetCost assetCost = new AssetCost();

        assetCost.setDate(new Date(requestDto.getDate().getTime()));
        assetCost.setCost(requestDto.getCost());
        assetCost.setAsset(assetService.findByName(requestDto.getAssetName()));

        assetCostService.save(assetCost);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("update")
    public ResponseEntity updatePaperCost(@RequestBody AssetCostUpdateRequestDto requestDto) {

        Asset asset = assetService.findByName(requestDto.getAssetName());
        if(assetCostService.findById(requestDto.getAssetCostId()) == null ||  asset == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        AssetCost assetCost = new AssetCost();

        assetCost.setId(requestDto.getAssetCostId());
        assetCost.setCost(requestDto.getCost());
        assetCost.setDate(new Date(requestDto.getDate().getTime()));
        assetCost.setAsset(asset);

        assetCostService.update(assetCost);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("delete")
    public ResponseEntity deletePaperCost(@RequestBody AssetCostDeleteRequestDto requestDto) {
        if(assetCostService.findById(requestDto.getAssetCostId()) == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        assetCostService.delete(requestDto.getAssetCostId());
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("date-to-cost-chart-data")
    public ResponseEntity<DateToCostChartResponseDto> getDateToCostChartData() {
        DateToCostChartResponseDto response = new DateToCostChartResponseDto();

        Map<Date, Integer> chartData = new HashMap<>();
        assetCostService.getAll().stream().map(item -> chartData.put(item.getDate(), item.getCost()));
        response.setChartData(chartData);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
