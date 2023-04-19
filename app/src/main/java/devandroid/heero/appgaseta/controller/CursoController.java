package devandroid.heero.appgaseta.controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.heero.appgaseta.model.Curso;

public class CursoController {

    public List<Curso> getListaCursos() {
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Android"));
        cursos.add(new Curso("HTML"));
        cursos.add(new Curso("Java"));
        cursos.add(new Curso("Kotlin"));
        cursos.add(new Curso("C#"));
        cursos.add(new Curso("Python"));

        return cursos;
    }

    public List<String> dadosSpinner(){
        List<String> dados = new ArrayList<>();

        getListaCursos().forEach(curso -> dados.add(curso.getNome()));

        return dados;
    }
}
