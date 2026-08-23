package co.edu.demoacademico.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "nombres")
public class NombreEntity {

    @Id
    @Column
    @SuppressWarnings("unused")
    String nombre;
}
