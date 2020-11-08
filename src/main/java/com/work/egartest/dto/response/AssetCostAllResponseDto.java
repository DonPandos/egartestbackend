package com.work.egartest.dto.response;

import com.work.egartest.dto.UserAssetCost;
import lombok.Data;

import java.util.List;

@Data
public class AssetCostAllResponseDto {
    private List<UserAssetCost> assetCostList;
}
