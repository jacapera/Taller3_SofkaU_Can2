package com.sofka.can2.modelo;

public class Cancion {

    private Integer identificador;
    private String titulo;
    private Integer fecha;
    private double duracion;
    private String genero;
    private String caratula;
    private String descripcion;

    public Cancion(Integer identificador, String titulo, Integer fecha, double duracion,
            String genero, String caratula, String descripcion) {
        this.identificador = identificador;
        this.titulo = titulo;
        this.fecha = fecha;
        this.duracion = duracion;
        this.genero = genero;
        this.caratula = caratula;
        this.descripcion = descripcion;
    }

    /*
     *  constructor creado para crear canciones que se agregaran a una playlist y no se requiere
     *  el atributo descripcion
     */
    public Cancion(Integer identificador, String titulo, Integer fecha, double duracion, String genero, String caratula) {
        this.identificador = identificador;
        this.titulo = titulo;
        this.fecha = fecha;
        this.duracion = duracion;
        this.genero = genero;
        this.caratula = caratula;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getFecha() {
        return fecha;
    }

    public void setFecha(Integer fecha) {
        this.fecha = fecha;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCaratula() {
        return caratula;
    }

    public void setCaratula(String caratula) {
        this.caratula = caratula;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
