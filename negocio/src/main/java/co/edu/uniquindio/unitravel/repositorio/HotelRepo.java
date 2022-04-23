package co.edu.uniquindio.unitravel.repositorio;

import co.edu.uniquindio.unitravel.entidadespf.Hotel;
import co.edu.uniquindio.unitravel.entidadespf.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepo extends JpaRepository<Hotel,Integer> {

    @Query("select h from Hotel h where h.numEstrellas= :estrellas")//selecionar todos los hoteles ondeo el numero de estrellas es 5
    List<Hotel> obtenerHoteles(int estrellas);

    //lista de inferencia

    List<Hotel> findAllByNumEstrellas(int estrellas);

    //consultas
    @Query("select h.ciudad.nombre from Hotel h where h.codigo = :codigoH" )
    String obtenerNombreCiudad(Integer codigoH);


    @Query("select h from Hotel h where h.ciudad.nombre= :nombreCiudad")
    List<Hotel> obtenerHoteles(String nombreCiudad);
/**
 * 2. Cree una consulta que permita contar el número de hoteles que hay por cada ciudad. Use GROUP
 * BY.
 */
    @Query("select h.ciudad.nombre, count(h) from Hotel  h group by h.ciudad")
    List<Object[]> contarHotelesPorCiudad();

    /**
     * 3. Cree una consulta que permita determinar qué hoteles no tienen comentarios. Use IS EMPTY.
     */
    @Query("select h from Hotel h where h.comentarios is empty ")
    List<Hotel> obtenerHotelesSinComentarios();

    /**
     * 4. Cree una consulta que devuelva una lista con todos los hoteles que contengan en su nombre una
     */
    @Query("select h from Hotel h where h.nombre like concat('%',:nombre ,'%') ")
    List<Hotel> obterhotelesNombre(String nombre);
}
