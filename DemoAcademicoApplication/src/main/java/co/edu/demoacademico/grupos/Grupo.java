package co.edu.demoacademico.grupos;

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

import co.edu.demoacademico.asignaturas.Asignatura;

@Entity
@Table(name = "grupo", uniqueConstraints = {
        @UniqueConstraint(name = "uk_grupo_codigo", columnNames = {"codigo_grupo"})
})
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="codigo_grupo", nullable = false, length = 30)
    private String codigoGrupo;

    @Column(nullable = false)
    private Integer cupoMax;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "asignatura_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_grupo_asignatura"))
    private Asignatura asignatura;

    public Grupo() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCodigoGrupo() { return codigoGrupo; }
    public void setCodigoGrupo(String codigoGrupo) { this.codigoGrupo = codigoGrupo; }

    public Integer getCupoMax() { return cupoMax; }
    public void setCupoMax(Integer cupoMax) { this.cupoMax = cupoMax; }

    public Asignatura getAsignatura() { return asignatura; }
    public void setAsignatura(Asignatura asignatura) { this.asignatura = asignatura; }
}