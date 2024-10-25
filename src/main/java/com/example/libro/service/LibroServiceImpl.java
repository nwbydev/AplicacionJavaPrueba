package com.example.libro.service;

import com.example.libro.dto.LibroDto;
import com.example.libro.entity.Autor;
import com.example.libro.entity.Libro;
import com.example.libro.exception.ResourceAlreadyExistsException;
import com.example.libro.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService{
    @Autowired
    private LibroRepository libroRepository;
    @Override
    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    @Override
    public Libro save(LibroDto libroDto) throws ResourceAlreadyExistsException {
        Optional<Libro> libroBd = libroRepository.findByName(libroDto.getName());
        if (!libroBd.isPresent()) {
            Autor autor = Autor.builder()
                    .id(libroDto.getIdAutor())
                    .build();
            Libro libro = Libro.builder()
                    .name(libroDto.getName())
                    .fecha(libroDto.getFecha())
                    .autor(autor)
                    .build();
            return libroRepository.save(libro);
        }else{
            throw new ResourceAlreadyExistsException("Ya existe el nombre de ese libro");
        }
    }
}
