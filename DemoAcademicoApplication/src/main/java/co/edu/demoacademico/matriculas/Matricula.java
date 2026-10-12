package co.edu.demoacademico.matriculas;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import co.edu.demoacademico.estudiantes.Estudiante;
import co.edu.demoacademico.grupos.Grupo;

@Entity
@Table(name = "matricula", uniqueConstraints = {
        @UniqueConstraint(name = "uk_matricula_estudiante_grupo", columnNames = {"estudiante_id", "grupo_id"})
})
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Estudiante ya existe del Lab 02
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="estudiante_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_matricula_estudiante"))
    private Estudiante estudiante;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="grupo_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_matricula_grupo"))
    private Grupo grupo;

    @Column(name = "fecha_registro", nullable = false)
    private Instant fechaRegistro = Instant.now();

    public Matricula() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Estudiante getEstudiante() { return estudiante; }
    public void setEstudiante(Estudiante estudiante) { this.estudiante = estudiante; }

    public Grupo getGrupo() { return grupo; }
    public void setGrupo(Grupo grupo) { this.grupo = grupo; }

    public Instant getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(Instant fechaRegistro) { this.fechaRegistro = fechaRegistro; }
}
