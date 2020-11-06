package com.work.egartest.service;

import com.work.egartest.entity.PaperCost;
import org.springframework.stereotype.Service;

import java.awt.print.Paper;
import java.util.List;

@Service
public interface PaperCostService {
    PaperCost findById(Long id);
    Long save(PaperCost paperCost);
    void update(PaperCost paperCost);
    List<PaperCost> getAll();
    void delete(Long id);
}
