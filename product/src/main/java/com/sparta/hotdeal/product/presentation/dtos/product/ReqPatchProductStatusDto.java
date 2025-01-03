package com.sparta.hotdeal.product.presentation.dtos.product;

import com.sparta.hotdeal.product.domain.entity.product.ProductStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReqPatchProductStatusDto {
    private ProductStatusEnum status;
}
