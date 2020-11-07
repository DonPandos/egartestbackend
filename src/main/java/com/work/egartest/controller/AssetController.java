package com.work.egartest.controller;

import com.work.egartest.dto.AssetAddRequestDto;
import com.work.egartest.entity.Asset;
import com.work.egartest.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/egar/company/")
public class AssetController {

    private AssetService assetService;

    @Autowired
    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @PostMapping("add")
    public ResponseEntity addAsset(@RequestBody AssetAddRequestDto requestDto) {

        if(assetService.findByName(requestDto.getAssetName()) != null) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }

        Asset asset = new Asset();
        asset.setName(requestDto.getAssetName());

        assetService.save(asset);

        return new ResponseEntity(HttpStatus.OK);
    }
}
