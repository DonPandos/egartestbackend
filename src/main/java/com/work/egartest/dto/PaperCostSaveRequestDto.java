package com.work.egartest.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PaperCostSaveRequestDto {
    private Date date;
    private String companyName;
    private Integer cost;
}
