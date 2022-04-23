package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.dto.ComentarioDto;
import co.edu.uniquindio.unitravel.entidadespf.Reserva;
import co.edu.uniquindio.unitravel.entidadespf.Usuario;
import co.edu.uniquindio.unitravel.repositorio.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioTest {

    @Autowired // inicilizar la variable
    private UsuarioRepo usuarioRepo;

    @Test//metodo prueba
    public void registrar(){
        Usuario usuario= new Usuario("92555","pepito","pepe@gmail.com","123");
       Usuario usuarioGuardado = usuarioRepo.save(usuario);

        Assertions.assertNotNull(usuarioGuardado);
    }
    @Test
    public void eliminar(){
        Usuario usuario= new Usuario("92555","pepito","pepe@gmail.com","123");
        Usuario usuarioGuardado = usuarioRepo.save(usuario);

        usuarioRepo.delete(usuarioGuardado);

       //Optional<Usuario>  usuarioBuscado = usuarioRepo.findById("92555");

       //Assertions.assertNull(usuarioBuscado.get());

        Usuario  usuarioBuscado = usuarioRepo.findById("92555").orElse(null);

        Assertions.assertNull(usuarioBuscado);

    }
    @Test
    public void actualizar(){
        Usuario usuario= new Usuario("92555","pepito","pepe@gmail.com","123");
        Usuario usuarioGuardado = usuarioRepo.save(usuario);

        usuarioGuardado.setPassword("abc123");
        usuarioRepo.save(usuarioGuardado);

        Usuario  usuarioBuscado = usuarioRepo.findById("92555").orElse(null);
        Assertions.assertEquals("abc123",usuarioBuscado.getPassword());


    }

    @Test
    @Sql("classpath:dataset.sql ")
    public void listar(){

        List<Usuario> usuarios= usuarioRepo.findAll();

        System.out.println(usuarios);
    }

    @Test
    @Sql("classpath:dataset.sql ")
    public void listarUsuarioPorNombre(){

        List<Usuario> usuarios= usuarioRepo.buscarPorNombre("Pepito");

        usuarios.forEach(System.out::println);
    }


    @Test
    @Sql("classpath:dataset.sql ")
    public void comprobarDatosAutenticacion(){

        Optional<Usuario> usuario = usuarioRepo.comprobarAutenticacion("pepito@gmail.com","3434");
        System.out.println(usuario.orElse(null));
    }


    @Test
    @Sql("classpath:dataset.sql ")
    public void listarUsuariosPaginador(){

       Page<Usuario> usuarios= usuarioRepo.findAll(PageRequest.of(2,2));
        usuarios.get().forEach(System.out::println);


    }

    @Test
    @Sql("classpath:dataset.sql ")
    public void listarUsuariosSort(){

        List<Usuario> usuarios= usuarioRepo.findAll(Sort.by("nombre"));
        usuarios.forEach(System.out::println);
    }


    @Test
    @Sql("classpath:dataset.sql ")
    public void listarReservas(){

        List<Reserva> reservas= usuarioRepo.obtenerListareserva("pepe@gmail.com");
        reservas.forEach(System.out::println);
    }


    @Test
    @Sql("classpath:dataset.sql ")
    public void listarComentarios(){

        List<ComentarioDto> comentarios= usuarioRepo.obtenerComentarios();
        comentarios.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql ")
    public void listarReservasTotales(){

        List<Object[]> reservas= usuarioRepo.obtenerReservasTotales();
        reservas.forEach(c -> System.out.println(c[0]+" - " +c[1])   );
    }


    @Test
    @Sql("classpath:dataset.sql ")
    public void listarUsuarioTelefono(){

        List<String> usuarios= usuarioRepo.obtenerUsuariosTelefono();
        usuarios.forEach(System.out::println );
    }



}
