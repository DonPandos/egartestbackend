package com.work.egartest.repository;

import com.work.egartest.entity.PaperCost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperCostRepository extends CrudRepository<PaperCost, Long> {
}
