import junit.framework.TestCase;

public class matrizDigraphoTest extends TestCase {
    /**
     * Prueba para añadir un nodo
     */
    public void testAdd() {
        matrizDigrapho prueba = new matrizDigrapho(4);
        prueba.add("Rosa");
        boolean resul = prueba.lista.contains("Rosa");
        assertEquals(true,resul);
    }
    /**
     * Prueba para añadir un arco
     */
    public void testAddEdge() {
        matrizDigrapho prueba = new matrizDigrapho(2);
        prueba.add("Rosa");
        prueba.add("Lucia");
        String resul =prueba.addEdge("Rosa","Lucia",50);
        prueba.printGraph();
        assertEquals("¡Union realizada!",resul);
    }
    /**
     * Prueba para quitar un arco
     */
    public void testRemoveEdge() {
        matrizDigrapho prueba = new matrizDigrapho(3);
        prueba.add("Rosa");
        prueba.add("Lucia");
        prueba.add("Pedro");
        prueba.addEdge("Rosa","Lucia",50);
        prueba.addEdge("Rosa","Pedro",25);
        prueba.printGraph();
        String resul = prueba.removeEdge("Rosa","Pedro");
        prueba.printGraph();
        assertEquals("Se ha quitado el camino",resul);
    }
    /**
     * Prueba del algoritmo de Floyd
     */
    public void testFloyd() {
        matrizDigrapho prueba = new matrizDigrapho(3);
        prueba.add("Rosa");
        prueba.add("Lucia");
        prueba.add("Pedro");
        prueba.addEdge("Rosa","Lucia",50);
        prueba.addEdge("Lucia","Pedro",25);
        prueba.addEdge("Pedro","Rosa",25);
        prueba.printGraph();
        prueba.datos = prueba.floyd(prueba.datos);
        prueba.printGraph();
    }
}