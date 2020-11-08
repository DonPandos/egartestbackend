package com.work.egartest.dto.response;

import com.work.egartest.dto.ChartDataItem;
import lombok.Data;
import java.util.List;


@Data
public class DateToCostChartResponseDto {
    private List<ChartDataItem> chartData;
}
