package com.example.libro.dto;

import com.example.libro.entity.Autor;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LibroDto {

    @NotBlank(message = "El nombre no debe estar en blanco")
    @Size(min = 5, message = "El nombre debe tener al menos 5 caracteres")
    private String name;

    @NotNull(message = "La fecha no puede ser nula")
    @Past(message = "La fecha debe ser anterior a la fecha actual")
    private LocalDate fecha;

    private Long idAutor;
}
