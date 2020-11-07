package com.work.egartest.service.impl;

import com.work.egartest.entity.AssetCost;
import com.work.egartest.repository.AssetCostRepository;
import com.work.egartest.service.AssetCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AssetCostServiceImpl implements AssetCostService {
    private AssetCostRepository assetCostRepository;

    @Autowired
    public AssetCostServiceImpl(AssetCostRepository assetCostRepository) {
        this.assetCostRepository = assetCostRepository;
    }

    @Override
    public AssetCost findById(Long id) {
        return assetCostRepository.findById(id).get();
    }

    @Override
    public Long save(AssetCost assetCost) {
        return assetCostRepository.save(assetCost).getId();
    }

    @Override
    public void update(AssetCost updatedAssetCost) {
        AssetCost paperCost = assetCostRepository.findById(updatedAssetCost.getId()).get();

        paperCost.setDate(updatedAssetCost.getDate());
        paperCost.setAsset(updatedAssetCost.getAsset());
        paperCost.setCost(updatedAssetCost.getCost());

        assetCostRepository.save(paperCost);
    }

    @Override
    public List<AssetCost> getAll() {
        return StreamSupport.stream(assetCostRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        assetCostRepository.deleteById(id);
    }

}
