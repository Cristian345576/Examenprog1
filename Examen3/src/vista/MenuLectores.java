/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.LectorControlador;
import modelo.Lector;

import java.util.List;
import java.util.Scanner;

public class MenuLectores {
    private static final Scanner sc = new Scanner(System.in);
    private static final LectorControlador lectorControlador = new LectorControlador();

    public static void mostrarMenuLectores() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Lectores ---");
            System.out.println("1. Agregar Lector");
            System.out.println("2. Listar Lectores");
            System.out.println("3. Volver al Menú Principal");
            System.out.print("Seleccione opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    agregarLector();
                    break;
                case 2:
                    listarLectores();
                    break;
                case 3:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 3);
    }

    private static void agregarLector() {
        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese email: ");
        String email = sc.nextLine();

        boolean exito = lectorControlador.agregarLector(nombre, email);
        if (exito) {
            System.out.println("Lector agregado con éxito.");
        } else {
            System.out.println("Error al agregar lector.");
        }
    }

    private static void listarLectores() {
        List<Lector> lectores = lectorControlador.listarLectores();

        if (lectores == null || lectores.isEmpty()) {
            System.out.println("No hay lectores registrados.");
            return;
        }

        System.out.println("\nLista de lectores:");
        for (Lector lector : lectores) {
            System.out.printf("%d - %s - %s\n",
                lector.getId(),
                lector.getNombre(),
                lector.getEmail());
        }
    }
}
               


