package devandroid.heero.appgaseta.controller;

import android.content.ContentValues;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import devandroid.heero.appgaseta.database.GasEtaDB;
import devandroid.heero.appgaseta.model.Combustivel;
import devandroid.heero.appgaseta.view.GasEtaActivity;

public class CombustivelController extends GasEtaDB {


    public static final String COMBUSTIVEL = "Combustivel";

    public CombustivelController(GasEtaActivity gasEtaActivity) {
        super(gasEtaActivity);
    }

    public void salvar(Combustivel combustivel) {

        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        ContentValues dados = new ContentValues();
        dados.put("nomeCombustivel", combustivel.getNomeCombustivel());
        dados.put("precoCombustivel", combustivel.getPrecoCombustivel());
        dados.put("dataAtualizacao", dateFormat.format(combustivel.getDataAtualizacao()));


        salvarObjeto(COMBUSTIVEL, dados);
    }

    public void limpar() {

    }

    public List<Combustivel> getListaDados() {
        try {
            return listarDados();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void alterar(Combustivel combustivel) {

        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        ContentValues dados = new ContentValues();
        dados.put("id", combustivel.getId());
        dados.put("nomeCombustivel", combustivel.getNomeCombustivel());
        dados.put("precoCombustivel", combustivel.getPrecoCombustivel());
        dados.put("dataAtualizacao", dateFormat.format(combustivel.getDataAtualizacao()));

        alterarDados(COMBUSTIVEL, dados);
    }

    public void deletar(Combustivel combustivel) {

        deletarDados(COMBUSTIVEL, combustivel.getId());

    }
}
