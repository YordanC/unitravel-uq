package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.dto.ReservaDto;
import co.edu.uniquindio.unitravel.repositorio.ReservaRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ReservaTest {

    @Autowired
    private ReservaRepo reservaRepo;



    @Test
    @Sql("classpath:dataset.sql")
    public void litarReservas(){

        LocalDate fecha = LocalDate.of(2022,10,1);
        List<ReservaDto> reservas = reservaRepo.obtenerReservas(1,fecha);
        reservas.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void litarPrecioReservas(){
    List<Object[]> reservas = reservaRepo.ObtenerTotalPorReserva("1223");
    reservas.forEach(r-> System.out.println(r[0]+","+r[1] +","+r[2]));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarReservasUsuario(){
        List<Object[]> reservas = reservaRepo.ObtenerReservaUsuario("1223");
        reservas.forEach(r-> System.out.println(r[0]+","+r[1]));
    }
}
