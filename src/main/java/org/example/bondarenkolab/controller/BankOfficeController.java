package org.example.bondarenkolab.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.example.bondarenkolab.entity.BankOffice;
import org.example.bondarenkolab.service.BankOfficeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bank_office")
public class BankOfficeController {

    private final BankOfficeService bankOfficeService;

    // создание банковского офиса
    @Operation(summary = "Создание банковского офиса")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Банковский офис создан",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BankOffice.class))})
    })

    @PostMapping
    public BankOffice createBank(@RequestParam("bankId") Long bankId, @RequestParam("name") String name,
                                 @RequestParam("address") String address, @RequestParam("status") Boolean status,
                                 @RequestParam("canPlaceAtm") Boolean canPlaceAtm,
                                 @RequestParam("canIssueLoan") Boolean canIssueLoan,
                                 @RequestParam("isIssuingMoney") Boolean isIssuingMoney,
                                 @RequestParam("isDepositingMoney") Boolean isDepositingMoney,
                                 @RequestParam("rentalCost") Integer rentalCost) {
        return bankOfficeService.createBankOffice(bankId, name, address, status,
                canPlaceAtm, canIssueLoan, isIssuingMoney, isDepositingMoney, rentalCost);
    }

    // поиск банковского офиса по ID
    @Operation(summary = "Поиск банковского офиса по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Банковский офис найден",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BankOffice.class))})
    })

    @GetMapping("/{id}")
    public BankOffice getBankOfficeById(@Parameter(description = "ID банковского офиса") @PathVariable("id") Long id) {
        return bankOfficeService.getBankOfficeById(id);
    }

    // изменение данных в банковском офисе
    @Operation(summary = "Изменение данных в банковском офисе по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Данные изменены",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BankOffice.class))})
    })

    @PatchMapping("/{id}")
    public BankOffice updateBankOffice(@PathVariable("id") Long id, @RequestParam("bankId") Long bankId,
                                       @RequestParam("name") String name, @RequestParam("address") String address,
                                       @RequestParam("status") Boolean status,
                                       @RequestParam("canPlaceAtm") Boolean canPlaceAtm,
                                       @RequestParam("canIssueLoan") Boolean canIssueLoan,
                                       @RequestParam("isIssuingMoney") Boolean isIssuingMoney,
                                       @RequestParam("isDepositingMoney") Boolean isDepositingMoney,
                                       @RequestParam("rentalCost") Integer rentalCost) {
        return bankOfficeService.updateBankOffice(id, bankId, name, address, status,
                canPlaceAtm, canIssueLoan, isIssuingMoney, isDepositingMoney, rentalCost);
    }

    // удаление банковского офиса
    @Operation(summary = "Удаление банковского офиса")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Банковский офис удален",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BankOffice.class))})
    })

    @DeleteMapping("/{id}")
    public BankOffice deleteBank(@Parameter(description = "ID банковского офиса") @PathVariable("id") Long id) {
        bankOfficeService.deleteBankOffice(id);
        return null;
    }

    // получение всех банковских офисов
    @Operation(summary = "Получение всех банковских офисов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список всех банковских офисов",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BankOffice.class))})
    })
    @GetMapping
    public List<BankOffice> getAllBankOffices() {
        return bankOfficeService.getAllBankOffices();
    }
}