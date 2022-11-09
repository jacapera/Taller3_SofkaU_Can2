package com.sofka.can2.controlador;

import com.sofka.can2.modelo.Cancion;
import java.util.Comparator;

/**
 * esta clase se implementa para utilizar un comparator y asi ordenar las
 * canciones de menor a mayor por el valor de duración
 *
 * @author Jesus Capera
 */
public class OrdenarPorDuracion implements Comparator<Cancion> {

    @Override
    public int compare(Cancion cancion1, Cancion cancion2) {
        int respuesta = 0;
        if (cancion1.getDuracion() > cancion2.getDuracion()) {
            respuesta = 1;
        } else if (cancion1.getDuracion() < cancion2.getDuracion()) {
            respuesta = -1;
        } else {
            respuesta = 0;
        }
        return respuesta;
    }
}
