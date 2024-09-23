package io.classiccrew.payment_service.controller;

import org.springframework.web.bind.annotation.RestController;
import io.classiccrew.payment_service.constants.PaymentsConstants;
import io.classiccrew.payment_service.dto.ResponseDto;
import io.classiccrew.payment_service.service.IPaymentsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class PaymentsController {

    private IPaymentsService iPaymentsService;

    @Value("${build.version}")
    private String buildVersion;

    @PostMapping("/request-payment")
    public ResponseEntity<ResponseDto> requestPayment(@RequestBody String entity) {
        // TODO: process POST request

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto(PaymentsConstants.STATUS_200, PaymentsConstants.MESSAGE_200));
    }

    @GetMapping("/check-payment-result")
    public String checkPaymentResult(@RequestParam String param) {
        return new String();
    }

    @PostMapping("request-refund")
    public String requestRefund(@RequestBody String entity) {
        // TODO: process POST request

        return entity;
    }

    @GetMapping("/get-payment-status")
    public String getPaymentStatus() {
        // TODO: process GET request

        return new String();
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("/build-info")
    public ResponseEntity<String> getBuildInfo() {
        return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
    }

}
