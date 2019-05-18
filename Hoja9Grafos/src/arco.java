/**
 * Clase sencilla para la creacion de un arco, obtenida del libro Java Structures escrito por Duane A. Bailey tomando como
 * referencia la seccion 16.2
 * Extraido de http://dept.cs.williams.edu/~bailey/JavaStructures/Book_files/JavaStructures.pdf
 * @param <V> generico
 */
public class arco<V> {
    public V vrt1;
    public V vrt2;
    public double distancia;
    public boolean di;
    public boolean visitado;

    /**
     * Constructor
     * @param vrt1 vertice origen
     * @param vrt2 vertice destino
     * @param dist distancia entre vertices
     * @param di direccionado o no
     */
    public arco(V vrt1, V vrt2, double dist, boolean di) {
        this.vrt1 = vrt1;
        this.vrt2 = vrt2;
        this.distancia = dist;
        this.di = di;
        this.visitado = false;
    }

    /**
     * @return destino
     */
    public V there(){
        return this.vrt2;
    }

    /**
     * @return la distancia
     */
    public double label(){
        return this.distancia;
    }

    /**
     * si se ha visitado a no
     * @return un boleano
     */
    public boolean isVisited(){
        return visitado;
    }

    /**
     * @return origen
     */
    public V here() {
        return this.vrt1;
    }

    /**
     *  Reestablecer el valor de visitado
     */
    public void reset(){
        visitado = false;
    }

}
