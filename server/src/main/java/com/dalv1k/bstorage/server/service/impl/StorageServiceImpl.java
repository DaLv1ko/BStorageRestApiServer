package com.dalv1k.bstorage.server.service.impl;

import com.dalv1k.bstorage.server.entity.*;
import com.dalv1k.bstorage.server.exception.ResourceNotFoundException;
import com.dalv1k.bstorage.server.repo.BrandRepo;
import com.dalv1k.bstorage.server.repo.ModelRepo;
import com.dalv1k.bstorage.server.repo.StorageRepo;
import com.dalv1k.bstorage.server.repo.TypeRepo;
import com.dalv1k.bstorage.server.service.IncomeService;
import com.dalv1k.bstorage.server.service.SaleService;
import com.dalv1k.bstorage.server.service.StorageService;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageRepo storageRepo;
    @Autowired
    private ModelRepo modelRepo;
    @Autowired
    private BrandRepo brandRepo;
    @Autowired
    private TypeRepo typeRepo;
    @Autowired
    private IncomeService incomeService;
    @Autowired
    private SaleService saleService;

    @Override
    public Storage getStorageById(Integer id) {
        return storageRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Storage not exist with id: " + id));
    }

    @Override
    public List<Storage> getAllStorage() {
        return storageRepo.findAllByAmountGreaterThan(0);
    }

    @Override
    public void addToStorage(Income income) {
        Storage storage = storageRepo.findByModel(income.getModel());
        if(storage!=null){
            updateStorage(income, storage);
        }else{
            Storage storageNew=new Storage();
            storageNew.setType(income.getType());
            storageNew.setBrand(income.getBrand());
            storageNew.setModel(income.getModel());
            storageNew.setLastPrice(income.getPrice());
            storageNew.setAmount(income.getAmount());
            saveStorageGoods(storageNew);
        }

    }

    public void editStorage(Income oldIncome, Income newIncome){
        Storage storage = storageRepo.findByModel(oldIncome.getModel());
        System.out.println(storage.getAmount());
        System.out.println(newIncome.getAmount());
        try{
            if(storage.getAmount()-newIncome.getAmount()==0){
                storageRepo.delete(storage);
            } else{
                storage.setAmount(storage.getAmount()-oldIncome.getAmount());
                //TODO lastPRICE
                //  storage.setLastPrice();
                System.out.println(getLastIncomePrice(storage.getModel()));
            }
        } catch (NullPointerException e ){
                storageRepo.delete(storage);
        }
        addToStorage(newIncome);
    }

    public int getLastIncomePrice(Model model){
        return incomeService.getLastIncomePrice(model);
    }

    @Override
    public void updateStorage( Income income, Storage storage) {
                storage.setAmount(storage.getAmount()+income.getAmount());
                storage.setLastPrice(income.getPrice());
                saveStorageGoods(storage);
    }

    @Override
    public void saveStorageGoods(Storage storage) {

        Brand brand = storage.getBrand();
        Model model = storage.getModel();
        Type type = storage.getType();

        Brand oldBrand = brandRepo.findByBrand(brand.getBrand());
        Model oldModel = modelRepo.findByModel(model.getModel());
        Type oldType = typeRepo.findByType(type.getType());

        if (oldBrand != null) {
            storage.setBrand(oldBrand);
        }
        if (oldType != null) {
            storage.setType(oldType);
        }
        if (oldModel != null) {
            storage.setModel(oldModel);
        }

        storageRepo.save(storage);
    }

    @Override
    public Storage sellStorage(Integer id, Sale sale) {
        Storage storage = getStorageById(id);
        storage.setAmount(storage.getAmount()-sale.getAmount());
        saveStorageGoods(storage);
        saleService.addSale(sale,storage);
        return storage;
    }

    @Override
    public Map<String, Boolean> deleteStorage(Integer id) {
        Storage storage = getStorageById(id);
        storageRepo.delete(storage);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);
        return response;
    }
}
