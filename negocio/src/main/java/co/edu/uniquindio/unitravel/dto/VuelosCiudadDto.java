package co.edu.uniquindio.unitravel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class VuelosCiudadDto {
    private String nombreciudad;
    private long numeroVuelos;
}
