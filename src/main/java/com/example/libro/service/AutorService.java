package com.example.libro.service;

import com.example.libro.dto.AutorDto;
import com.example.libro.entity.Autor;
import com.example.libro.exception.ResourceAlreadyExistsException;

import java.util.List;

public interface AutorService {
    List<Autor> findAll();
    Autor save(AutorDto autorDto) throws ResourceAlreadyExistsException;
    Autor findById(Long id);
}
