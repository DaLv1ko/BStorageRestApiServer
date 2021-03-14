package com.dalv1k.bstorage.server.controller;

import com.dalv1k.bstorage.server.entity.*;
import com.dalv1k.bstorage.server.service.impl.IncomeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/income")
@PreAuthorize("hasRole('ADMIN')")
public class IncomeController {

    @Autowired
    private IncomeServiceImpl incomeService;

    //rest create
    @PostMapping("")
//    @PreAuthorize("hasRole('ADMIN')")
    public Income addIncome(@RequestBody Income income) {
        incomeService.saveIncomeGoods(income, false);
        return income;
    }


    //rest read
    @GetMapping("")
//    @PreAuthorize("hasRole('ADMIN')")
    public List<Income> getAllIncome() {
        return incomeService.getAllIncomeGoods();
    }

    @GetMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Income> getIncomeById(@PathVariable Integer id) {
        Income income = incomeService.getIncomeById(id);
        return ResponseEntity.ok(income);
    }

    @GetMapping("/brands")
//    @PreAuthorize("hasRole('ADMIN')")
    public List<Brand> getAllBrands() {
        return incomeService.getAllBrands();
    }

    @GetMapping("/models")
//    @PreAuthorize("hasRole('ADMIN')")
    public List<Model> getAllModels() {
        return incomeService.getAllModels();
    }

    @GetMapping("/types")
//    @PreAuthorize("hasRole('ADMIN')")
    public List<Type> getAllTypes() {
        return incomeService.getAllTypes();
    }

    @GetMapping("/suppliers")
//    @PreAuthorize("hasRole('ADMIN')")
    public List<Supplier> getAllSuppliers() {
        return incomeService.getAllSuppliers();
    }

    //rest update
    @PutMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Income> updateIncome(@PathVariable Integer id, @RequestBody Income incomeUpdate) {
        Income income = incomeService.updateIncome(id, incomeUpdate);
        return ResponseEntity.ok(income);
    }

    //rest delete
    @DeleteMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Map<String, Boolean>> deleteIncome(@PathVariable Integer id) {
        Map<String, Boolean> response = incomeService.deleteIncome(id);
        return ResponseEntity.ok(response);
    }


}
