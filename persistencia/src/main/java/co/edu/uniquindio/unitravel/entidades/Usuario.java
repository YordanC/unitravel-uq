package co.edu.uniquindio.unitravel.entidades;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@Getter
@Setter

public class Usuario extends Persona implements Serializable {


    @Column(length = 200, nullable = false,unique = true)
    @Email
    private String email;
    @ElementCollection
    private Map<String, String> telefono;
    @ManyToOne
    private Ciudad ciudad;

    @OneToMany(mappedBy = "persona")
    private List<Prestamo> prestamos;
    public Usuario(String cedula, String nombre, String email ) {
        super(cedula, nombre);
        this.email = email;
    }




}