package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidadespf.Hotel;
import co.edu.uniquindio.unitravel.repositorio.CiudadRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CiudadTest {


    @Autowired
    private CiudadRepo ciudadRepo;



    @Test
    @Sql("classpath:dataset.sql ")

    public void obtenerListaHoteles(){

        List<Hotel> lista = ciudadRepo.obtenerHotelesIn("Armenia");

        lista.forEach(System.out::println);

        Assertions.assertEquals(2,lista.size());
    }

}
