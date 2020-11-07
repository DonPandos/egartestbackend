package com.work.egartest.init;

import com.work.egartest.entity.Asset;
import com.work.egartest.entity.AssetCost;
import com.work.egartest.service.AssetService;
import com.work.egartest.service.AssetCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class DbDataInit implements ApplicationRunner {

    private AssetCostService assetCostService;
    private AssetService assetService;

    @Autowired
    public DbDataInit(AssetCostService assetCostService, AssetService assetService){
        this.assetCostService = assetCostService;
        this.assetService = assetService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Asset asset = new Asset();
        asset.setName("Газпром");
        assetService.save(asset);
        asset = new Asset();
        asset.setName("Автоваз");
        assetService.save(asset);
        asset = new Asset();
        asset.setName("Сбербанк");
        assetService.save(asset);

        AssetCost assetCost = new AssetCost();
        assetCost.setAsset(asset);
        assetCost.setCost(2000);
        assetCost.setDate(new Date(new java.util.Date().getTime()));
        assetCostService.save(assetCost);

//        AssetCost result;
//        Optional<AssetCost> paperCost1 = paperCostRepository.findById(4L);
//        result = paperCost1.get();
//        System.out.println(result.getCompany().getName());
    }
}
