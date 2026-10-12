package co.edu.demoacademico.programas;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramaRepository extends JpaRepository<Programa, Long> {
    boolean existsByCodigo(String codigo);
}
