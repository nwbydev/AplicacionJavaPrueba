package com.example.libro.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AutorDto {
    @Size(min = 5, max = 10, message = "El nombre debe tener entre 5 y 10 caracteres")
    private String name;
    @Size(min = 5, max = 20, message = "El nombre debe tener entre 5 y 20 caracteres")
    private String lastName;
    @Size(min = 9, max = 9, message = "El teléfono debe tener exactamente 9 caracteres")
    private String phone;
}
