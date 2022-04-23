package co.edu.uniquindio.unitravel.entidadespf;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Habitacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer numero;

    @Positive
    @Column(nullable = false)
    private Integer capacidad;

    @ManyToOne
    private Hotel hotel;

    @ElementCollection
    private List<String> fotos;

    @ManyToMany
    private List<Caracteristica> caracteristicas;

    @OneToMany(mappedBy = "habitacion")
    private List<ReservaHabitacion> reserva;

    public Habitacion(Integer numero, Integer capacidad, Hotel hotel, List<String> fotos, List<Caracteristica> caracteristicas, List<ReservaHabitacion> reserva) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.hotel = hotel;
        this.fotos = fotos;
        this.caracteristicas = caracteristicas;
        this.reserva = reserva;
    }
}
