package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidadespf.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidadespf.Ciudad;
import co.edu.uniquindio.unitravel.entidadespf.Vuelo;

public interface AdministradorServicio {
    AdministradorHotel registrarAdminHotel(AdministradorHotel admin) throws Exception;

    Vuelo crearVuelo(Vuelo vuelo) throws Exception;

    Ciudad crearCiudad(Ciudad ciudad) throws Exception;

}
