package com.work.egartest.dto;

import com.work.egartest.entity.PaperCost;
import lombok.Data;

import java.sql.Date;

@Data
public class UserPaperCost {

    private Long id;
    private Date date;
    private Integer cost;
    private String companyName;

    public UserPaperCost(PaperCost paperCost) {
        this.id = paperCost.getId();
        this.date = paperCost.getDate();
        this.cost = paperCost.getCost();
        this.companyName = paperCost.getCompany().getName();
    }
}
