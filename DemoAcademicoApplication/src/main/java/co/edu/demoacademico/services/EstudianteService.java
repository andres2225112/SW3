package co.edu.demoacademico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.edu.demoacademico.exception.EmailAlreadyExistsException;
import co.edu.demoacademico.model.Estudiante;
import co.edu.demoacademico.repositories.EstudianteRepository;

// ============================
// CAPA DE LÓGICA (Service):
// Contiene las reglas de negocio
// ============================
@Service
public class EstudianteService {

    private final EstudianteRepository repository;

    public EstudianteService(EstudianteRepository repository) {
        this.repository = repository;
    }

    public Estudiante crear(Estudiante estudiante) {

        // ============================
        // ZONA DE LÓGICA DE NEGOCIO:
        // Regla: email único
        // ============================
        repository.findByEmail(estudiante.getEmail())
                .ifPresent(e -> {
                    throw new EmailAlreadyExistsException(estudiante.getEmail());
                });

        // ============================
        // ZONA DE ACCESO A LA BD:
        // Persistencia vía Repository
        // ============================
        return repository.save(estudiante);
    }

    public List<Estudiante> listar() {
        // ============================
        // ZONA DE ACCESO A LA BD:
        // Consulta vía Repository
        // ============================
        return repository.findAll();
    }

    public Optional<Estudiante> buscarPorEmail(String email) {
        // ============================
        // ZONA DE ACCESO A LA BD:
        // Consulta vía Repository
        // ============================
        return repository.findByEmail(email);
    }
}