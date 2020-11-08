package com.work.egartest.dto;

import com.work.egartest.entity.AssetCost;
import lombok.Data;

import java.sql.Date;

@Data
public class UserAssetCost {

    private Long id;
    private Date date;
    private Integer cost;
    private Long assetId;

    public UserAssetCost(AssetCost assetCost) {
        this.id = assetCost.getId();
        this.date = assetCost.getDate();
        this.cost = assetCost.getCost();
        this.assetId = assetCost.getAsset().getId();
    }
}
