/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.pegawai.controller;

import com.example.pegawai.model.Pegawai;
import com.example.pegawai.repository.PegawaiRepository;
import io.swagger.v3.oas.annotations.Operation;
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

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api")
public class PegawaiController {

    @Autowired
    private PegawaiRepository pegawaiRepository;

    @Operation(summary = "Ambil Semua Data Pegawai")
    @GetMapping("/pegawai")
    public ResponseEntity<List<Pegawai>> getAllPegawai() {
        try {

            return new ResponseEntity<>(pegawaiRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Ambi Data Pegawai Berdasarkan ID")
    @GetMapping("/pegawai/{id}")
    public ResponseEntity<Pegawai> getPegawaiById(@PathVariable("id") long id) {
        Optional<Pegawai> tutorialData = pegawaiRepository.findById(id);

        if (tutorialData.isPresent()) {
            return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Simpan/Update Data Pegawai")
    @PostMapping("/pegawai")
    public ResponseEntity<Pegawai> save(@RequestBody Pegawai p) {
        try {

            System.out.println("Dataa: " + p.toString());
            Pegawai ji = new Pegawai();
            if (p.getId() > 0) {
                Optional<Pegawai> exist = pegawaiRepository.findById(p.getId());
                ji = exist.get();
            }
            ji.setNama(p.getNama());
            ji.setAlamat(p.getAlamat());
            ji.setJabatan(p.getJabatan());
            Pegawai peg = pegawaiRepository.save(ji);
            return new ResponseEntity<>(peg, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Hapus Data Pegawai")
    @DeleteMapping("/pegawai/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        try {
            pegawaiRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
