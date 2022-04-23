package co.edu.uniquindio.unitravel.entidadespf;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Hotel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false,length = 200)
    private String nombre;

    @Column(nullable = false,length = 100)
    private  String direccion;

    @Column(nullable = false,length = 50)
    private String telefono;

    @Positive
    @Column(nullable = false)
    private Integer numEstrellas;

    @ElementCollection
    private List<String> fotos;

    @ManyToMany
    @JoinColumn(nullable = false)
    private Ciudad ciudad;

    @ManyToMany
    @JoinColumn(nullable = false)
    private AdministradorHotel administradorHotel;

    @OneToMany(mappedBy = "hotel")
    @ToString.Exclude
    private List<Habitacion> habitaciones;

    @ManyToMany
    @ToString.Exclude
    private List<Caracteristica> caracteristicas;

    @OneToMany(mappedBy = "hotel")
    @ToString.Exclude
    private List<Comentario> comentarios;

    public Hotel(Integer codigo, String nombre, String direccion, String telefono, Integer numEstrellas, List<String> fotos, Ciudad ciudad, AdministradorHotel administradorHotel, List<Habitacion> habitaciones, List<Caracteristica> caracteristicas, List<Comentario> comentarios) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.numEstrellas = numEstrellas;
        this.fotos = fotos;
        this.ciudad = ciudad;
        this.administradorHotel = administradorHotel;
        this.habitaciones = habitaciones;
        this.caracteristicas = caracteristicas;
        this.comentarios = comentarios;
    }
}
