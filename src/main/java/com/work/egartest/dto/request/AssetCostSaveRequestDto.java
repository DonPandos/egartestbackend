package com.work.egartest.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class AssetCostSaveRequestDto {
    private Date date;
    private Long assetId;
    private Integer cost;
}
