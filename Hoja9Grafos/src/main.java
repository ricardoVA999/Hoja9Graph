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
