package co.edu.uniquindio.unitravel.repositorio;

import co.edu.uniquindio.unitravel.dto.ReservaDto;
import co.edu.uniquindio.unitravel.entidadespf.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaRepo extends JpaRepository<Reserva,Integer> {

    @Query("select new co.edu.uniquindio.unitravel.dto.ReservaDto(r.usuario.nombre, r.fechaReserva,h.habitacion) from Reserva r join r.habitaciones h where h.habitacion.hotel.codigo = :idHotel and r.fechaInicio< :fecha")
    List<ReservaDto> obtenerReservas(Integer idHotel, LocalDate fecha);

    //ejercicios  propuestos

    /**
     * 1. Cree una consulta que permita determinar el número de reservas que tiene un hotel específico cuya
     * fecha de inicio de reserva aún no haya pasado.
     *
     */
    @Query("select count(r) from Reserva r join r.habitaciones h where h.habitacion.hotel.codigo = :codigoHotel and r.fechaInicio > CURRENT_DATE ")

    int obtenerNumeroReservas(Integer codigoHotel);

    /**
     * 6. Cree una consulta que calcule el valor total que ha gastado un usuario en reservas. Total por
     * reserva o total por todas las reservas.
     */
    @Query("select r.codigo,(select sum(rh.precio) from ReservaHabitacion  rh where rh.reserva = group group by r ),(select sum(rs.precio) from ReservaSilla  rs where rs.reserva = group group by r )  from Reserva r where r.usuario.codigo =:codigoUsuario")
    List<Object[]> ObtenerTotalPorReserva(String codigoUsuario);
    /**
     * 7. Cree una consulta que devuelva una lista de reservas y el detalle de cada reserva de un cliente
     * dado su código.
     */
    @Query("select r from Reserva r.habitaciones h where r.usuario.codigo = :codigoUsuario")
    List<Object[]> ObtenerReservaUsuario(String codigoUsuario);

}
