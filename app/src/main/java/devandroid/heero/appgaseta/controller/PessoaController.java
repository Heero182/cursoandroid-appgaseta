package devandroid.heero.appgaseta.controller;

import android.content.SharedPreferences;
import android.util.Log;

import devandroid.heero.appgaseta.model.Pessoa;
import devandroid.heero.appgaseta.view.MainActivity;

public class PessoaController {

    public static final String NOME_PREFERENCES = "pref_listavip";
    public static final String PRIMEIRO_NOME = "primeiroNome";
    public static final String SOBRENOME = "sobrenome";
    public static final String CURSO_DESEJADO = "cursoDesejado";
    public static final String TELEFONE_CONTATO = "telefoneContato";
    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;

    public PessoaController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES ,0);
        listaVip = preferences.edit();
    }

    public void salvar(Pessoa pessoa) {
        listaVip.putString(PRIMEIRO_NOME, pessoa.getPrimeiroNome());
        listaVip.putString(SOBRENOME, pessoa.getSobrenome());
        listaVip.putString(CURSO_DESEJADO, pessoa.getCursoDesejado());
        listaVip.putString(TELEFONE_CONTATO, pessoa.getTelefoneContato());
        listaVip.apply();

        Log.d("PessoaController", "Salvo: " + pessoa);
    }

    public Pessoa buscar() {
        Pessoa pessoa = new Pessoa();
        pessoa.setPrimeiroNome(preferences.getString(PRIMEIRO_NOME, ""));
        pessoa.setSobrenome(preferences.getString(SOBRENOME, ""));
        pessoa.setCursoDesejado(preferences.getString(CURSO_DESEJADO, ""));
        pessoa.setTelefoneContato(preferences.getString(TELEFONE_CONTATO, ""));

        return pessoa;
    }

    public void limpar() {
        listaVip.clear();
        listaVip.apply();

    }

}
