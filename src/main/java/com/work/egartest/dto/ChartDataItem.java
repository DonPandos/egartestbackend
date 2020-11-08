package com.work.egartest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data
@AllArgsConstructor
public class ChartDataItem {
    private Date date;
    private Integer cost;
}
