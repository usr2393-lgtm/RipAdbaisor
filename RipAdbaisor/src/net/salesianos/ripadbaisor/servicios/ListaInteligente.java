/**
 * ListaInteligente
 * Esta clase es donde guardo todos los elementos creados por el usuario.
 * Aquí hago el CRUD: añadir, ver, borrar y ordenar.
 */
package net.salesianos.ripadbaisor.servicios;

import net.salesianos.ripadbaisor.modelo.Elemento;
import java.util.ArrayList;
import java.util.Collections;

public class ListaInteligente {

    // Lista donde guardo todos los elementos
    private ArrayList<Elemento> lista = new ArrayList<>();

    // Añadir un elemento nuevo
    public void add(Elemento e) {
        lista.add(e);
    }

    // Obtener un elemento por su índice
    public Elemento get(int index) {
        return lista.get(index);
    }

    // Eliminar un elemento por su índice
    public void remove(int index) {
        lista.remove(index);
    }

    // Saber cuántos elementos hay
    public int size() {
        return lista.size();
    }

    // Devolver la lista ordenada por puntuación
    public ArrayList<Elemento> getOrdenados() {
        ArrayList<Elemento> copia = new ArrayList<>(lista);
        Collections.sort(copia);
        return copia;
    }
}
