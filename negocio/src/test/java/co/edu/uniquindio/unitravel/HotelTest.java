package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidadespf.Hotel;
import co.edu.uniquindio.unitravel.entidadespf.Usuario;
import co.edu.uniquindio.unitravel.repositorio.HotelRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HotelTest {

    @Autowired
    private HotelRepo hotelRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void buscar(){
        Hotel hotel = hotelRepo.findById(1).orElse(null);
        System.out.println(hotel);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void buscarHotelesEstrellas(){
        List<Hotel> hoteles = hotelRepo.obtenerHoteles(5);
        //System.out.println(hoteles);
       // hoteles.forEach(System.out::println);
        for (Hotel h: hoteles) {
            System.out.println(h);

        }
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){
        List<Hotel> lista = hotelRepo.findAll();
        System.out.println(lista);


    }

    @Test
    @Sql("classpath:dataset.sql ")
    public void listarHotelesSort(){

        List<Hotel> hoteles= hotelRepo.findAll(Sort.by(Sort.Direction.DESC,"numEstrellas"));
        hoteles.forEach(System.out::println);
    }


    @Test
    @Sql("classpath:dataset.sql ")

    public void obtenerNombreCiudad(){

        String nombreCiudad= hotelRepo.obtenerNombreCiudad(3);

        Assertions.assertEquals("Bogotá",nombreCiudad);

    }

    @Test
    @Sql("classpath:dataset.sql ")

    public void obtenerListaHoteles(){

      List<Hotel> lista = hotelRepo.obtenerHoteles("Armenia");

        lista.forEach(System.out::println);

        Assertions.assertEquals(2,lista.size());
    }


}
