package com.dalv1k.bstorage.server.service;

import com.dalv1k.bstorage.server.entity.Sale;
import com.dalv1k.bstorage.server.entity.Storage;
import java.util.List;


public interface SaleService {

    Sale addSale(Sale sale, Storage storage);

    List<Sale> getAllSale();
}
