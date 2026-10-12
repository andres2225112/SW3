package co.edu.demoacademico.matriculas;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.demoacademico.common.exception.BusinessException;
import co.edu.demoacademico.estudiantes.Estudiante;
import co.edu.demoacademico.grupos.Grupo;

import co.edu.demoacademico.estudiantes.port.EstudianteQueryPort;
import co.edu.demoacademico.grupos.port.GrupoQueryPort;


@Service
@Transactional
public class MatriculaServiceImpl implements MatriculaService {

    private final EstudianteQueryPort estudiantePort;
    private final GrupoQueryPort grupoPort;
    private final MatriculaRepository matriculaRepo;

    public MatriculaServiceImpl(EstudianteQueryPort estudiantePort,
                                GrupoQueryPort grupoPort,
                                MatriculaRepository matriculaRepo) {
        this.estudiantePort = estudiantePort;
        this.grupoPort = grupoPort;
        this.matriculaRepo = matriculaRepo;
    }

    @Override
    public Matricula matricular(Long estudianteId, Long grupoId) {

        // existencia se valida por contrato público (y lanza NotFound desde el módulo dueño)
        Estudiante estudiante = estudiantePort.obtenerPorId(estudianteId);
        Grupo grupo = grupoPort.obtenerPorId(grupoId);

        // no duplicado
        if (matriculaRepo.existsByEstudianteIdAndGrupoId(estudianteId, grupoId)) {
            throw new BusinessException("El estudiante ya está matriculado en ese grupo");
        }

        // cupo
        long matriculados = matriculaRepo.countByGrupoId(grupoId);
        if (matriculados >= grupo.getCupoMax()) {
            throw new BusinessException("El grupo no tiene cupo disponible");
        }

        Matricula m = new Matricula();
        m.setEstudiante(estudiante);
        m.setGrupo(grupo);
        return matriculaRepo.save(m);
    }
}
