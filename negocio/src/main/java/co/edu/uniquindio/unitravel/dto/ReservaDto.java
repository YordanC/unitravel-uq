package co.edu.uniquindio.unitravel.dto;

import co.edu.uniquindio.unitravel.entidadespf.Habitacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ReservaDto {

    private String nombreUsuario;
    private LocalDateTime fehaReserva;
    private Habitacion habitacion;
}
