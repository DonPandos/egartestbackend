package com.work.egartest.dto.request;

import lombok.Data;
import org.springframework.lang.Nullable;

import java.util.Date;

@Data
public class AssetCostUpdateRequestDto {
    @Nullable
    private Long assetCostId;
    @Nullable
    private Date date;
    @Nullable
    private Long assetId;
    @Nullable
    private Integer cost;
}
