import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

public class Expresiones {
    public static void main(String[] args) {
        String[] expresionesRegulares = {
                "\\bHola mundo\\b",
                "\\bHola mundo\\b",
                "\\b(?:Java|Python|Go|Pascal|Perl)\\b",
                "^[A-Za-z0-9._%+-]+@(?:unison|uson)\\\\.mx$",
                "^ISI\\d{4}-[12]\\.(?:txt|csv)$"
        };

        String[] cadenas = {
                "Hola mundo",
                "hola mundo",
                "Java",
                "test@unison.mx",
                "ISI2022-1.csv"
        };

        String guardarEnArchivo = "expresiones_regulares.txt"; // Archivo de salida

        try (FileWriter fw = new FileWriter(guardarEnArchivo)) {
            for (int i = 0; i < expresionesRegulares.length; i++) {
                String expresion = expresionesRegulares[i];
                String resultados = "";

                for (String cadena : cadenas) {
                    boolean validar = Pattern.matches(expresion, cadena);
                    resultados += "Cadena: \"" + cadena + "\" - " + (validar ? "Válida" : "No válida") + "\n";

                    // Imprimir en la consola
                    System.out.println("Expresión regular #" + (i + 1) + ": " + expresion);
                    System.out.println("Cadena: \"" + cadena + "\" - " + (validar ? "Válida" : "No válida"));
                    System.out.println();
                }

                // ESCRIBIR EN EL ARCHIVO
                fw.write("Expresión regular " + (i + 1) + ":\n");
                fw.write(expresion + "\n\n");
                fw.write(resultados + "\n");
            }

            System.out.println("Resultados guardados en " + guardarEnArchivo);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}