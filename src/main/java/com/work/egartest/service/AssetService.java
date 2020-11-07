package com.work.egartest.service;

import com.work.egartest.entity.Asset;

public interface AssetService {
    Long save(Asset asset);
    Asset findById(Long id);
    Asset findByName(String name);
}
