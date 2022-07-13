package com.informatorio.producto.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    private double unitPrice;

    @Override
    public boolean equals(Object o) {
        ProductEntity that = (ProductEntity) o;
        return this.id == that.getId();
    }

}
