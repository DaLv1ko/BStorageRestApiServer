package com.dalv1k.bstorage.server.controller;

import com.dalv1k.bstorage.server.entity.Sale;
import com.dalv1k.bstorage.server.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/sale")
@PreAuthorize("hasRole('ADMIN')")
public class SaleController {
    @Autowired
    private SaleService saleService;

    @GetMapping("")
    public List<Sale> getAllSale(){
        return saleService.getAllSale();
    }


}
