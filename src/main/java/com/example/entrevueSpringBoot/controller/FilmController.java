package com.example.entrevueSpringBoot.controller;

import com.example.entrevueSpringBoot.entity.Film;
import com.example.entrevueSpringBoot.repository.IFilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FilmController {

    @Autowired
    IFilmRepository filmRepository;

    @GetMapping("/films")
    public ResponseEntity<List<Film>> getAllFilms() {
        try {
            List<Film> list = filmRepository.findAll();

            if (list.isEmpty() || list.size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/films/{id}")
    @GetMapping("/api/film/{id}")
    public ResponseEntity<Film> getFilm(@PathVariable Long id) {
        Optional<Film> Film = filmRepository.findById(id);

        if (Film.isPresent()) {
            return new ResponseEntity<>(Film.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/api/film")
    public ResponseEntity<Film> saveFilm(@RequestBody Film Film) {
        try {
            return new ResponseEntity<>(filmRepository.save(Film), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/films")
    public ResponseEntity<Film> updateFilm(@RequestBody Film Film) {
        try {
            return new ResponseEntity<>(filmRepository.save(Film), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/films/{id}")
    public ResponseEntity<HttpStatus> deleteFilm(@PathVariable Long id) {
        try {
            Optional<Film> Film = filmRepository.findById(id);
            if (Film.isPresent()) {
                filmRepository.delete(Film.get());
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
