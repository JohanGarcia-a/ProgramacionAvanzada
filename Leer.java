package Tarea013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leer {
    public static String leer(String mensaje) throws IOException {
        System.out.println(mensaje);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine().trim(); 
    }
}
