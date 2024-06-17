package com.example.springboot.models.dto;

import jakarta.validation.constraints.NotBlank; // o valor não pode ser null nem branco nenm nenhum string vazia
import jakarta.validation.constraints.NotNull; // não dá para receber valores nulls na base de dados

import java.math.BigDecimal;

public record ProductRecordDto(@NotBlank String name, @NotNull BigDecimal value) {

}
