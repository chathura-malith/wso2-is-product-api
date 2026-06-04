package com.chathura.product_api.mapper;

import com.chathura.product_api.dto.request.ProductRequestDto;
import com.chathura.product_api.dto.response.ProductImageDto;
import com.chathura.product_api.dto.response.ProductResponseDto;
import com.chathura.product_api.entity.Product;
import com.chathura.product_api.entity.ProductImage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "images", ignore = true)
    Product toEntity(ProductRequestDto dto);

    ProductResponseDto toDto(Product entity);

    @Mapping(target = "downloadUrl", ignore = true)
    ProductImageDto toImageDto(ProductImage image);
}