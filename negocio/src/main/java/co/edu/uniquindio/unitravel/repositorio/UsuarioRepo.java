package co.edu.uniquindio.unitravel.repositorio;

import co.edu.uniquindio.unitravel.dto.ComentarioDto;
import co.edu.uniquindio.unitravel.entidadespf.Reserva;
import co.edu.uniquindio.unitravel.entidadespf.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario,String> {

    List<Usuario> findAllByNombre(String nombre);

    @Query("select u from Usuario u where u.nombre = :nombre")
    List<Usuario> buscarPorNombre(String nombre);


    @Query("select u from Usuario u where u.correo = :email and u.password= :password")
    Optional<Usuario> comprobarAutenticacion(String email,String password);

    Optional<Usuario> findByPassword(String email, String password);
    Optional<Usuario> findByCorreoAndPassword(String email, String password);
    Optional<Usuario> findByCorreo(String correo);
    Page<UsuarioRepo> findAllBy(Pageable pageable);


    @Query("select r from Usuario u,IN (u.reservas) r where u.correo = :email")
    List<Reserva> obtenerListareserva(String email);

    @Query("select new co.edu.uniquindio.unitravel.dto.ComentarioDto( u.correo, c )from Usuario u left join u.comentarios c")
    List<ComentarioDto> obtenerComentarios();

    @Query("select u, r from  Usuario u left join u.reservas r")
    List<Object[]>obtenerReservasTotales();

    @Query("select distinct t from usuario u join u.telefono t ")
    List<String> obtenerUsuariosTelefono();

}
