package com.work.egartest.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "company", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name"})
})
public class Company {

    @Id
    @GeneratedValue
    @Column(name = "company_id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;
}
