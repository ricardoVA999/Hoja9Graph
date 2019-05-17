import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class matrizDigrapho<V,E> {
    public int size;
    public Object info[][];
    public Map<V,vertice<V>> vert;
    public List<Integer> freeList;
    public boolean negativeCycle;
    Number[][] datos;

    public matrizDigrapho(int size) {
        this.size = size;
        this.info = new Object[size][size];
        this.datos = new Number[size][size];
        this.vert = new HashMap<>(size);
        this.freeList = new ArrayList<>();
        for (int row = size-1; row >= 0; row--) { freeList.add(row); }
        for(int i = 0; i < datos.length; i++) {
            for(int j = 0; j < datos.length; j++) {
                datos[i][j] = Double.POSITIVE_INFINITY;
            }
        }
    }
    public void add(V label) {
        if (vert.containsKey(label)) return;
        int row = freeList.remove(0);
        vert.put(label, new vertice<>(label));
    }
}
