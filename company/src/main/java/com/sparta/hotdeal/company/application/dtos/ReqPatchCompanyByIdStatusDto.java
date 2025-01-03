package com.sparta.hotdeal.company.application.dtos;

import com.sparta.hotdeal.company.domain.entity.CompanyStatusEnum;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReqPatchCompanyByIdStatusDto {
    private CompanyStatusEnum status;
}
