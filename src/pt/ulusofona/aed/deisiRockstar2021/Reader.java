package pt.ulusofona.aed.deisiRockstar2021;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {
    public static ArrayList<String> read(String filename) {
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fr);
            String linha = reader.readLine();
            ArrayList<String> lines = new ArrayList<>();
            while ((linha = reader.readLine()) != null) {
                lines.add(linha);
            }
            reader.close();
            return lines;
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro não encontrado");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro durante a leitura.");
        }
        return null;
    }
}
