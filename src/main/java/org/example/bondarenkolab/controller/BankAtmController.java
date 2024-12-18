package org.example.bondarenkolab.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.example.bondarenkolab.entity.BankAtm;
import org.example.bondarenkolab.service.BankAtmService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/bank_atm")
public class BankAtmController {

    private final BankAtmService bankAtmService;

    // создание банкомата
    @Operation(summary = "Создание банкомата")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "банкомат создан",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BankAtm.class))})
    })

    @PostMapping
    public BankAtm createBankAtm(@RequestParam("name") String name, @RequestParam("address") String address,
                                 @RequestParam("status") Boolean status, @RequestParam("bankId") Long bankId,
                                 @RequestParam("bankOfficeId") Long bankOfficeId,
                                 @RequestParam("employeeId") Long employeeId,
                                 @RequestParam("isIssuingMoney") Boolean isIssuingMoney,
                                 @RequestParam("isDepositingMoney") Boolean isDepositingMoney,
                                 @RequestParam("servicingCost") Integer servicingCost) {
        return bankAtmService.createBankAtm(name, address, status, bankId, bankOfficeId,
                employeeId, isIssuingMoney, isDepositingMoney, servicingCost);
    }

    // поиск банкомата по ID
    @Operation(summary = "Поиск банкомата по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "банкомат найден",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BankAtm.class))})
    })

    @GetMapping("/{id}")
    public BankAtm getBankAtmById(@Parameter(description = "ID банкомата") @PathVariable("id") Long id) {
        return bankAtmService.getBankAtmById(id);
    }

    // изменение данных банкомата
    @Operation(summary = "Изменение данных банкомата по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Данные изменены",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BankAtm.class))})
    })

    @PatchMapping("/{id}")
    public BankAtm updateBankAtm(@PathVariable("id") Long id, @RequestParam("name") String name,
                                 @RequestParam("address") String address, @RequestParam("status") Boolean status,
                                 @RequestParam("bankId") Long bankId, @RequestParam("bankOfficeId") Long bankOfficeId,
                                 @RequestParam("employeeId") Long employeeId,
                                 @RequestParam("isIssuingMoney") Boolean isIssuingMoney,
                                 @RequestParam("isDepositingMoney") Boolean isDepositingMoney,
                                 @RequestParam("servicingCost") Integer servicingCost) {
        return bankAtmService.updateBankAtm(id, name, address, status, bankId, bankOfficeId,
                employeeId, isIssuingMoney, isDepositingMoney, servicingCost);
    }

    // удаление банкомата
    @Operation(summary = "Удаление банкомата")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "банкомат удален",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BankAtm.class))})
    })

    @DeleteMapping("/{id}")
    public BankAtm deleteBankAtm(@Parameter(description = "ID банкомата") @PathVariable("id") Long id) {
        bankAtmService.deleteBankAtm(id);
        return null;
    }

    // получение всех банкоматов
    @Operation(summary = "Получение всех банкоматов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список всех банкоматов",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BankAtm.class))})
    })
    @GetMapping
    public List<BankAtm> getAllBankAtms() {
        return bankAtmService.getAllBankAtms();
    }
}