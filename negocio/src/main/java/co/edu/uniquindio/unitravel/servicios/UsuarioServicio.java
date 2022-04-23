package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidadespf.Comentario;
import co.edu.uniquindio.unitravel.entidadespf.Hotel;
import co.edu.uniquindio.unitravel.entidadespf.Reserva;
import co.edu.uniquindio.unitravel.entidadespf.Usuario;

import java.util.List;

public interface UsuarioServicio {

    Usuario registrarUsuario(Usuario usuario) throws Exception;

    Usuario actualizarUsuario(Usuario usuario) throws  Exception;

    Usuario ObtenerUsuario(String codigo) ;

    void eliminarUsuario(String cedula) throws Exception;

    List<Usuario> listarUsuario()  ;

    Usuario validarLogin(String correo, String password) throws Exception;

    Comentario crearComentario(Comentario comentario) throws Exception;

    Reserva hacerReserva(Reserva reserva) throws  Exception;

    List<Hotel> buscarHotelesCiudad(String nombreCiudad);






}
