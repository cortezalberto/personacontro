package com.utn.controllerConRepo.controladores;

import com.utn.controllerConRepo.repositorios.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*") // Después explicamos los dominios cruzados

@RequestMapping(path = "api/personas")

public class PersonaControlador {
    @Autowired
    private PersonaRepositorio personaRepositorio;

    @GetMapping("subRuta")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(personaRepositorio.findAll());
        }
        catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error. Por favor intente luego\"}");
        }

    }


//------------------- otra ruta

// Atrapo el Id que viene el la Request, es como una variable
    @GetMapping("{id}")


    public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(personaRepositorio.findById(1L));
        }
        catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error. Por favor intente luego\"}");
        }

    }



}

