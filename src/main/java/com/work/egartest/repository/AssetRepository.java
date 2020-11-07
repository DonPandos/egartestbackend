package com.work.egartest.repository;

import com.work.egartest.entity.Asset;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends CrudRepository<Asset, Long> {
    Asset findByName(String name);
    void deleteById(Long id);
}
