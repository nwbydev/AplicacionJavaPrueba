package com.example.libro.controller;

import com.example.libro.dto.LibroDto;
import com.example.libro.entity.Libro;
import com.example.libro.exception.ResourceAlreadyExistsException;
import com.example.libro.service.LibroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libro")
@CrossOrigin
public class LibroController {
    @Autowired
    private LibroService libroService;
    @GetMapping("/findAll")
    public List<Libro> findAll(){
        return libroService.findAll();
    }
    @PostMapping("/save")
    public ResponseEntity<Libro> save(@Valid @RequestBody LibroDto libroDto) throws ResourceAlreadyExistsException {
        Libro libro = libroService.save(libroDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(libro);
    }
}
