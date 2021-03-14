package com.dalv1k.bstorage.server.service;

import com.dalv1k.bstorage.server.entity.*;

import java.util.List;
import java.util.Map;

public interface IncomeService {

    List<Income> getAllIncomeGoods();

    int getLastIncomePrice (Model model);

    List<Brand> getAllBrands();
    List<Model> getAllModels();
    List<Type> getAllTypes();
    List<Supplier> getAllSuppliers();


    Income getIncomeById(Integer id);

    Income updateIncome(Integer id, Income income);

    void saveIncomeGoods(Income income, boolean isUpdate);

    Map<String, Boolean> deleteIncome(Integer id);

}
