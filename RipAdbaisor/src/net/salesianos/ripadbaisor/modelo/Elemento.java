/**
 * Clase Elemento
 * Esta clase representa un elemento que el usuario puede valorar.
 * Básicamente es un "objeto" con nombre, categoría, descripción y puntuación.
 * Lo uso para guardar la información que luego mostraré en el ranking a continuación.
 */
package net.salesianos.ripadbaisor.modelo;

public class Elemento implements Comparable<Elemento> {

    // Nombre del elemento (ej: "Hamburguesa", "Hotel", etc.)
    private String nombre;

    // Categoría a la que pertenece (ej: "Comida", "Alojamiento")
    private String categoria;

    // Descripción breve del elemento
    private String descripcion;

    // Puntuación del 1 al 5
    private int puntuacion;

    /**
     * Constructor del elemento.
     * Aquí simplemente guardo los datos que me pasa el usuario.
     */
    public Elemento(String nombre, String categoria, String descripcion, int puntuacion) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.puntuacion = puntuacion;
    }

    // Getters lo utilizo para obtener los valores.
    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }
    public String getDescripcion() { return descripcion; }
    public int getPuntuacion() { return puntuacion; }

    // Setters sirven para modificar los valores
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setPuntuacion(int puntuacion) { this.puntuacion = puntuacion; }

    /**
     * compareTo()
     * Este método sirve para ordenar los elementos por puntuación.
     * Lo ordeno de mayor a menor porque es un ranking.
     */
    @Override
    public int compareTo(Elemento o) {
        return Integer.compare(o.puntuacion, this.puntuacion);
    }

    /**
     * toString()
     * Devuelve el elemento en formato texto para mostrarlo en JOptionPane.
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre +
               "\nCategoría: " + categoria +
               "\nDescripción: " + descripcion +
               "\nPuntuación: " + puntuacion + "\n";
    }
}
