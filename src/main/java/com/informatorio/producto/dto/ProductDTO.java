package com.informatorio.producto.dto;

import lombok.*;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;

    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    private double unitPrice;
}
