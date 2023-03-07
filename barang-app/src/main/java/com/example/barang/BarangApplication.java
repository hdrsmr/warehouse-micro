package com.example.barang;

import com.example.barang.model.Barang;
import com.example.barang.repository.BarangRepository;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BarangApplication {
    
    @Autowired
    private BarangRepository barang;

	public static void main(String[] args) {
		SpringApplication.run(BarangApplication.class, args);
	}
        
        @PostConstruct
        private void postInit(){
            Barang b = new Barang();
            b.setDeskripsi("Oreo");
            b.setJenis("Biskuit");
            b.setSku("0098");
            barang.save(b);
            
            b = new Barang();
            b.setDeskripsi("Coca-Cola");
            b.setJenis("Minuman");
            b.setSku("3351");
            barang.save(b);
            
            b = new Barang();
            b.setDeskripsi("Dji Sam Soe");
            b.setJenis("Rokok");
            b.setSku("08234");
            barang.save(b);
            
            b = new Barang();
            b.setDeskripsi("Chiki Ball");
            b.setJenis("Makanan Ringan");
            b.setSku("3345");
            barang.save(b);
            
            b = new Barang();
            b.setDeskripsi("Dorayaki");
            b.setJenis("Kue");
            b.setSku("7453");
            barang.save(b);
            
        }
        

}
