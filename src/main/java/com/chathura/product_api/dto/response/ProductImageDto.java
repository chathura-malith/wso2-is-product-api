package com.chathura.product_api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductImageDto {
    private Long id;
    private String name;
    private String type;
    private String downloadUrl;
}