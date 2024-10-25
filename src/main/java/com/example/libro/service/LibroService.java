package com.example.libro.service;

import com.example.libro.dto.LibroDto;
import com.example.libro.entity.Libro;
import com.example.libro.exception.ResourceAlreadyExistsException;

import java.util.List;

public interface LibroService {
    List<Libro> findAll();
    Libro save(LibroDto libroDto) throws ResourceAlreadyExistsException;
}
