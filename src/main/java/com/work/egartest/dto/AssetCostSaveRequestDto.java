package com.work.egartest.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AssetCostSaveRequestDto {
    private Date date;
    private String assetName;
    private Integer cost;
}
