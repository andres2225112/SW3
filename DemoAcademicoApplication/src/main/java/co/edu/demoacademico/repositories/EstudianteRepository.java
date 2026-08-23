package co.edu.demoacademico.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.demoacademico.model.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    // ============================
    // ZONA DE ACCESO A LA BD (JPA)
    // ============================
    Optional<Estudiante> findByEmail(String email);
}
