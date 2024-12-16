package org.example.bondarenkolab.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.example.bondarenkolab.entity.User;
import org.example.bondarenkolab.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // создание пользователя
    @Operation(summary = "Создание пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "пользователь создан",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class))})
    })

    @PostMapping
    public User createUser(@RequestParam("fullName") String fullName,
                           @RequestParam("birthDate") LocalDate birthDate,
                           @RequestParam("workplace") String workplace) {
        return userService.createUser(fullName, birthDate, workplace);
    }

    // поиск пользователя по ID
    @Operation(summary = "Поиск пользователя по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "пользователь найден",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class))})
    })

    @GetMapping("/{id}")
    public User getUserById(@Parameter(description = "ID пользователя") @PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    // изменение данных пользователя
    @Operation(summary = "Изменение данных пользователя по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Данные изменены",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class))})
    })

    @PatchMapping("/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestParam("fullName") String fullName,
                           @RequestParam("workplace") String workplace) {
        return userService.updateUser(id, fullName, workplace);
    }

    // удаление пользователя
    @Operation(summary = "Удаление пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "пользователь удален",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class))})
    })

    @DeleteMapping("/{id}")
    public User deleteUser(@Parameter(description = "ID пользователя") @PathVariable("id") Long id) {
        userService.deleteUser(id);
        return null;
    }

    // получение всех пользователей
    @Operation(summary = "Получение всех пользователей")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список пользователей получен",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class))})
    })
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}