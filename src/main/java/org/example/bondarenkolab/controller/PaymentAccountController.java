package org.example.bondarenkolab.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.example.bondarenkolab.dto.PaymentAccountDto;
import org.example.bondarenkolab.entity.PaymentAccount;
import org.example.bondarenkolab.service.PaymentAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment_account")
public class PaymentAccountController {

    private final PaymentAccountService paymentAccountService;

    // создание платежного счета
    @Operation(summary = "Создание платежного счета")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "платежный счет создан",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PaymentAccount.class))})
    })

    @PostMapping
    public PaymentAccountDto createPaymentAccount(@RequestParam("userId") Long userId,
                                                  @RequestParam("bankId") Long bankId) {
        return paymentAccountService.createPaymentAccount(userId, bankId);
    }

    // поиск платежного счета по ID
    @Operation(summary = "Поиск платежного счета по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "платежный счет найден",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PaymentAccount.class))})
    })

    @GetMapping("/{id}")
    public PaymentAccount getPaymentAccountById(@Parameter(description = "ID платежного счета")
                                                @PathVariable("id") Long id) {
        return paymentAccountService.getPaymentAccountById(id);
    }

    // изменение данных платежного счета
    @Operation(summary = "Изменение платежного счета по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Данные изменены",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PaymentAccount.class))})
    })

    @PatchMapping("/{id}")
    public PaymentAccountDto updatePaymentAccount(@PathVariable("id") Long id, @RequestParam("amount") Integer amount) {
        return paymentAccountService.updatePaymentAccount(id, amount);
    }

    // удаление платежного счета
    @Operation(summary = "Удаление платежного счета")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "платежный счет удален",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PaymentAccount.class))})
    })

    @DeleteMapping("/{id}")
    public PaymentAccount deletePaymentAccount(@Parameter(description = "ID платежного счета")
                                               @PathVariable("id") Long id) {
        paymentAccountService.deletePaymentAccount(id);
        return null;
    }

    // получение всех платежных счетов
    @Operation(summary = "Получение всех платежных счетов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список платежных счетов получен",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PaymentAccount.class))})
    })
    @GetMapping
    public List<PaymentAccount> getAllPaymentAccounts() {
        return paymentAccountService.getAllPaymentAccounts();
    }
}