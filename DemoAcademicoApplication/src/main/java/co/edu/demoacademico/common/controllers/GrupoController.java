package co.edu.demoacademico.common.controllers;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import co.edu.demoacademico.grupos.GrupoCreateDTO;
import co.edu.demoacademico.grupos.GrupoDTO;
import co.edu.demoacademico.grupos.GrupoHandler;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/grupos")
public class GrupoController {

    private final GrupoHandler handler;

    public GrupoController(GrupoHandler handler) {
        this.handler = handler;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<GrupoDTO>> crear(@Valid @RequestBody GrupoCreateDTO in) {
        return ResponseBuilder.created("Grupo creado", handler.crear(in));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<GrupoDTO>>> listar(@ParameterObject Pageable pageable) {
        return ResponseBuilder.ok("OK", handler.listar(pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> eliminar(@PathVariable Long id) {
        handler.eliminar(id);
        return ResponseBuilder.ok("Grupo eliminado", null);
    }
}
