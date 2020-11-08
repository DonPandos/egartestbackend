package com.work.egartest.service;

import com.work.egartest.dto.ChartDataItem;
import com.work.egartest.entity.AssetCost;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Service
public interface AssetCostService {
    AssetCost findById(Long id);
    Long save(AssetCost assetCost);
    void update(AssetCost assetCost);
    List<AssetCost> getAll();
    void delete(Long id);
    List<ChartDataItem> getChartData(Long id);
}
