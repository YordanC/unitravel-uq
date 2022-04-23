package co.edu.uniquindio.unitravel.entidadespf;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
public class Caracteristica implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private String codigo;

    @Column(nullable = false, length = 200)
    private String nombre;

    @Column(nullable = false, length = 2)
    private String tipo;

    @ManyToMany(mappedBy = "caracteristicas")
    private List<Hotel> hoteles;

    @ManyToMany(mappedBy = "caracteristica")
    private List<Habitacion> habitaciones;

    public Caracteristica(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }
}
