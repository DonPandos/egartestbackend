package com.work.egartest.repository;

import com.work.egartest.entity.AssetCost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetCostRepository extends CrudRepository<AssetCost, Long> {
    List<AssetCost> findByAssetId(Long id);
}
