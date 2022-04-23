package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidadespf.Comentario;
import co.edu.uniquindio.unitravel.entidadespf.Hotel;
import co.edu.uniquindio.unitravel.entidadespf.Reserva;
import co.edu.uniquindio.unitravel.entidadespf.Usuario;
import co.edu.uniquindio.unitravel.repositorio.UsuarioRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public  class UsuarioServicioImpl implements UsuarioServicio {

    private UsuarioRepo usuarioRepo;

    public UsuarioServicioImpl(UsuarioRepo usuarioRepo){

            this.usuarioRepo= usuarioRepo;

    }


    @Override
    public Usuario registrarUsuario(Usuario usuario) throws Exception {
        Usuario buscado = ObtenerUsuario(usuario.getCodigo());

        if(buscado!= null){
            throw new Exception("El codigo del usuario ya esta registrado");
        }

        Usuario usuarioEmail = ObtenerUsuario(usuario.getCorreo());

        if(usuarioEmail!= null){
            throw new Exception("El correo del usuario ya esta registrado");
        }

        return usuarioRepo.save(usuario);
    }
    public  Usuario buscarPorEmail(String email){
        return usuarioRepo.findByCorreo(email).orElse(null);
    }
    @Override
    public Usuario actualizarUsuario(Usuario usuario) throws Exception{
        Usuario buscado= ObtenerUsuario(usuario.getCodigo());
        if(usuario!=null){
            throw new Exception(" el usuario no esxiste");
        }
        return usuarioRepo.save(usuario);
    }

    @Override
    public Usuario ObtenerUsuario(String codigo) {

        return usuarioRepo.findById(codigo).orElse(null);
    }




    @Override
    public void eliminarUsuario(String cedula) throws  Exception{
        Usuario usuario= ObtenerUsuario(cedula);
        if(usuario!=null){
            throw new Exception(" el usuario no esxiste");
        }
         usuarioRepo.delete(usuario);
    }

    @Override
    public List<Usuario> listarUsuario() {
        return usuarioRepo.findAll();
    }

    @Override
    public Usuario validarLogin(String correo, String password) throws Exception {
    Optional<Usuario> usuario = usuarioRepo.findByCorreoAndPassword(correo,password);

        if (usuario.isEmpty()){
            throw new Exception("los datos de autenticacion son incorrectos");
        }

        return usuario.get();
    }

    @Override
    public Comentario crearComentario(Comentario comentario) throws Exception {
        return null;
    }

    @Override
    public Reserva hacerReserva(Reserva reserva) throws Exception {
        return null;
    }

    @Override
    public List<Hotel> buscarHotelesCiudad(String nombreCiudad) {
        return null;
    }
}
