/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author cristian.barquero
 */
import modelo.Libro;
import modelo.LibroDAO;

import java.util.List;

public class LibroControlador {
    private LibroDAO libroDAO = new LibroDAO();

    public boolean agregarLibro(String titulo, String autor, int anio) {
        if (titulo == null || titulo.isEmpty() || autor == null || autor.isEmpty() || anio <= 0) {
            System.out.println("Datos inválidos.");
            return false;
        }
        Libro libro = new Libro();
        libro.setTitulo(titulo);
        libro.setAutor(autor);
        libro.setAnioPublicacion(anio);
        return libroDAO.agregarLibro(libro);
    }

    public List<Libro> listarLibros() {
        return libroDAO.listarLibros();
    }
}


