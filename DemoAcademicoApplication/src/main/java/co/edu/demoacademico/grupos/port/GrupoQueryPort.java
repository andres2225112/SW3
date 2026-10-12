package co.edu.demoacademico.grupos.port;

import co.edu.demoacademico.grupos.Grupo;

public interface GrupoQueryPort {
    Grupo obtenerPorId(Long id);
}
