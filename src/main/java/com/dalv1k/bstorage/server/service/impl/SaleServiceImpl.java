package com.dalv1k.bstorage.server.service.impl;

import com.dalv1k.bstorage.server.entity.Sale;
import com.dalv1k.bstorage.server.entity.Storage;
import com.dalv1k.bstorage.server.repo.SaleRepo;
import com.dalv1k.bstorage.server.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepo saleRepo;

    @Override
    public Sale addSale(Sale sale, Storage storage) {
        sale.setType(storage.getType());
        sale.setBrand(storage.getBrand());
        sale.setModel(storage.getModel());
        saleRepo.save(sale);
        return sale;
    }

    @Override
    public List<Sale> getAllSale() {
        return saleRepo.findAll();
    }
}
