/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.barang.controller;

import com.example.barang.model.Barang;
import com.example.barang.repository.BarangRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api")
public class BarangController {

    @Autowired
    private BarangRepository barangRepository;

    @Operation(summary = "Ambil Semua Data BARANG")
    @GetMapping("/barang")
    public ResponseEntity<List<Barang>> getAllBarang() {
        try {

            return new ResponseEntity<>(barangRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Ambi Data BARANG Berdasarkan ID")
    @GetMapping("/barang/{id}")
    public ResponseEntity<Barang> getBarangById(@PathVariable("id") long id) {
        Optional<Barang> tutorialData = barangRepository.findById(id);

        if (tutorialData.isPresent()) {
            return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Simpan/Update Data BARANG")
    @PostMapping("/barang")
    public ResponseEntity<Barang> save(@RequestBody Barang p) {
        try {

            System.out.println("Dataa: " + p.toString());
            Barang ji = new Barang();
            if (p.getId() > 0) {
                Optional<Barang> exist = barangRepository.findById(p.getId());
                ji = exist.get();
            }
            ji.setSku(p.getSku());
            ji.setDeskripsi(p.getDeskripsi());
            ji.setJenis(p.getJenis());
            Barang peg = barangRepository.save(ji);
            return new ResponseEntity<>(peg, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Hapus Data BARANG")
    @DeleteMapping("/barang/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        try {
            barangRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
