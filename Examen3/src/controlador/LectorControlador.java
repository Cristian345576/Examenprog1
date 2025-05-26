/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author cristian.barquero
 */
import modelo.Lector;
import modelo.LectorDAO;

import java.util.List;

public class LectorControlador {
    private LectorDAO lectorDAO = new LectorDAO();

    public boolean agregarLector(String nombre, String email) {
        if (nombre == null || nombre.isEmpty() || email == null || email.isEmpty()) {
            System.out.println("Datos inválidos.");
            return false;
        }
        Lector lector = new Lector();
        lector.setNombre(nombre);
        lector.setEmail(email);
        return lectorDAO.agregarLector(lector);
    }

    public List<Lector> listarLectores() {
        return lectorDAO.listarLectores();
    }
}
