package co.edu.uniquindio.unitravel.entidadespf;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Vuelo implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    @Column(nullable = false,length = 100)
    private String aerolinea;

    @Column(nullable = false,length = 50)
    private String estado;

    @ManyToOne
    private Ciudad ciudadOrigen;

    @ManyToOne
    private Ciudad ciudadDestino;

    @ManyToMany
    @ToString.Exclude
    private List<Silla> sillas;

    public Vuelo(String codigo, String aerolinea, String estado, Ciudad ciudadOrigen, Ciudad ciudadDestino) {
        this.codigo = codigo;
        this.aerolinea = aerolinea;
        this.estado = estado;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
    }
}
