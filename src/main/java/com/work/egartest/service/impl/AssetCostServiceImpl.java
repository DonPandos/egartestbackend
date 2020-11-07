package com.work.egartest.service.impl;

import com.work.egartest.entity.PaperCost;
import com.work.egartest.repository.PaperCostRepository;
import com.work.egartest.service.PaperCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PaperCostServiceImpl implements PaperCostService {
    private PaperCostRepository paperCostRepository;

    @Autowired
    public PaperCostServiceImpl(PaperCostRepository paperCostRepository) {
        this.paperCostRepository = paperCostRepository;
    }

    @Override
    public PaperCost findById(Long id) {
        return paperCostRepository.findById(id).get();
    }

    @Override
    public Long save(PaperCost paperCost) {
        return paperCostRepository.save(paperCost).getId();
    }

    @Override
    public void update(PaperCost updatedPaperCost) {
        PaperCost paperCost = paperCostRepository.findById(updatedPaperCost.getId()).get();

        paperCost.setDate(updatedPaperCost.getDate());
        paperCost.setCompany(updatedPaperCost.getCompany());
        paperCost.setCost(updatedPaperCost.getCost());

        paperCostRepository.save(paperCost);
    }

    @Override
    public List<PaperCost> getAll() {
        return StreamSupport.stream(paperCostRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        paperCostRepository.deleteById(id);
    }

}
