package io.classiccrew.payment_service.controller;

import org.springframework.web.bind.annotation.RestController;
import io.classiccrew.payment_service.constants.PaymentConstants;
import io.classiccrew.payment_service.dto.ContactInfoDto;
import io.classiccrew.payment_service.dto.ResponseDto;
import io.classiccrew.payment_service.service.IPaymentsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@Tag(name = "Payments", description = "The Payments API")
@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class PaymentController {

    private final IPaymentsService iPaymentsService;

    public PaymentController(IPaymentsService iPaymentsService) {
        this.iPaymentsService = iPaymentsService;
    }

    @Value("${build.version}")
    private String buildVersion;

    @Autowired
    private ContactInfoDto contactInfoDto;

    @PostMapping("/request-payment")
    public ResponseEntity<ResponseDto> requestPayment(@RequestBody String entity) {
        // TODO: process POST request

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto(PaymentConstants.STATUS_200, PaymentConstants.MESSAGE_200));
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

    @GetMapping("/contact-info")
    public ResponseEntity<ContactInfoDto> getContactInfo() {
        return ResponseEntity.status(HttpStatus.OK).body(contactInfoDto);
    }
}
