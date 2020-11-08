package com.work.egartest.service;

import com.work.egartest.entity.Asset;

import java.util.List;

public interface AssetService {
    Long save(Asset asset);
    Asset findById(Long id);
    Asset findByName(String name);
    List<Asset> getAll();
}
