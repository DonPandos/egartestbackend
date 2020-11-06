package com.work.egartest.dto;

import com.work.egartest.entity.PaperCost;
import lombok.Data;

import java.util.List;

@Data
public class PaperCostAllDto {
    private List<UserPaperCost> paperCostList;
}
