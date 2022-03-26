package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public class Persona implements Serializable {
    @Id //para que sea llalve primaria es cedula
    @EqualsAndHashCode.Include
    @Column(length = 10)
    private String cedula;
    @Column(length = 200, nullable = false)

    private String nombreCompleto;

}
