package co.edu.demoacademico.common.controllers;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.demoacademico.common.api.ApiResponse;
import co.edu.demoacademico.common.api.ResponseBuilder;
import co.edu.demoacademico.programas.ProgramaCreateDTO;
import co.edu.demoacademico.programas.ProgramaDTO;
import co.edu.demoacademico.programas.ProgramaUpdateDTO;
import co.edu.demoacademico.programas.ProgramaHandler;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/programas")
public class ProgramaController {

    private final ProgramaHandler handler;

    public ProgramaController(ProgramaHandler handler) {
        this.handler = handler;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProgramaDTO>> crear(@Valid @RequestBody ProgramaCreateDTO in) {
        return ResponseBuilder.created("Programa creado", handler.crear(in));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProgramaDTO>> obtener(@PathVariable Long id) {
        return ResponseBuilder.ok("OK", handler.obtener(id));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<ProgramaDTO>>> listar(@ParameterObject Pageable pageable) {
        return ResponseBuilder.ok("OK", handler.listar(pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProgramaDTO>> actualizar(@PathVariable Long id, @Valid @RequestBody ProgramaUpdateDTO in) {
        return ResponseBuilder.ok("Programa actualizado", handler.actualizar(id, in));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> eliminar(@PathVariable Long id) {
        handler.eliminar(id);
        return ResponseBuilder.ok("Programa eliminado", null);
    }
}
