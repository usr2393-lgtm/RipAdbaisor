/**
 * Validador
 * Aquí pongo métodos que me ayudan a pedir datos al usuario
 * y asegurarme de que no mete cosas raras.
 */
package net.salesianos.ripadbaisor.servicios;

import javax.swing.*;

public class Validador {

    // Pide texto y obliga a que no esté vacío
    public static String pedirTexto(String mensaje) {
        String input;

        do {
            input = JOptionPane.showInputDialog(mensaje);

            if (input == null) return null;

        } while (input.trim().isEmpty());

        return input;
    }

    // Pide una puntuación del 1 al 5
    public static int pedirPuntuacion() {
        int puntuacion = -1;

        while (puntuacion < 1 || puntuacion > 5) {
            try {
                String input = JOptionPane.showInputDialog("Introduce puntuación (1-5):");

                if (input == null) return -1;

                puntuacion = Integer.parseInt(input);

                if (puntuacion < 1 || puntuacion > 5) {
                    JOptionPane.showMessageDialog(null, "Debe ser un número entre 1 y 5.");
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Introduce un número válido.");
            }
        }

        return puntuacion;
    }
}
