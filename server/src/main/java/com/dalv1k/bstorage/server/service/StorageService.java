package com.dalv1k.bstorage.server.service;

import com.dalv1k.bstorage.server.entity.Income;
import com.dalv1k.bstorage.server.entity.Sale;
import com.dalv1k.bstorage.server.entity.Storage;

import java.util.List;
import java.util.Map;

public interface StorageService {

    Storage getStorageById(Integer id);

    List<Storage> getAllStorage();

    Map<String, Boolean> deleteStorage(Integer id);

    void addToStorage(Income income);

    void updateStorage(Income income, Storage storage);

    void saveStorageGoods(Storage storage);

    Storage sellStorage(Integer id, Sale sale);
}
