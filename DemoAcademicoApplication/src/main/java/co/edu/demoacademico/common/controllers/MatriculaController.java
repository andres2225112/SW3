package co.edu.demoacademico.common.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.demoacademico.common.api.ApiResponse;
import co.edu.demoacademico.common.api.ResponseBuilder;
import co.edu.demoacademico.matriculas.MatriculaCreateDTO;
import co.edu.demoacademico.matriculas.MatriculaDTO;
import co.edu.demoacademico.matriculas.MatriculaHandler;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    private final MatriculaHandler handler;

    public MatriculaController(MatriculaHandler handler) {
        this.handler = handler;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<MatriculaDTO>> matricular(@Valid @RequestBody MatriculaCreateDTO in) {
        return ResponseBuilder.created("Matrícula registrada", handler.matricular(in));
    }
}
