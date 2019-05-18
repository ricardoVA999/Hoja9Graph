import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class matrizDigrapho<V> {
    public int size;
    public arco<V> info[][];
    public Map<V,vertice<V>> vert;
    public List<Integer> freeList;
    public List<String> lista;
    Double[][] datos;

    public matrizDigrapho(int size) {
        this.lista = new ArrayList<>();
        this.size = size;
        this.info = new arco[size][size];
        this.datos = new Double[size][size];
        this.vert = new HashMap<>(size);
        this.freeList = new ArrayList<>();
        for (int row = size-1; row >= 0; row--) { freeList.add(row); }
        for(int i = 0; i < datos.length; i++) {
            for(int j = 0; j < datos.length; j++) {
                datos[i][j] = Double.POSITIVE_INFINITY;
                if(i==j){
                    datos[i][j] = 0.0;
                }
            }
        }
    }
    public void add(V nombre) {
        if (vert.containsKey(nombre)) return;
        int pos = freeList.remove(0);
        vert.put(nombre, new vertice<>(nombre,pos));
        lista.add(nombre.toString());
    }
    public String addEdge(V vrt1, V vrt2, double distancia) {
        vertice<V> inicio = vert.get(vrt1);
        vertice<V> llegada = vert.get(vrt2);
        if(inicio == null || llegada == null) {
            return "¡No se puede realizar la union!";
        }else {
            info[inicio.getPosicion()][llegada.getPosicion()] = new arco<V>(vrt1, vrt2, distancia, true);
            datos[inicio.getPosicion()][llegada.getPosicion()] = distancia;
            return "¡Union realizada!";
        }
    }
    public String removeEdge(V vrt1, V vrt2){
        vertice<V> inicio = vert.get(vrt1);
        vertice<V> llegada = vert.get(vrt2);
        if(inicio == null || llegada == null) {
            return "¡No se puede realizar la accion!";
        }else {
            info[inicio.getPosicion()][llegada.getPosicion()] = null;
            datos[inicio.getPosicion()][llegada.getPosicion()] = Double.POSITIVE_INFINITY;
            return "Se ha quitado el camino";
        }
    }
    public void printGraph() {
        System.out.println("Matriz de adyacencia: ");
        int no = lista.size()-1;
        for (int i = 0; i < datos.length; i++) {
            if(no>=0){
                System.out.print(lista.get(no).toString()+"\t\t");
                no--;
            }
            for (int j = 0; j <datos.length; j++) {
                System.out.print(datos[i][j]+ " ");
            }
            System.out.println();
        }
    }




    public Double[][] floyd(Double[][] adyacencia)
    {
        int n=adyacencia.length;
        Double D[][]=adyacencia;

        String enlaces[][]=new String [n][n];
        String[][] aux_enlaces=new String[adyacencia.length][adyacencia.length];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                enlaces[i][j]="";
                aux_enlaces[i][j]="";
            }
        }
        String enl_rec="";
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    Double aux=D[i][j];
                    Double aux2=D[i][k];
                    Double aux3=D[k][j];
                    Double aux4=aux2+aux3;
                    Double res=Math.min(aux,aux4);
                    if(aux!=aux4)
                    {
                        if(res==aux4)
                        {
                            enl_rec="";
                            aux_enlaces[i][j]=k+"";
                            enlaces[i][j]=enlaces(i,k,aux_enlaces,enl_rec)+(k+1);
                        }
                    }
                    D[i][j]=(Double) res;
                }
            }
        }
        return D;
    }

    public String enlaces(int i,int k,String[][] aux_enlaces,String enl_rec)
    {
        if(aux_enlaces[i][k].equals("")==true)
        {
            return "";
        }
        else
        {
            enl_rec+=enlaces(i,Integer.parseInt(aux_enlaces[i][k].toString()),aux_enlaces,enl_rec)+(Integer.parseInt(aux_enlaces[i][k].toString())+1)+" , ";
            return enl_rec;
        }
    }
    public String minDist(V nom1, V nom2) {
        vertice<V> vtx1 = vert.get(nom1);
        vertice<V> vtx2 = vert.get(nom2);
        if (vtx1 == null || vtx2 == null){
            return "No hay conexion!";
        }
        return "\nDesde " +nom1.toString()+" a "+ nom2.toString()+" la distancia mas corta es de "+this.datos[vtx1.getPosicion()][vtx2.getPosicion()] + ".";
    }

    public String getCentroGrafo(V label){

        int[] columna = new int[datos.length];
        for(int i = 0; i < datos.length; i++) {
            Double max = datos[i][0];
            int pos = 0;
            for(int j = 0; j < datos.length; j++) {
                if (i!=j){
                    Double temp = datos[i][j];
                    if(temp > max) {
                        max = temp;
                        pos = j;
                    }
                }
            }
            columna[i] = pos;
        }

        int minPos = 0;
        Number min = columna[0];
        for(int x = 0; x < columna.length; x++) {
            Number temp = columna[x];
            if(temp.doubleValue() < min.doubleValue()) {
                min = temp;
                minPos = x;
            }
        }
        return lista.get(lista.size()-1-minPos);
    }

}
