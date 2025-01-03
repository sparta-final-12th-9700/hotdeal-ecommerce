package com.sparta.hotdeal.payment.presentation.controller;

import com.sparta.hotdeal.payment.presentation.dtos.ResponseDto;
import com.sparta.hotdeal.payment.presentation.dtos.payment.req.ReqPostPaymentConfirmDto;
import com.sparta.hotdeal.payment.presentation.dtos.payment.req.ReqPostPaymentDto;
import com.sparta.hotdeal.payment.presentation.dtos.payment.res.ResGetPaymentByIdDto;
import com.sparta.hotdeal.payment.presentation.dtos.payment.res.ResGetPaymentsDto;
import com.sparta.hotdeal.payment.presentation.dtos.payment.res.ResPostPaymentConfirmDto;
import com.sparta.hotdeal.payment.presentation.dtos.payment.res.ResPostPaymentsDto;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/payments")
public class PaymentController {
    @PostMapping
    public ResponseDto<ResPostPaymentsDto> createPayments(@RequestBody ReqPostPaymentDto req) {
        return ResponseDto.of("결제 요청이 처리되었습니다.", ResPostPaymentsDto.createDummyData());
    }

    @PostMapping("/confirm")
    public ResponseDto<ResPostPaymentConfirmDto> confirmPayment(@RequestBody ReqPostPaymentConfirmDto req) {
        return ResponseDto.of("결제 승인 처리되었습니다.", ResPostPaymentConfirmDto.createDummy());
    }

    @GetMapping
    public ResponseDto<Page<ResGetPaymentsDto>> getPayments(Pageable pageable) {
        List<ResGetPaymentsDto> dummyList = ResGetPaymentsDto.createDummyList();
        // 페이징 처리
        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), dummyList.size());
        org.springframework.data.domain.Page<ResGetPaymentsDto> page = new PageImpl<>(dummyList.subList(start, end),
                pageable, dummyList.size());

        return ResponseDto.of("결제 내역 조회 성공", page);
    }

    @GetMapping("/{paymentId}")
    public ResponseDto<ResGetPaymentByIdDto> getPaymentById(@PathVariable UUID paymentId) {
        return ResponseDto.of("결제 상세 조회 성공", ResGetPaymentByIdDto.createDummyData(paymentId));
    }

    @DeleteMapping("/{paymentId}")
    public ResponseDto<Void> deletePayment(@PathVariable UUID paymentId) {
        return ResponseDto.of("결제 환불 처리되었습니다.", null);
    }
}
