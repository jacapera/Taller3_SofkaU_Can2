package com.sofka.can2.modelo;

import com.sofka.can2.controlador.OrdenarPorDuracion;
import com.sofka.can2.controlador.OrdenarPorFecha;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Esta clase se usara como base de datos de mi aplicacion de canciones
 * @author Jesus Capera
 */
public class BibliotecaPrincipal {

    private Map<Integer, Cancion> listaCanciones = new HashMap<>();

    public BibliotecaPrincipal() {
        listaCanciones.put(1, new Cancion(1, "Be Yourself", 2005, 4.38, "Rock", "Out of Exile",
                "Letra inspirada por acontecimientos de la vida personal del cantante Chris Cornell"));
        listaCanciones.put(2, new Cancion(2, "Fireflies", 2009, 3.48, "Dance/Electronica", "Ocean Eyes",
                "Basada en una linea de sintetizador 'bleepy' e incluye letras sobre el insomnio, luciernagas y el verano"));
        listaCanciones.put(3, new Cancion(3, "I Want to Break Free", 1984, 3.43, "Rock", "The Works",
                "Ampliamente conocida por su video musical, donde todos los miembros de la banda se vistieron de señoras amas de casa"));
        listaCanciones.put(4, new Cancion(4, "Bohemian Rhapsody", 1975, 5.54, "Rock", "A Night at the Opera",
                "Tiene una introducción a capela, una balada, un solo de guitarra, un segmento operistico, una sección de rock"));
        listaCanciones.put(5, new Cancion(5, "Yellow", 2000, 4.26, "Alternativa/independiente", "Parachutes",
                "Inspirada cuando la banda tomaba un descanso en la noche y ven hacia el cielo estrellado"));
        listaCanciones.put(6, new Cancion(6, "In My Place", 2002, 3.48, "Alternativa/independiente", "A Rush Of Blood to the Head",
                "Habla de como uno es arrojado al mundo, como obtienes tu posición, en la manera que te ven y que uno debe aceptarlo"));
        listaCanciones.put(7, new Cancion(7, "I Gotta Feeling", 2009, 4.49, "Pop", "The E.N.D.",
                "La letra se trata principalmente de fiesta y de disfrutar, revela la banda al momento de escribir la canción se sentían asi"));
        listaCanciones.put(8, new Cancion(8, "Tira Para Arriba", 1984, 7.07, "Rock en Español", "Tengo que Parar",
                "Una de las canciones mas exitosas de la banda Miguel Mateus/ZAS, y un verdadero himno del rock en español de los años 1980"));
        listaCanciones.put(9, new Cancion(9, "Callaita", 2019, 4.10, "Urbano Latino", "Callaita",
                "En ella, Bad Bunny habla de una chica que, a pesar de parecer mansa y tranquila, vive una vida libre de inhibiciones y vacilaciones"));
        listaCanciones.put(10, new Cancion(10, "Ella es mi todo", 2005, 4.43, "Vallenato", "Unico",
                "Creada por Kaleth cuando vivía en Cartagena y se encontraba 'tragao' de María Camila Theran Bustamante, también conocida como 'Mary' "));
        listaCanciones.put(11, new Cancion(11, "Chale", 2022, 2.50, "Regional Mexicana", "La Historia Debe Continuar",
                "La canción de Edén Muñoz es de desamor pues habla de una mujer que lo abandonó y que eso no se vale"));
        listaCanciones.put(12, new Cancion(12, "Hokage Funeral(Naruto Original Soundtrack)", 2021, 2.35, "Anime", "Naruto Piano Collection Vol.1",
                "Melodia que hace parte del anime Naruto, en sus inicios se trata del tercer Hokage 'Hiruzen Sarutobi' y su nieto 'Konohamaru Sarutobi' "));

    }

    public List<Cancion> getBibliotecaPrincipal() {
        return new ArrayList<>(this.listaCanciones.values());
    }

