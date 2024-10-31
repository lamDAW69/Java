package com.eoi.product_manager.products;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class product {
    @Id
    private int id;

    private String reference;
    private String name;
    private double price;
    private int category;

}


