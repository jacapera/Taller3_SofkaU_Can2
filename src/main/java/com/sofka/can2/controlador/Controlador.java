package com.sofka.can2.controlador;

import com.sofka.can2.modelo.BibliotecaPrincipal;
import com.sofka.can2.modelo.Cancion;
import com.sofka.can2.vista.Ventana;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * Desde esta clase se controla el flujo de mi aplicacion desde la vista hasta
 * el modelo, en este controlador se codificara todas las funciones de mi
 * aplicación
 *
 * @author Jesus Capera
 */
public class Controlador implements ActionListener {

    Ventana ventana;
    DefaultTableModel modelo;
    BibliotecaPrincipal lista;
    DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
    ArrayList<Cancion> playlist = new ArrayList<>();
    Cancion cancion;
    Map<String, ArrayList> listaPlaylists = new HashMap<>();
    String clave;

    public Controlador(Ventana ventana, BibliotecaPrincipal lista) {
        this.ventana = ventana;
        this.lista = lista;
        ventana.setVisible(true);
        mostrarTablaBiblioteca();
        mostrarTablaPlaylist();
        mostrarTablaListaPlaylist();
        mapearEventos();
    }

    private void mostrarTablaBiblioteca() {
        String[] titulos = new String[]{"ID", "Título", "Fecha", "Duración", "Género", "Album", "Descripción"};
        modelo = new DefaultTableModel(titulos, 0);
        List<Cancion> listaCanciones = lista.getBibliotecaPrincipal();
        for (Cancion cancion : listaCanciones) {
            modelo.addRow(new Object[]{cancion.getIdentificador(), cancion.getTitulo(),
                cancion.getFecha(), cancion.getDuracion(), cancion.getGenero(),
                cancion.getCaratula(), cancion.getDescripcion()});
        }
        ventana.getTabla().setModel(modelo);
        ventana.getTabla().setPreferredSize(new Dimension(350, modelo.getRowCount() * 16));
        ventana.getTabla().getTableHeader().setBackground(new Color(0, 0, 128));
        ventana.getTabla().getTableHeader().setForeground(new Color(255, 255, 255));
        ventana.getTabla().getTableHeader().setFont(new Font("mv boli", Font.BOLD, 18));
        ventana.getTabla().setFont(new Font("mv boli", Font.PLAIN, 16));
        ventana.getTabla().getColumnModel().getColumn(6).setMaxWidth(0);
        ventana.getTabla().getColumnModel().getColumn(6).setMinWidth(0);
        ventana.getTabla().getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
        ventana.getTabla().getTableHeader().getColumnModel().getColumn(6).setMinWidth(0);
        ventana.getTabla().getColumnModel().getColumn(6).setResizable(false);
        ventana.getTabla().getColumnModel().getColumn(0).setPreferredWidth(5);
        ventana.getTabla().getColumnModel().getColumn(1).setPreferredWidth(100);
        ventana.getTabla().getColumnModel().getColumn(2).setPreferredWidth(25);
        ventana.getTabla().getColumnModel().getColumn(3).setPreferredWidth(30);
        ventana.getTabla().getColumnModel().getColumn(4).setPreferredWidth(200);
        ventana.getTabla().getColumnModel().getColumn(5).setPreferredWidth(250);
        ventana.getTabla().getColumnModel().setColumnMargin(10);
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        ventana.getTabla().getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);
        ventana.getTabla().getColumnModel().getColumn(2).setCellRenderer(defaultTableCellRenderer);
        ventana.getTabla().getColumnModel().getColumn(3).setCellRenderer(defaultTableCellRenderer);
        //ventana.getTabla().setRowHeight(16);
    }

    private void pintarTablaBiblioteca(DefaultTableModel modelo) {
        ventana.getTabla().setModel(modelo);
        ventana.getTabla().setPreferredSize(new Dimension(350, modelo.getRowCount() * 16));
        ventana.getTabla().getTableHeader().setBackground(new Color(0, 0, 128));
        ventana.getTabla().getTableHeader().setForeground(new Color(255, 255, 255));
        ventana.getTabla().getTableHeader().setFont(new Font("mv boli", Font.BOLD, 18));
        ventana.getTabla().setFont(new Font("mv boli", Font.PLAIN, 16));
        ventana.getTabla().getColumnModel().getColumn(6).setMaxWidth(0);
        ventana.getTabla().getColumnModel().getColumn(6).setMinWidth(0);
        ventana.getTabla().getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
        ventana.getTabla().getTableHeader().getColumnModel().getColumn(6).setMinWidth(0);
        ventana.getTabla().getColumnModel().getColumn(6).setResizable(false);
        ventana.getTabla().getColumnModel().getColumn(0).setPreferredWidth(5);
        ventana.getTabla().getColumnModel().getColumn(1).setPreferredWidth(100);
        ventana.getTabla().getColumnModel().getColumn(2).setPreferredWidth(25);
        ventana.getTabla().getColumnModel().getColumn(3).setPreferredWidth(30);
        ventana.getTabla().getColumnModel().getColumn(4).setPreferredWidth(200);
        ventana.getTabla().getColumnModel().getColumn(5).setPreferredWidth(250);
        ventana.getTabla().getColumnModel().setColumnMargin(10);
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        ventana.getTabla().getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);
        ventana.getTabla().getColumnModel().getColumn(2).setCellRenderer(defaultTableCellRenderer);
        ventana.getTabla().getColumnModel().getColumn(3).setCellRenderer(defaultTableCellRenderer);
        ventana.getTabla().setRowHeight(16);
    }

    private void mostrarTablaPlaylist() {
        String[] titulos = new String[]{"ID", "Título", "Fecha", "Duración", "Género", "Album"};
        modelo = new DefaultTableModel(titulos, 0);
        ventana.getTablaPlaylist().setModel(modelo);
        ventana.getTablaPlaylist().setPreferredSize(new Dimension(350, modelo.getRowCount() * 16));
        ventana.getTablaPlaylist().getTableHeader().setBackground(new Color(0, 0, 128));
        ventana.getTablaPlaylist().getTableHeader().setForeground(new Color(255, 255, 255));
        ventana.getTablaPlaylist().getTableHeader().setFont(new Font("mv boli", Font.BOLD, 18));
        ventana.getTablaPlaylist().setFont(new Font("mv boli", Font.PLAIN, 16));
        ventana.getTablaPlaylist().getColumnModel().getColumn(0).setPreferredWidth(5);
        ventana.getTablaPlaylist().getColumnModel().getColumn(1).setPreferredWidth(100);
        ventana.getTablaPlaylist().getColumnModel().getColumn(2).setPreferredWidth(30);
        ventana.getTablaPlaylist().getColumnModel().getColumn(3).setPreferredWidth(50);
        ventana.getTablaPlaylist().getColumnModel().getColumn(4).setPreferredWidth(130);
        ventana.getTablaPlaylist().getColumnModel().getColumn(5).setPreferredWidth(130);
        ventana.getTablaPlaylist().getColumnModel().setColumnMargin(10);
    }

    private void pintarTablaPlaylist(DefaultTableModel modelo) {
        ventana.getTablaPlaylist().setModel(modelo);
        ventana.getTablaPlaylist().setPreferredSize(new Dimension(350, modelo.getRowCount() * 16));
        ventana.getTablaPlaylist().getTableHeader().setBackground(new Color(0, 0, 128));
        ventana.getTablaPlaylist().getTableHeader().setForeground(new Color(255, 255, 255));
        ventana.getTablaPlaylist().getTableHeader().setFont(new Font("mv boli", Font.BOLD, 18));
        ventana.getTablaPlaylist().setFont(new Font("mv boli", Font.PLAIN, 16));
        ventana.getTablaPlaylist().getColumnModel().getColumn(0).setPreferredWidth(5);
        ventana.getTablaPlaylist().getColumnModel().getColumn(1).setPreferredWidth(100);
        ventana.getTablaPlaylist().getColumnModel().getColumn(2).setPreferredWidth(30);
        ventana.getTablaPlaylist().getColumnModel().getColumn(3).setPreferredWidth(50);
        ventana.getTablaPlaylist().getColumnModel().getColumn(4).setPreferredWidth(130);
        ventana.getTablaPlaylist().getColumnModel().getColumn(5).setPreferredWidth(130);
        ventana.getTablaPlaylist().getColumnModel().setColumnMargin(10);
    }

    private void mostrarTablaListaPlaylist() {
        String[] titulos = new String[]{"Nombre Playlist"};
        modelo = new DefaultTableModel(titulos, 0);
        ventana.getTablaListaPlaylist().setModel(modelo);
        ventana.getTablaListaPlaylist().setPreferredSize(new Dimension(50, modelo.getRowCount() * 16));
        ventana.getTablaListaPlaylist().getTableHeader().setBackground(new Color(0, 0, 128));
        ventana.getTablaListaPlaylist().getTableHeader().setForeground(new Color(255, 255, 255));
        ventana.getTablaListaPlaylist().getTableHeader().setFont(new Font("mv boli", Font.BOLD, 18));
        ventana.getTablaListaPlaylist().setFont(new Font("mv boli", Font.PLAIN, 16));
        ventana.getTablaListaPlaylist().getColumnModel().setColumnMargin(10);
    }

    private void pintarTablaListaPlaylist(DefaultTableModel modelo) {
        ventana.getTablaListaPlaylist().setModel(modelo);
        ventana.getTablaListaPlaylist().setPreferredSize(new Dimension(50, modelo.getRowCount() * 16));
        ventana.getTablaListaPlaylist().getTableHeader().setBackground(new Color(0, 0, 128));
        ventana.getTablaListaPlaylist().getTableHeader().setForeground(new Color(255, 255, 255));
        ventana.getTablaListaPlaylist().getTableHeader().setFont(new Font("mv boli", Font.BOLD, 18));
        ventana.getTablaListaPlaylist().setFont(new Font("mv boli", Font.PLAIN, 16));
        ventana.getTablaListaPlaylist().getColumnModel().setColumnMargin(10);
    }

    private void mapearEventos() {
        ventana.getBtnOrdenarPorFecha().addActionListener(this);
        ventana.getBtnOrdenarPorDuracion().addActionListener(this);
        ventana.getBtnFiltrarPorAnio().addActionListener(this);
        ventana.getBtnFiltrarPorGenero().addActionListener(this);
        ventana.getBtnAgregar().addActionListener(this);
        ventana.getBtnGuardar().addActionListener(this);
        ventana.getBtnVerPlaylist().addActionListener(this);
        ventana.getBtnVerComentario().addActionListener(this);
        ventana.getTabla().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                llenarCampos(e);
            }
        });
        ventana.getTablaListaPlaylist().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                llenarCamposVerPlaylist(e);
            }
        });
    }

    /**
     * Este método se encarga de llenar los jtextfield con la información de las
     * canciones para que el usuario no tenga que digitar ninguna información
     *
     * @param e
     */
    private void llenarCampos(MouseEvent e) {
        JTable target = (JTable) e.getSource();
        ventana.getTxtGenero().setText(ventana.getTabla().getModel().getValueAt(target.getSelectedRow(), 4).toString());
        ventana.getTxtAnio().setText(ventana.getTabla().getModel().getValueAt(target.getSelectedRow(), 2).toString());
        ventana.getTxtId().setText(ventana.getTabla().getModel().getValueAt(target.getSelectedRow(), 0).toString());
        ventana.getTxtCancion().setText(ventana.getTabla().getModel().getValueAt(target.getSelectedRow(), 1).toString());
        ventana.getTxtFecha().setText(ventana.getTabla().getModel().getValueAt(target.getSelectedRow(), 2).toString());
        ventana.getTxtDuracion().setText(ventana.getTabla().getModel().getValueAt(target.getSelectedRow(), 3).toString());
        ventana.getTxtGeneroPlaylist().setText(ventana.getTabla().getModel().getValueAt(target.getSelectedRow(), 4).toString());
        ventana.getTxtAlbum().setText(ventana.getTabla().getModel().getValueAt(target.getSelectedRow(), 5).toString());
    }

    private void llenarCamposVerPlaylist(MouseEvent e) {
        JTable target = (JTable) e.getSource();
        ventana.getTxtVerPlaylist().setText(ventana.getTablaListaPlaylist().getModel().getValueAt(target.getSelectedRow(), 0).toString());
        ventana.getTxtNombrePlaylist().setText(ventana.getTablaListaPlaylist().getModel().getValueAt(target.getSelectedRow(), 0).toString());
    }

    /**
     * Este método me permite limpiar los jtextfield despues de ejecutar alguna
     * acción de alguno de los botones para darle una mejor apariencia y
     * experiencia de usuario
     */
    private void limpiarCampos() {
        ventana.getTxtGenero().setText("");
        ventana.getTxtAnio().setText("");
        ventana.getTxtId().setText("");
        ventana.getTxtCancion().setText("");
        ventana.getTxtFecha().setText("");
        ventana.getTxtDuracion().setText("");
        ventana.getTxtGeneroPlaylist().setText("");
        ventana.getTxtAlbum().setText("");
        ventana.getTxtVerDescripcion().setText("");
    }

    private Cancion crearCancion() {
        Integer identificador = Integer.parseInt(ventana.getTxtId().getText());
        String titulo = ventana.getTxtCancion().getText();
        Integer fecha = Integer.parseInt(ventana.getTxtFecha().getText());
        Double duracion = Double.parseDouble(ventana.getTxtDuracion().getText());
        String genero = ventana.getTxtGeneroPlaylist().getText();
        String album = ventana.getTxtAlbum().getText();
        cancion = new Cancion(identificador, titulo, fecha, duracion, genero, album);
        return cancion;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ventana.getBtnOrdenarPorFecha()) {
            ordenarPorFecha();
        } else if (e.getSource() == ventana.getBtnOrdenarPorDuracion()) {
            ordenarPorDuracion();
        } else if (e.getSource() == ventana.getBtnFiltrarPorAnio()) {
            filtrarPorAnio();
        } else if (e.getSource() == ventana.getBtnFiltrarPorGenero()) {
            filtrarPorGenero();
        } else if (e.getSource() == ventana.getBtnAgregar()) {
            agregarCancion();
        } else if (e.getSource() == ventana.getBtnGuardar()) {
            guardarPlaylist();
        } else if (e.getSource() == ventana.getBtnVerPlaylist()) {
            pintarPlaylist();
        } else if (e.getSource() == ventana.getBtnVerComentario()) {
            verDescripcion();
        }
    }

    private void ordenarPorFecha() {
        String[] titulos = new String[]{"ID", "Título", "Fecha", "Duración", "Género", "Album", "Descripción"};
        modelo = new DefaultTableModel(titulos, 0);
        List<Cancion> listaCanciones = lista.getBibliotecaPrincipal();
        Collections.sort(listaCanciones, new OrdenarPorFecha());
        for (Cancion cancion : listaCanciones) {
            modelo.addRow(new Object[]{cancion.getIdentificador(), cancion.getTitulo(),
                cancion.getFecha(), cancion.getDuracion(), cancion.getGenero(),
                cancion.getCaratula(), cancion.getDescripcion()});
        }
        pintarTablaBiblioteca(modelo);
    }

    private void ordenarPorDuracion() {
        String[] titulos = new String[]{"ID", "Título", "Fecha", "Duración", "Género", "Album", "Descripción"};
        modelo = new DefaultTableModel(titulos, 0);
        List<Cancion> listaCanciones = lista.getBibliotecaPrincipal();
        Collections.sort(listaCanciones, new OrdenarPorDuracion());
        for (Cancion cancion : listaCanciones) {
            modelo.addRow(new Object[]{cancion.getIdentificador(), cancion.getTitulo(),
                cancion.getFecha(), cancion.getDuracion(), cancion.getGenero(),
                cancion.getCaratula(), cancion.getDescripcion()});
        }
        pintarTablaBiblioteca(modelo);
    }

    private void filtrarPorAnio() {
        int anio = Integer.parseInt(ventana.getTxtAnio().getText());
        String[] titulos = new String[]{"ID", "Título", "Fecha", "Duración", "Género", "Album", "Descripción"};
        modelo = new DefaultTableModel(titulos, 0);
        List<Cancion> listaCanciones = lista.getBibliotecaPrincipal();
        for (Cancion cancion : listaCanciones) {
            if (cancion.getFecha() == anio) {
                modelo.addRow(new Object[]{cancion.getIdentificador(), cancion.getTitulo(),
                    cancion.getFecha(), cancion.getDuracion(), cancion.getGenero(),
                    cancion.getCaratula(), cancion.getDescripcion()});
            }
        }
        pintarTablaBiblioteca(modelo);
        limpiarCampos();
    }

    private void filtrarPorGenero() {
        String genero = ventana.getTxtGenero().getText();
        String[] titulos = new String[]{"ID", "Título", "Fecha", "Duración", "Género", "Album", "Descripción"};
        modelo = new DefaultTableModel(titulos, 0);
        List<Cancion> listaCanciones = lista.getBibliotecaPrincipal();
        for (Cancion cancion : listaCanciones) {
            if (genero.equals(cancion.getGenero())) {
                modelo.addRow(new Object[]{cancion.getIdentificador(), cancion.getTitulo(),
                    cancion.getFecha(), cancion.getDuracion(), cancion.getGenero(),
                    cancion.getCaratula(), cancion.getDescripcion()});
            }
        }
        pintarTablaBiblioteca(modelo);
        limpiarCampos();
    }

    private void agregarCancion() {
        if ("".equals(ventana.getTxtNombrePlaylist().getText()) || "".equals(ventana.getTxtId().getText())
                || "".equals(ventana.getTxtCancion().getText()) || "".equals(ventana.getTxtFecha().getText())
                || "".equals(ventana.getTxtDuracion().getText()) || "".equals(ventana.getTxtGeneroPlaylist().getText())
                || "".equals(ventana.getTxtAlbum().getText())) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una cancion de la Biblioteca Principal y el campo nombre no puede estar vacio",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            clave = ventana.getTxtNombrePlaylist().getText();
            if (listaPlaylists.containsKey(clave)) {
                ArrayList<Cancion> aux = new ArrayList<>();
                String[] titulos = new String[]{"ID", "Título", "Fecha", "Duración", "Género", "Album"};
                modelo = new DefaultTableModel(titulos, 0);
                for (Map.Entry<String, ArrayList> items : listaPlaylists.entrySet()) {
                    if (clave.equals(items.getKey())) {
                        aux = items.getValue();
                        aux.add(crearCancion());
                        for (Cancion items2 : aux) {
                            modelo.addRow(new Object[]{items2.getIdentificador(), items2.getTitulo(),
                                items2.getFecha(), items2.getDuracion(), items2.getGenero(), items2.getCaratula()});
                        }
                        pintarTablaPlaylist(modelo);
                        limpiarCampos();
                        listaPlaylists.put(clave, (ArrayList) aux);
                    }
                }
            } else {
                String[] titulos = new String[]{"ID", "Título", "Fecha", "Duración", "Género", "Album"};
                modelo = new DefaultTableModel(titulos, 0);
                playlist.add(crearCancion());
                for (Cancion items2 : playlist) {
                    modelo.addRow(new Object[]{items2.getIdentificador(), items2.getTitulo(),
                        items2.getFecha(), items2.getDuracion(), items2.getGenero(), items2.getCaratula()});
                }
                pintarTablaPlaylist(modelo);
                limpiarCampos();
            }

        }
    }

    private void guardarPlaylist() {
        if ("".equals(ventana.getTxtNombrePlaylist().getText())) {
            JOptionPane.showMessageDialog(null, "El campo nombre no puede estar vacio para crear o agregar canciones a una playlist",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            clave = ventana.getTxtNombrePlaylist().getText();
            //List<Cancion> aux = new ArrayList<>();
            if (listaPlaylists.containsKey(clave)) {
                for (Map.Entry<String, ArrayList> items : listaPlaylists.entrySet()) {
                    if (clave.equals(items.getKey())) {
                        mostrarTablaPlaylist();
                        playlist.clear();
                        ventana.getTxtNombrePlaylist().setText("");
                    }
                }
            } else {
                ArrayList<Cancion> playlistClone = new ArrayList<>();
                playlistClone = (ArrayList<Cancion>) playlist.clone();
                listaPlaylists.put(clave, (ArrayList) playlistClone);
                String[] titulos2 = new String[]{"Nombre Playlist"};
                modelo = new DefaultTableModel(titulos2, 0);
                for (Map.Entry<String, ArrayList> items : listaPlaylists.entrySet()) {
                    modelo.addRow(new Object[]{items.getKey()});
                }
                pintarTablaListaPlaylist(modelo);
                mostrarTablaPlaylist();
                playlist.clear();
                limpiarCampos();
                ventana.getTxtNombrePlaylist().setText("");
            }
        }
    }

    /**
     * Este método me permite mostrar la informacion de todas las canciones que
     * tiene una determinada playlist creada por el usuario
     */
    private void pintarPlaylist() {
        clave = ventana.getTxtVerPlaylist().getText();
        String[] titulos = new String[]{"ID", "Título", "Fecha", "Duración", "Género", "Album"};
        modelo = new DefaultTableModel(titulos, 0);
        List<Cancion> listado = new ArrayList<>();
        for (Map.Entry<String, ArrayList> items : listaPlaylists.entrySet()) {
            if (clave.equals(items.getKey())) {
                listado = items.getValue();
                for (Cancion cancion : listado) {
                    modelo.addRow(new Object[]{cancion.getIdentificador(), cancion.getTitulo(),
                        cancion.getFecha(), cancion.getDuracion(), cancion.getGenero(), cancion.getCaratula()});
                }
            }
        }
        pintarTablaPlaylist(modelo);
    }

    private void verDescripcion() {
        if ("".equals(ventana.getTxtId().getText()) || "".equals(ventana.getTxtCancion().getText())
                || "".equals(ventana.getTxtFecha().getText()) || "".equals(ventana.getTxtDuracion().getText())
                || "".equals(ventana.getTxtGeneroPlaylist().getText()) || "".equals(ventana.getTxtAlbum().getText())) {

            JOptionPane.showMessageDialog(null, "Debes seleccionar una cancion de la Biblioteca Principal para ver la descripción",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            Integer id = Integer.parseInt(ventana.getTxtId().getText());
            List<Cancion> aux = new ArrayList<>();
            aux = lista.getBibliotecaPrincipal();
            for (Cancion cancion : aux) {
                if (id == cancion.getIdentificador()) {
                    ventana.getTxtVerDescripcion().setText("Titulo: " + cancion.getTitulo() + "\n-----------------------\n" + "Descripcion: "
                            + cancion.getDescripcion());
                }
            }
        }
    }

}
