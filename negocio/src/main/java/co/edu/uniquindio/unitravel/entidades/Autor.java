package co.edu.uniquindio.unitravel.entidades;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Autor implements Serializable {


    @Positive
    @Column(nullable = false)

    private int anioNacimiento;
    @ManyToMany(mappedBy = "autores")
    private List<Libro> libros;

}