    /**
     * métodos de prueba para imprimir por consola
     */
    public void presentar(){
        System.out.println("BIBLIOTECA DE CANCIONES\n---------------------------");
        for(Map.Entry<Integer, Cancion> items : listaCanciones.entrySet()){
            Cancion cancion = items.getValue();
            System.out.println(cancion.getIdentificador() + " " + "Título: " + cancion.getTitulo() + "\nGenero: " +
                    cancion.getGenero() + "\nDuración: " + cancion.getDuracion() + "\nAño: " + cancion.getFecha() +
                    "\nAlbum: " + cancion.getCaratula() + "\n Descripcion: " + cancion.getDescripcion() + "\n-----------------------");
        }
    }

    public void ordenarPorDuracion() {
        List<Cancion> lista = new ArrayList<>(this.listaCanciones.values());
        Collections.sort(lista, new OrdenarPorDuracion());
        System.out.println("BIBLIOTECA DE CANCIONES POR DURACION\n-------------------------");
        for (Cancion cancion : lista) {
            System.out.println(cancion.getIdentificador() + " " + "Titulo: " + cancion.getTitulo() + "\nGenero: "
                    + cancion.getGenero() + "\nDuración: " + cancion.getDuracion() + "\nAño: " + cancion.getFecha()
                    + "\nAlbum: " + cancion.getCaratula() + "\nDescripcion: " + cancion.getDescripcion()
                    + "\n------------------------------");
        }
    }

    public void ordenarPorFecha() {
        BibliotecaPrincipal bibliotecaPrincipal = new BibliotecaPrincipal();
        List<Cancion> listaCanciones = bibliotecaPrincipal.getBibliotecaPrincipal();
        Collections.sort(listaCanciones, new OrdenarPorFecha());
        System.out.println("BIBLIOTECA DE CANCIONES POR FECHA\n-------------------------");
        for (Cancion cancion : listaCanciones) {
            System.out.println(cancion.getIdentificador() + " " + "Titulo: " + cancion.getTitulo() + "\nGenero: "
                    + cancion.getGenero() + "\nDuración: " + cancion.getDuracion() + "\nAño: " + cancion.getFecha()
                    + "\nAlbum: " + cancion.getCaratula() + "\nDescripcion: " + cancion.getDescripcion()
                    + "\n------------------------------");
        }
    }

    public void filtrarPorGenero() {
        String genero = "Rock";
        List<Cancion> lista = new ArrayList<>(this.listaCanciones.values());
        System.out.println("BIBLIOTECA DE CANCIONES FILTRADA POR GENERO\n-----------------------------------");
        for (Cancion cancion : lista) {
            if (cancion.getGenero() == genero) {
                System.out.println(cancion.getIdentificador() + " " + "Titulo: " + cancion.getTitulo() + "\nGenero: "
                        + cancion.getGenero() + "\nDuración: " + cancion.getDuracion() + "\nAño: " + cancion.getFecha()
                        + "\nAlbum: " + cancion.getCaratula() + "\nDescripcion: " + cancion.getDescripcion()
                        + "\n------------------------------");
            }
        }
    }

    public void filtrarPorAnio() {
        int anio = 2002;
        List<Cancion> lista = new ArrayList<>(this.listaCanciones.values());
        System.out.println("BIBLIOTECA DE CANCIONES FILTRADA POR AÑO\n-----------------------------------");
        for (Cancion cancion : lista) {
            if (cancion.getFecha() == anio) {
                System.out.println(cancion.getIdentificador() + " " + "Titulo: " + cancion.getTitulo() + "\nGenero: "
                        + cancion.getGenero() + "\nDuración: " + cancion.getDuracion() + "\nAño: " + cancion.getFecha()
                        + "\nAlbum: " + cancion.getCaratula() + "\nDescripcion: " + cancion.getDescripcion()
                        + "\n------------------------------");
            }
        }
    }
}
