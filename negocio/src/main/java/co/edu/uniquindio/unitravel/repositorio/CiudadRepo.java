package co.edu.uniquindio.unitravel.repositorio;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidadespf.Hotel;
import co.edu.uniquindio.unitravel.entidadespf.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CiudadRepo extends JpaRepository<Ciudad,Integer> {



    @Query(" select c.hoteles from Ciudad c where c.nombre = :nombreCiudad")

            List<Hotel> obtenerHoteles(String nombreCiudad);

    @Query(" select h from Ciudad c, IN (c.hoteles) h where c.nombre = :nombreCiudad")

            List<Hotel> obtenerHotelesIn(String nombreCiudad);



    @Query(" select v from Ciudad c join c.vuelos v where v.nombre = :nombreCiudad")

    List<Vuelo> obtenerVuelos(String nombreCiudad);
}


