package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidadespf.Hotel;

public interface AdministradorHotelServicio {

    Hotel crearHotel(Hotel hotel) throws Exception;
    void eliminarHotel(Integer codigo) throws  Exception;
}
