package com.example.RestDataJPA.controllers;

import com.example.RestDataJPA.entities.Laptop;
import com.example.RestDataJPA.repository.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    private final LaptopRepository laptopRepository;

    public LaptopController( LaptopRepository laptopRepository ){
        this.laptopRepository = laptopRepository;
    }


    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){

        return laptopRepository.findAll();
    }

    @GetMapping("/api/laptop/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id){
        Optional<Laptop> laptop = laptopRepository.findById(id);

        if( laptop.isEmpty() )
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(laptop.get());
    }

    @PostMapping("/api/laptop")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop){

        if( laptop == null )
            return ResponseEntity.badRequest().build();

        laptopRepository.save(laptop);
        return ResponseEntity.ok(laptop);
    }

    @PutMapping("api/laptop/{id}")
    public ResponseEntity<Laptop> update(@PathVariable Long id , @RequestBody Laptop laptop){

       Optional<Laptop> laptopToUpdate = laptopRepository.findById(id)
                .map(laptopById -> {
                    laptopById.setPrice(laptop.getPrice());
                    laptopById.setMarca(laptop.getMarca());
                    laptopById.setModelo(laptop.getModelo());
                    return laptopById;
                });

       if( laptopToUpdate.isEmpty() )
           return ResponseEntity.notFound().build();

        return ResponseEntity.ok(laptopToUpdate.get());
    }


    @DeleteMapping("api/laptop/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
        boolean exist = laptopRepository.existsById(id);

        if( !exist )
            return ResponseEntity.notFound().build();

        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("api/laptops")
    public ResponseEntity<Laptop> deleteAll(){

        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }


}
