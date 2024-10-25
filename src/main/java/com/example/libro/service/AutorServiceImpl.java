package com.example.libro.service;

import com.example.libro.dto.AutorDto;
import com.example.libro.entity.Autor;
import com.example.libro.exception.ResourceAlreadyExistsException;
import com.example.libro.exception.ResourceNotFoundException;
import com.example.libro.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorServiceImpl implements AutorService{
    @Autowired
    private AutorRepository autorRepository;
    @Override
    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    @Override
    public Autor save(AutorDto autorDto) throws ResourceAlreadyExistsException{
        Optional<Autor> autorBd = autorRepository.findByName(autorDto.getName());
        if(!autorBd.isPresent()) {
            Autor autor = Autor.builder()
                    .name(autorDto.getName())
                    .lastName(autorDto.getLastName())
                    .phone(autorDto.getPhone())
                    .build();
            return autorRepository.save(autor);
        }else{
            throw new ResourceAlreadyExistsException("Ya existe ese nombre de autor.");
        }
    }

    @Override
    public Autor findById(Long id) {
        return autorRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        //return categoryRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
}
