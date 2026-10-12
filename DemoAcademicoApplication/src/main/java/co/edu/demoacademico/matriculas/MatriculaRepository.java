package co.edu.demoacademico.matriculas;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    boolean existsByEstudianteIdAndGrupoId(Long estudianteId, Long grupoId);
    long countByGrupoId(Long grupoId);
}
