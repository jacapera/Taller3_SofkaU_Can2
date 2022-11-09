package com.sofka.can2;

import com.sofka.can2.modelo.BibliotecaPrincipal;
import com.sofka.can2.controlador.Controlador;
import com.sofka.can2.vista.Ventana;

/**
 * Esta es mi clase principal donde arranca mi aplicacion instancionado un
 * objeto de tipo controlador donde estara todo mi codigo de control
 *
 * @author Jesus Capera
 */
public class Main {

    public static void main(String[] args) {

        Controlador controlador = new Controlador(new Ventana(), new BibliotecaPrincipal());

        /**
         * Apartir de aca son lineas de prueba para mostrar resultados por
         * consola
         */
        //BibliotecaPrincipal lista = new BibliotecaPrincipal();
        //lista.presentar();
        //lista.filtrarPorAnio();
        //lista.filtrarPorGenero();
        //lista.ordenarPorDuracion();
        //lista.ordenarPorFecha();
        
    }
}
