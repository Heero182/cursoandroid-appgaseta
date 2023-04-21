package devandroid.heero.appgaseta.controller;

import android.content.ContentValues;

import java.text.SimpleDateFormat;
import java.util.Locale;

import devandroid.heero.appgaseta.database.GasEtaDB;
import devandroid.heero.appgaseta.model.Combustivel;
import devandroid.heero.appgaseta.view.GasEtaActivity;

public class CombustivelController extends GasEtaDB {


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


        salvarObjeto("Combustivel", dados);
    }

    public void limpar(){

    }
}
