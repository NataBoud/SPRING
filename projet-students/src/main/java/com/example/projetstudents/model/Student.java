package com.example.projetstudents.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private UUID id;
    @NotBlank(message = "La valeur ne doit pas être vide")
    private String name;
    @Min(value = 18)
    @Max(value = 60)
    private int age;
    private String email;
}
