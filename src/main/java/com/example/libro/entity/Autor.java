package com.example.libro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true,length = 20)
    private String name;

    @Column(nullable = false,length = 20)
    private String lastName;

    @Column(nullable = false,length = 9)
    private String phone;

    @OneToMany(mappedBy = "autor")
    private List<Libro> libros;
}
