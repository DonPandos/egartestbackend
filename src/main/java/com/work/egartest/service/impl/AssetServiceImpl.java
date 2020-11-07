package com.work.egartest.service.impl;

import com.work.egartest.entity.Asset;
import com.work.egartest.repository.AssetRepository;
import com.work.egartest.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetServiceImpl implements AssetService {

    private AssetRepository assetRepository;

    @Autowired
    public AssetServiceImpl(AssetRepository assetRepository){
        this.assetRepository = assetRepository;
    }

    @Override
    public Long save(Asset asset) {
        return assetRepository.save(asset).getId();
    }

    @Override
    public Asset findById(Long id) {
        return assetRepository.findById(id).get();
    }

    public Asset findByName(String name) {
        return assetRepository.findByName(name);
    }
}
