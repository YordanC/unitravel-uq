package co.edu.uniquindio.unitravel.repositorio;

import co.edu.uniquindio.unitravel.dto.VuelosCiudadDto;
import co.edu.uniquindio.unitravel.entidadespf.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VueloRepo extends JpaRepository<Vuelo,String> {

  @Query("select v from Vuelo v where v.ciudadOrigen.nombre= :nombreCiudad")
List<Vuelo> obtenerVuelos(String nombreCiudad);


  /**
   * 5. Cree un consulta que permita determinar cuántos vuelos salen de cada ciudad. Devuelva un DTO
   * con el nombre de la ciudad, y número de
   * registros.
   */

  @Query("select new co.edu.uniquindio.unitravel.dto.VuelosCiudadDto( v.ciudadOrigen.nombre, count(v))  from Vuelo v group by v.ciudadOrigen")
  List<VuelosCiudadDto> contarVuelosPorCIudad();

}
