package com.work.egartest.dto.response;

import com.work.egartest.entity.Asset;
import lombok.Data;

import java.util.List;

@Data
public class AssetAllResponseDto {
    private List<Asset> assetList;
}
