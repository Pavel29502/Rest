package com.example.demo2.service;

// Сервис для понимания как работает Сваггер!

// http://localhost:8080/swagger-ui/index.html#/st-service/findStudents  - так вызывается свагер


import com.example.demo2.model.Students;
import com.example.demo2.repository.StudentsRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Tag(name = "Student Service", description = "Service to find Students")
@RestController
@RequestMapping("/students1")
public class StService {

    @Autowired
    private StudentsRepository studentsRepository;


    @GetMapping
    public List<Students> findStudents() {
        return studentsRepository.findAll();
    }

            @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Find the student",
                        content = { @Content(mediaType = "application/json",
                                schema = @Schema(implementation = Students.class)) }),
                @ApiResponse(responseCode = "400", description = "Invalid ID supplied",
                        content = @Content),
                @ApiResponse(responseCode = "404", description = "Student not found",
                        content = @Content) })

    @GetMapping(value = "/{id}")
    public Students findStudent(@PathVariable long id) {
        return studentsRepository.findById(id).get();
    }

    @PostMapping("/grooup")
    public ResponseEntity<Students> createGrooup(@RequestBody Students students) {
        studentsRepository.save(students);
        return new ResponseEntity<>(students, HttpStatus.CREATED);
    }

    @GetMapping(value = "/grooup/{id}")
    public ResponseEntity<Students> findGrooup(@PathVariable long id) {
        Students grooup = studentsRepository.findById(id).get();
        return new ResponseEntity<>(grooup, HttpStatus.OK);
    }
}

