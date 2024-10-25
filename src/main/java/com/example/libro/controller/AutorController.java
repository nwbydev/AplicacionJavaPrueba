package com.example.libro.controller;

import com.example.libro.dto.AutorDto;
import com.example.libro.entity.Autor;
import com.example.libro.exception.ResourceAlreadyExistsException;
import com.example.libro.service.AutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
@CrossOrigin
public class AutorController {
    @Autowired
    private AutorService autorService;
    @GetMapping("/findAll")
    public List<Autor> findAll(){
        return autorService.findAll();
    }
    @PostMapping("/save")
    public ResponseEntity<Autor> save(@Valid  @RequestBody AutorDto autorDto) throws ResourceAlreadyExistsException {
        Autor autor = autorService.save(autorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(autor);
    }
    @GetMapping("/findById/{id}")
    public Autor findById(@PathVariable Long id){
        return autorService.findById(id);
    }
}
