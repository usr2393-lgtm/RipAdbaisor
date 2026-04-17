/**
 * App
 * Esta es la clase principal. Aquí está el menú y toda la interacción con el usuario.
 * Uso JOptionPane porque el cliente tiene miedo a la consola.
 */
package net.salesianos.ripadbaisor.ui;

import javax.swing.*;
import net.salesianos.ripadbaisor.modelo.Elemento;
import net.salesianos.ripadbaisor.servicios.ListaInteligente;
import net.salesianos.ripadbaisor.servicios.Validador;

public class App {

    public static void main(String[] args) {

        ListaInteligente lista = new ListaInteligente();

        while (true) {
            try {
                String opcion = JOptionPane.showInputDialog(
                        "RIPADBAISOR\n\n" +
                        "1. Añadir elemento\n" +
                        "2. Editar elemento\n" +
                        "3. Mostrar elementos\n" +
                        "4. Eliminar elemento\n" +
                        "5. Salir\n\n" +
                        "Selecciona una opción:"
                );

                if (opcion == null) continue;

                switch (opcion) {

                    case "1":
                        String nombre = Validador.pedirTexto("Nombre:");
                        String categoria = Validador.pedirTexto("Categoría:");
                        String descripcion = Validador.pedirTexto("Descripción:");
                        int puntuacion = Validador.pedirPuntuacion();

                        lista.add(new Elemento(nombre, categoria, descripcion, puntuacion));
                        JOptionPane.showMessageDialog(null, "Elemento añadido.");
                        break;

                    case "2":
                        if (lista.size() == 0) {
                            JOptionPane.showMessageDialog(null, "No hay elementos.");
                            break;
                        }

                        int indexEdit = Integer.parseInt(
                                JOptionPane.showInputDialog("Índice a editar (0 - " + (lista.size()-1) + "):")
                        );

                        Elemento e = lista.get(indexEdit);

                        e.setNombre(Validador.pedirTexto("Nuevo nombre:"));
                        e.setCategoria(Validador.pedirTexto("Nueva categoría:"));
                        e.setDescripcion(Validador.pedirTexto("Nueva descripción:"));
                        e.setPuntuacion(Validador.pedirPuntuacion());

                        JOptionPane.showMessageDialog(null, "Elemento editado.");
                        break;

                    case "3":
                        StringBuilder sb = new StringBuilder();
                        for (Elemento el : lista.getOrdenados()) {
                            sb.append(el.toString()).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, sb.toString());
                        break;

                    case "4":
                        if (lista.size() == 0) {
                            JOptionPane.showMessageDialog(null, "No hay elementos.");
                            break;
                        }

                        int indexDel = Integer.parseInt(
                                JOptionPane.showInputDialog("Índice a eliminar (0 - " + (lista.size()-1) + "):")
                        );

                        lista.remove(indexDel);
                        JOptionPane.showMessageDialog(null, "Elemento eliminado.");
                        break;

                    case "5":
                        System.exit(0);
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida.");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error controlado: " + ex.getMessage());
            }
        }
    }
}
