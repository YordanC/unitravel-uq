package co.edu.uniquindio.unitravel.dto;

import co.edu.uniquindio.unitravel.entidadespf.Comentario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ComentarioDto {

    private String correoUsuario;
    private Comentario comentario;
}
