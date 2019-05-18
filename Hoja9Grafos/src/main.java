import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class main {
    private static Scanner input;
    public static void main(String[] args) throws IOException {
        input = new Scanner(System.in);
        String link = "guategrafo.txt";
        int size = tamaño(link);
        matrizDigrapho<String> myGraph = new matrizDigrapho<>(size);
        myGraph = LeerElDocumento(link ,myGraph);
        myGraph.floyd();
        myGraph.printGraph();
        boolean continuar = true;
        while (continuar){
            System.out.println(""
                    +"\n"
                    + "1. Valor mas corto en KM entre dos ciudades.\n"
                    + "2. Nombre de la ciudad que es el centro del grafo.\n"
                    + "3. Modificar grafo.\n"
                    + "4. Terminar.\n"
                    + "\n"
                    + "Elija la opcion:");
            String accion = (input.nextLine());
            switch (accion){
                case "1":
                    System.out.println("***************************************************");
                    System.out.println("Ingrese la ciudad de origen:");
                    String ciu1 = (input.nextLine());
                    if(myGraph.lista.contains(ciu1)){
                        System.out.println("Ingrese la ciudad destino:");
                        String ciu2 = (input.nextLine());
                        if(myGraph.lista.contains(ciu2)){
                            Double dist = myGraph.minDist(ciu1,ciu2);
                            if (dist != Double.POSITIVE_INFINITY){
                                System.out.println("\nDesde " +ciu1+" a "+ciu2+" la distancia mas corta es de "+dist+ "KM");
                            }else{
                                System.out.println("Estas ciudades no estan unidas directamente o indirectamente");
                            }
                        }else {
                            System.out.println("Esa ciudad no se encuentra disponivle");
                        }
                    }else {
                        System.out.println("Esa ciudad no se encuentra disponivle");
                    }
                    System.out.println("***************************************************");
                    break;
                case "2":
                        System.out.println("***************************************************");
                        System.out.println("La ciudad que es el centro del grafo es: "+myGraph.centro());
                        System.out.println("***************************************************");
                    break;
                case "3":
                        System.out.println(""
                                +"\n"
                                + "Que desea realizar:\n"
                                + " 1. Agregar una nueva conexion\n"
                                + " 2. Quitar una conexion\n"
                                + "Accion:");
                        String con = (input.nextLine());
                    switch (con){
                        case "1":
                            System.out.println("***************************************************");
                            System.out.println("Ingrese la ciudad de origen:");
                            String ori = (input.nextLine());
                            if(myGraph.lista.contains(ori)){
                                System.out.println("Ingrese la ciudad destino:");
                                String des = (input.nextLine());
                                if(myGraph.lista.contains(des)){
                                    System.out.println("Ingrese la distancia entre ellas:");
                                    double dis = (input.nextDouble());
                                    if(dis>0){
                                        myGraph.addEdge(ori,des,dis);
                                    }else{
                                        System.out.println("No se pueden ingresar numeros negativos");
                                    }
                                }else{
                                    System.out.println("Esa ciudad no se encuentra disponible");
                                }
                            }else{
                                System.out.println("Esa ciudad no se encuentra disponible");
                            }
                            myGraph.floyd();
                            myGraph.printGraph();
                            System.out.println("***************************************************");
                            break;
                        case "2":
                            System.out.println("***************************************************");
                            System.out.println("Ingrese la ciudad de origen:");
                            String or = (input.nextLine());
                            if(myGraph.lista.contains(or)){
                                System.out.println("Ingrese la ciudad destino:");
                                String de = (input.nextLine());
                                if(myGraph.lista.contains(de)){
                                    myGraph.removeEdge(or,de);
                                    System.out.println("Se ha eliminado la conexion entre "+or+" y "+de);
                                }else{
                                    System.out.println("Esa ciudad no se encuentra disponible");
                                }
                            }else{
                                System.out.println("Esa ciudad no se encuentra disponible");
                            }
                            myGraph.floyd();
                            myGraph.printGraph();
                            System.out.println("***************************************************");
                            break;
                        default:
                            System.out.println("Esa opcion no existe");
                            break;
                    }
                    break;
                case "4":
                    continuar = false;
                    break;
                default:
                    System.out.println("Esa opcion no existe");
                    break;
            }
        }
    }



    /**Autor:  Pankaj Kumar
     * Fuente:  Articulo "Different ways of Reading a text file in Java" de la pagina GeeksForGeeks
     * Codigo para leer documentos .txt, extraido de https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
     * y modificado para funcionalidad de la Hoja de Trabajo
     * @param nombre nombre del archivo txt
     * @param nuevoGrafo el grafo donde se meteran los datos
     * @return deseado con las cartas ingresadas
     * @throws IOException  error si el archivo .txt no es encontrado
     */
    private static matrizDigrapho<String> LeerElDocumento(String nombre, matrizDigrapho nuevoGrafo) throws IOException {
        File file = new File(nombre);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null){
            String[] parts = line.split(" ");
            String lugar1 = parts[0];
            if(!nuevoGrafo.lista.contains(lugar1)){
                nuevoGrafo.add(lugar1);
            }
            String lugar2 = parts[1];
            if(!nuevoGrafo.lista.contains(lugar2)){
                nuevoGrafo.add(lugar2);
            }
            int distancia = Integer.parseInt(parts[2]);
            nuevoGrafo.addEdge(lugar1,lugar2,distancia);
        }
        return nuevoGrafo;
    }
    /**Autor:  Pankaj Kumar
     * Fuente:  Articulo "Different ways of Reading a text file in Java" de la pagina GeeksForGeeks
     * Codigo para leer documentos .txt, extraido de https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
     * y modificado para funcionalidad de la Hoja de Trabajo, metodo auxiliar para saber el tamaño de la matriz
     * @param nombre nombre del archivo txt
     * @return deseado con las cartas ingresadas
     * @throws IOException  error si el archivo .txt no es encontrado
     */
    private static int tamaño(String nombre) throws IOException {
        File file = new File(nombre);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        ArrayList<String> palabras = new ArrayList<>();
        while((line = br.readLine()) != null){
            String[] parts = line.split(" ");
            String lugar1 = parts[0];
            if(!palabras.contains(lugar1)){
                palabras.add(lugar1);
            }
            String lugar2 = parts[1];
            if(!palabras.contains(lugar2)){
                palabras.add(lugar2);
            }
        }
        return palabras.size();
    }

}
