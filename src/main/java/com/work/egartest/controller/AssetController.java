package com.work.egartest.controller;

import com.work.egartest.dto.request.AssetAddRequestDto;
import com.work.egartest.dto.response.AssetAllResponseDto;
import com.work.egartest.entity.Asset;
import com.work.egartest.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/egar/asset/")
public class AssetController {

    private AssetService assetService;

    @Autowired
    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @PostMapping("save")
    public ResponseEntity addAsset(@RequestBody AssetAddRequestDto requestDto) {

        if(assetService.findByName(requestDto.getAssetName()) != null) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }

        Asset asset = new Asset();
        asset.setName(requestDto.getAssetName());

        assetService.save(asset);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<AssetAllResponseDto> getAll() {
        List<Asset> assets = assetService.getAll();

        AssetAllResponseDto response = new AssetAllResponseDto();
        response.setAssetList(assets);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
