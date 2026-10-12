package co.edu.demoacademico.estudiantes.port;

import co.edu.demoacademico.estudiantes.Estudiante;

public interface EstudianteQueryPort {
    Estudiante obtenerPorId(Long id);
}
