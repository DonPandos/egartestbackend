package com.work.egartest.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "asset_cost", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"date", "asset_id"})
})
public class AssetCost {
    @Id
    @GeneratedValue
    @Column(name = "asset_cost_id", nullable = false)
    private Long id;

    @Column(name = "date", nullable = false)
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "asset_id")
    private Asset asset;

    @Column(name = "cost", nullable = false)
    private Integer cost;
}
