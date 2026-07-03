package br.edu.biblioteca.model;
import br.edu.biblioteca.model.*;
import br.edu.biblioteca.structures.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class UndoRedoService {

    private MinhaPilha<String> desfazer = new MinhaPilha<>();
    private MinhaPilha<String> refazer = new MinhaPilha<>();

    public void registrarAcao(String acao) {
        desfazer.push(acao);
    }

    public void desfazer() {

        if (!desfazer.isEmpty()) {

            String acao = desfazer.pop();
            refazer.push(acao);

            System.out.println("Desfeita: " + acao);
        }
    }

    public void refazer() {

        if (!refazer.isEmpty()) {

            String acao = refazer.pop();
            desfazer.push(acao);

            System.out.println("Refeita: " + acao);
        }
    
    }
   
}
