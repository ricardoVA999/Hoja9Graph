public class arco<V> {
    public V vrt1;
    public V vrt2;
    public double distancia;
    public boolean di;
    public boolean visitado;

    public arco(V vrt1, V vrt2, double dist, boolean di) {
        this.vrt1 = vrt1;
        this.vrt2 = vrt2;
        this.distancia = dist;
        this.di = di;
        this.visitado = false;
    }
    public V there(){
        return this.vrt2;
    }
    public double label(){
        return this.distancia;
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
