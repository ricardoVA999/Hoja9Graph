public class vertice<E> {
    int posicion;
    public E nombre;
    public boolean visitado;
    public vertice(E name, int pos) {
        this.nombre = name;
        this.visitado = false;
        this.posicion = pos;
    }
    public boolean isVisited(){
        return visitado;
    }
    public void reset(){
        visitado = false;
    }
    public int getPosicion(){
        return this.posicion;
    }
}
