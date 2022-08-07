package com.example.RestDataJPA.repository;

import com.example.RestDataJPA.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
