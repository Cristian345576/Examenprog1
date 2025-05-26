/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author cristian.barquero
 */
package vista;

import controlador.LibroControlador;
import modelo.Libro;

import java.util.List;
import java.util.Scanner;

public class Libros {
    private static Scanner sc = new Scanner(System.in);
    private static LibroControlador libroControlador = new LibroControlador();

    public static void mostrarMenuLibros() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Libros ---");
            System.out.println("1. Agregar Libro");
            System.out.println("2. Listar Libros");
            System.out.println("3. Volver al Menú Principal");
            System.out.print("Seleccione opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    listarLibros();
                    break;
                case 3:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 3);
    }

    private static void agregarLibro() {
        System.out.print("Ingrese título: ");
        String titulo = sc.nextLine();

        System.out.print("Ingrese autor: ");
        String autor = sc.nextLine();

        System.out.print("Ingrese año de publicación: ");
        int anio = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        boolean exito = libroControlador.agregarLibro(titulo, autor, anio);
        if (exito) {
            System.out.println("Libro agregado con éxito.");
        } else {
            System.out.println("Error al agregar libro.");
        }
    }

    private static void listarLibros() {
        List<Libro> libros = libroControlador.listarLibros();
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
        } else {
            System.out.println("\nLista de libros:");
            for (Libro l : libros) {
                System.out.printf("%d - %s - %s - %d\n", l.getId(), l.getTitulo(), l.getAutor(), l.getAnioPublicacion());
            }
        }
    }
}

