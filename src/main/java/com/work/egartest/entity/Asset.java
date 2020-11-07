package com.work.egartest.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "asset", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name"})
})
public class Asset {

    @Id
    @GeneratedValue
    @Column(name = "asset_id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;
}
