package com.work.egartest.controller;

import com.work.egartest.dto.*;
import com.work.egartest.dto.request.AssetCostDeleteRequestDto;
import com.work.egartest.dto.request.AssetCostSaveRequestDto;
import com.work.egartest.dto.request.AssetCostUpdateRequestDto;
import com.work.egartest.dto.request.DateToCostChartRequestDto;
import com.work.egartest.dto.response.AssetCostAllResponseDto;
import com.work.egartest.dto.response.DateToCostChartResponseDto;
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
@RequestMapping("/api/egar/assetcost/")
public class AssetCostController {
    private AssetCostService assetCostService;
    private AssetService assetService;

    @Autowired
    public AssetCostController(AssetCostService assetCostService, AssetService assetService) {
        this.assetCostService = assetCostService;
        this.assetService = assetService;
    }

    @GetMapping("all")
    public ResponseEntity<AssetCostAllResponseDto> getAll() {
        AssetCostAllResponseDto result = new AssetCostAllResponseDto();
        result.setAssetCostList(assetCostService.getAll().stream().map(item -> new UserAssetCost(item)).collect(Collectors.toList()));

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity savePaperCost(@RequestBody AssetCostSaveRequestDto requestDto) {
        if(assetService.findById(requestDto.getAssetId()) == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        AssetCost assetCost = new AssetCost();

        assetCost.setDate(new Date(requestDto.getDate().getTime()));
        assetCost.setCost(requestDto.getCost());
        assetCost.setAsset(assetService.findById(requestDto.getAssetId()));

        assetCostService.save(assetCost);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("update")
    public ResponseEntity updatePaperCost(@RequestBody AssetCostUpdateRequestDto requestDto) {
        if(assetCostService.findById(requestDto.getAssetCostId()) == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        AssetCost assetCost = new AssetCost();

        assetCost.setId(requestDto.getAssetCostId());
        if(requestDto.getCost() != null) assetCost.setCost(requestDto.getCost());
        if(requestDto.getDate() != null) assetCost.setDate(new Date(requestDto.getDate().getTime()));
        if(requestDto.getAssetId() != null)  assetCost.setAsset(assetService.findById(requestDto.getAssetId()));

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

    @PostMapping("date-to-cost-chart-data")
    public ResponseEntity<DateToCostChartResponseDto> getDateToCostChartData(@RequestBody DateToCostChartRequestDto requestDto) {
        DateToCostChartResponseDto response = new DateToCostChartResponseDto();
        response.setChartData(assetCostService.getChartData(requestDto.getAssetId()));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
