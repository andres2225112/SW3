package co.edu.demoacademico.asignaturas;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import co.edu.demoacademico.programas.Programa;

import co.edu.demoacademico.programas.ProgramaService;

@Component
public class AsignaturaHandler {

    private final AsignaturaService asignaturaService;
    private final ProgramaService programaService;

    public AsignaturaHandler(AsignaturaService asignaturaService, ProgramaService programaService) {
        this.asignaturaService = asignaturaService;
        this.programaService = programaService;
    }

    public AsignaturaDTO crear(AsignaturaCreateDTO in) {
        Programa programa = programaService.obtenerPorId(in.getProgramaId());

        Asignatura a = new Asignatura();
        a.setCodigo(in.getCodigo());
        a.setNombre(in.getNombre());
        a.setCreditos(in.getCreditos());
        a.setPrograma(programa);

        return toDto(asignaturaService.crear(a));
    }

    public List<AsignaturaDTO> listar() {
        return asignaturaService.listar().stream().map(this::toDto).collect(Collectors.toList());
    }

    public void eliminar(Long id) {
        asignaturaService.eliminar(id);
    }

    private AsignaturaDTO toDto(Asignatura a) {
        AsignaturaDTO dto = new AsignaturaDTO();
        dto.setId(a.getId());
        dto.setCodigo(a.getCodigo());
        dto.setNombre(a.getNombre());
        dto.setCreditos(a.getCreditos());
        dto.setProgramaId(a.getPrograma().getId());
        dto.setProgramaNombre(a.getPrograma().getNombre());
        return dto;
    }
}
