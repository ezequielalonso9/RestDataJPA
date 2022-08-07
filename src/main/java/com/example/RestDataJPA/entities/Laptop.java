package com.example.RestDataJPA.entities;

import javax.persistence.*;

@Entity
@Table( name= "laptops")
public class Laptop {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private Double price;

    public Laptop() {
    }

    public Laptop(Long id, String marca, String modelo, Double price) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", price=" + price +
                '}';
    }
}
