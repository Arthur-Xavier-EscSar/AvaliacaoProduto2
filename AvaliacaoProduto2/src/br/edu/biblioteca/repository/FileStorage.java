package br.edu.biblioteca.repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileStorage {

    public static List<String[]> lerCSV(String caminho) {
        List<String[]> linhas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    linhas.add(linha.split(","));
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo: " + caminho);
        }
        return linhas;
    }

    public static void escreverCSV(String caminho, List<String[]> dados) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(caminho))) {
            for (String[] campos : dados) {
                pw.println(String.join(",", campos));
            }
        } catch (IOException e) {
            System.err.println("Erro ao escrever arquivo: " + caminho);
        }
    }
}
