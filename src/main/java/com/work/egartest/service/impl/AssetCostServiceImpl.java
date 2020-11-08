package com.work.egartest.service.impl;

import com.work.egartest.dto.ChartDataItem;
import com.work.egartest.entity.AssetCost;
import com.work.egartest.repository.AssetCostRepository;
import com.work.egartest.service.AssetCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        AssetCost assetCost = assetCostRepository.findById(updatedAssetCost.getId()).get();

        if(updatedAssetCost.getCost() != null) assetCost.setCost(updatedAssetCost.getCost());
        if(updatedAssetCost.getDate() != null) assetCost.setDate(updatedAssetCost.getDate());
        if(updatedAssetCost.getAsset() != null) assetCost.setAsset(updatedAssetCost.getAsset());

        assetCostRepository.save(assetCost);
    }

    @Override
    public List<AssetCost> getAll() {
        return StreamSupport.stream(assetCostRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        assetCostRepository.deleteById(id);
    }

    @Override
    public List<ChartDataItem> getChartData(Long id) {
        List<AssetCost> assetCosts = assetCostRepository.findByAssetId(id);
        List<ChartDataItem> result = new ArrayList<>();
        assetCosts.forEach(item -> result.add(new ChartDataItem(item.getDate(), item.getCost())));
        return result;
    }

}
