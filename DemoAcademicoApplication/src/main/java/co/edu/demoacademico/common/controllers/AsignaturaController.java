package co.edu.demoacademico.common.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.demoacademico.common.api.ApiResponse;
import co.edu.demoacademico.common.api.ResponseBuilder;
import co.edu.demoacademico.asignaturas.AsignaturaCreateDTO;
import co.edu.demoacademico.asignaturas.AsignaturaDTO;
import co.edu.demoacademico.asignaturas.AsignaturaHandler;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaController {

    private final AsignaturaHandler handler;

    public AsignaturaController(AsignaturaHandler handler) {
        this.handler = handler;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<AsignaturaDTO>> crear(@Valid @RequestBody AsignaturaCreateDTO in) {
        return ResponseBuilder.created("Asignatura creada", handler.crear(in));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<AsignaturaDTO>>> listar() {
        return ResponseBuilder.ok("OK", handler.listar());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> eliminar(@PathVariable Long id) {
        handler.eliminar(id);
        return ResponseBuilder.ok("Asignatura eliminada", null);
    }
}
