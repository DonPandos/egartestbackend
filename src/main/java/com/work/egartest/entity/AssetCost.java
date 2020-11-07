package com.work.egartest.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "paper_cost", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"date", "company_id"})
})
public class PaperCost {
    @Id
    @GeneratedValue
    @Column(name = "paper_cost_id", nullable = false)
    private Long id;

    @Column(name = "date", nullable = false)
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "cost", nullable = false)
    private Integer cost;
}
