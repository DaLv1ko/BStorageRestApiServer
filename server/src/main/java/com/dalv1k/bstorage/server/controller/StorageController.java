package com.dalv1k.bstorage.server.controller;

import com.dalv1k.bstorage.server.entity.Income;
import com.dalv1k.bstorage.server.entity.Sale;
import com.dalv1k.bstorage.server.entity.Storage;
import com.dalv1k.bstorage.server.service.impl.StorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/storage")
@PreAuthorize("hasRole('ADMIN')")
public class StorageController {

    @Autowired
    private StorageServiceImpl storageService;

    //rest create

//    @GetMapping("/income/{id}")
//    public ResponseEntity<Income> getIncomeById(@PathVariable Integer id){
//        Income income = incomeService.getIncomeById(id);
//        return ResponseEntity.ok(income);
//    }

    //rest read
    @GetMapping("")
    public List<Storage> getAllIncome() {
        System.out.println("returning Storage");
        return storageService.getAllStorage();
    }

    //    //rest update
    @PutMapping("/{id}")
    public ResponseEntity<Storage> sellStorage(@PathVariable Integer id, @RequestBody Sale sale){
        Storage storage = storageService.sellStorage(id,sale);
        return ResponseEntity.ok(storage);
    }

//    @PutMapping("/income/{id}")
//    public ResponseEntity<Income> updateIncome(@PathVariable Integer id, @RequestBody Income incomeUpdate){
//        Income income = incomeService.updateIncome(id, incomeUpdate);
//        return ResponseEntity.ok(income);
//    }
//
//    //rest delete
//    @DeleteMapping("/income/{id}")
//    public ResponseEntity<Map<String, Boolean>> deleteIncome(@PathVariable Integer id){
//        Map<String, Boolean> response = incomeService.deleteIncome(id);
//        return ResponseEntity.ok(response);
//    }


}
