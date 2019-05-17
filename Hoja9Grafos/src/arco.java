public class arco<V,E> {
    public V vrt1;
    public V vrt2;
    public E nombre;
    public boolean di;
    public boolean visitado;

    public arco(V vrt1, V vrt2, E nombre, boolean di) {
        this.vrt1 = vrt1;
        this.vrt2 = vrt2;
        this.nombre = nombre;
        this.di = di;
        this.visitado = false;
    }
    public V there(){
        return this.vrt2;
    }
    public E label(){
        return this.nombre;
    }
    public boolean isVisited(){
        return visitado;
    }
    public V here() {
        return this.vrt1;
    }
    public void reset(){
        visitado = false;
    }

}
