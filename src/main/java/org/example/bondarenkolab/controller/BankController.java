package org.example.bondarenkolab.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.example.bondarenkolab.entity.Bank;
import org.example.bondarenkolab.service.BankService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bank")
public class BankController {

    private final BankService bankService;

    // создание банка
    @Operation(summary = "Создание банка")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Банк создан",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Bank.class))})
    })

    @PostMapping
    public Bank createBank(@Parameter(description = "Название банка") @RequestParam("name") String name) {
        return bankService.createBank(name);
    }

    // поиск банка по ID
    @Operation(summary = "Поиск банка по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Банк найден",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Bank.class))})
    })

    @GetMapping("/{id}")
    public Bank getBankById(@Parameter(description = "ID банка") @PathVariable("id") Long id) {
        return bankService.getBankById(id);
    }

    // изменение данных в банке
    @Operation(summary = "Изменение данных в банке по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Данные изменены",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Bank.class))})
    })

    @PatchMapping("/{id}")
    public Bank updateBank(@Parameter(description = "ID банка") @PathVariable("id") Long id,
                           @RequestParam("name") String name) {
        return bankService.updateBank(id, name);
    }

    // удаление банка
    @Operation(summary = "Удаление банка")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Банк удален",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Bank.class))})
    })

    @DeleteMapping("/{id}")
    public Bank deleteBank(@Parameter(description = "ID банка") @PathVariable("id") Long id) {
        bankService.deleteBank(id);
        return null;
    }

    // получение всех банков
    @Operation(summary = "Получение всех банков")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список всех банков",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Bank.class))})
    })
    @GetMapping
    public List<Bank> getAllBanks() {
        return bankService.getAllBanks();
    }
}