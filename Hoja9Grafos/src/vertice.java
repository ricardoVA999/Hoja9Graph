public class vertice<E> {
    public E nombre;
    public boolean visitado;
    public vertice(E name) {
        this.nombre = name;
        this.visitado = false;
    }
    public boolean isVisited(){
        return visitado;
    }
    public void reset(){
        visitado = false;
    }

}
