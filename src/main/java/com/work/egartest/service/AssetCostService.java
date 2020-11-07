package com.work.egartest.service;

import com.work.egartest.entity.AssetCost;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AssetCostService {
    AssetCost findById(Long id);
    Long save(AssetCost assetCost);
    void update(AssetCost assetCost);
    List<AssetCost> getAll();
    void delete(Long id);
}
