package com.work.egartest.dto;

import lombok.Data;

import java.sql.Date;
import java.util.Map;

@Data
public class DateToCostChartResponseDto {
    private Map<Date, Integer> chartData;

}
