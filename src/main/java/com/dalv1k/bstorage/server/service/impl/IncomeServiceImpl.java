package com.dalv1k.bstorage.server.service.impl;

import com.dalv1k.bstorage.server.entity.*;
import com.dalv1k.bstorage.server.exception.ResourceNotFoundException;
import com.dalv1k.bstorage.server.repo.*;
import com.dalv1k.bstorage.server.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    private IncomeRepo incomeRepo;
    @Autowired
    private BrandRepo brandRepo;
    @Autowired
    private ModelRepo modelRepo;
    @Autowired
    private TypeRepo typeRepo;
    @Autowired
    private SupplierRepo supplierRepo;
    @Autowired
    private StorageRepo storageRepo;
    @Autowired
    private StorageServiceImpl storageService;



    @Override
    public List<Income> getAllIncomeGoods() {
        return incomeRepo.findAll(Sort.by(Sort.Direction.DESC, "date"));
    }

    @Override
    public int getLastIncomePrice(Model model) {
        List<Income> incomes = incomeRepo.findAllByModelOrderByDate(model);
        try {
            return incomes.get(0).getPrice();
        }catch (IndexOutOfBoundsException e){
            return 0;
        }

    }

    @Override
    public List<Brand> getAllBrands() {
        return brandRepo.findAll();
    }

    @Override
    public List<Model> getAllModels() {
        return modelRepo.findAll();
    }

    @Override
    public List<Type> getAllTypes() {
        return typeRepo.findAll();
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepo.findAll();
    }

    @Override
    public Income getIncomeById(Integer id) {
        return incomeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Income not exist with id: " + id));
    }

    @Override
    public Income updateIncome(Integer id, Income incomeUpdate) {
        Income oldIncome = getIncomeById(id);
        System.out.println(oldIncome);
        Income oldIncomeCl = new Income(oldIncome);
        System.out.println(oldIncomeCl);
        oldIncome.setType(incomeUpdate.getType());
        oldIncome.setBrand(incomeUpdate.getBrand());
        oldIncome.setModel(incomeUpdate.getModel());
        oldIncome.setPrice(incomeUpdate.getPrice());
        oldIncome.setAmount(incomeUpdate.getAmount());
        oldIncome.setSupplier(incomeUpdate.getSupplier());
        oldIncome.setDate(incomeUpdate.getDate());
        saveIncomeGoods(oldIncome,true);
        System.out.println(oldIncome);
        System.out.println(oldIncomeCl);

        storageService.editStorage(oldIncomeCl, oldIncome);
        return oldIncome;
    }

    @Override
    public void saveIncomeGoods(Income income, boolean isUpdate) {

        Brand brand = income.getBrand();
        Model model = income.getModel();
        Type type = income.getType();
        Supplier supplier = income.getSupplier();

        Brand oldBrand = brandRepo.findByBrand(brand.getBrand());
        Model oldModel = modelRepo.findByModel(model.getModel());
        Type oldType = typeRepo.findByType(type.getType());
        Supplier oldSupplier = supplierRepo.findBySupplier(supplier.getSupplier());

        if (oldBrand != null) {
            income.setBrand(oldBrand);
        }
        if (oldType != null) {
            income.setType(oldType);
        }
        if (oldModel != null) {
            income.setModel(oldModel);
        }
        if (oldSupplier != null) {
            income.setSupplier(oldSupplier);
        }

        incomeRepo.save(income);
        if(!isUpdate){storageService.addToStorage(income);}
    }

    @Override
    public Map<String, Boolean> deleteIncome(Integer id) {
        Income income = getIncomeById(id);
        incomeRepo.delete(income);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);
        return response;
    }


}
