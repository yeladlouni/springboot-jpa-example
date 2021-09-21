package com.example.springbootjpaexample;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    private long id;
    private String label;
    private String manufacturer;
    private double price;
    private double length;
    private double width;
    private double height;
    private double weight;
    private String color;
    private String category;
}

