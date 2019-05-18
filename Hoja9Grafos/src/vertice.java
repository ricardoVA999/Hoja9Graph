/**
 * Clase sencilla para la creacion de un vertice, obtenida del libro Java Structures escrito por Duane A. Bailey tomando como
 * referencia las secciones 16.2
 * Extraido de http://dept.cs.williams.edu/~bailey/JavaStructures/Book_files/JavaStructures.pdf
 * @param <E> generico
 */
public class vertice<E> {
    int posicion;
    public E nombre;
    public boolean visitado;

    /**
     * Constructor
     * @param name nombre para el vertice
     * @param pos posicion
     */
    public vertice(E name, int pos) {
        this.nombre = name;
        this.visitado = false;
        this.posicion = pos;
    }
    /**
    Devolver si ha sido visidado o no
     */
    public boolean isVisited(){
        return visitado;
    }
    /**
    Reestablecer el valor de visitado
     */
    public void reset(){
        visitado = false;
    }

    /**
     * @return la posicion del vertice
     */
    public int getPosicion(){
        return this.posicion;
    }
}
