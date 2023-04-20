package devandroid.heero.appgaseta.controller;

import android.content.SharedPreferences;

import devandroid.heero.appgaseta.model.Combustivel;
import devandroid.heero.appgaseta.view.GasEtaActivity;

public class CombustivelController {

    SharedPreferences preferences;
    SharedPreferences.Editor dadosCombustiveis;

    public static final String NOME_PREFERENCES = "pref_gaseta";

    public CombustivelController(GasEtaActivity gasEtaActivity) {
        preferences = gasEtaActivity.getSharedPreferences(NOME_PREFERENCES, 0);

        dadosCombustiveis = preferences.edit();
    }

    public void salvar(Combustivel combustivelGasolina, Combustivel combustivelEtanol) {
        dadosCombustiveis.putString("combustivel_1", combustivelGasolina.getNomeCombustivel());
        dadosCombustiveis.putFloat("preco_gasolina", combustivelGasolina.getPrecoCombustivel().floatValue());

        dadosCombustiveis.putString("combustivel_2", combustivelEtanol.getNomeCombustivel());
        dadosCombustiveis.putFloat("preco_etanol", combustivelEtanol.getPrecoCombustivel().floatValue());

        dadosCombustiveis.apply();
    }

    public void limpar(){
        dadosCombustiveis.clear();
        dadosCombustiveis.apply();
    }
}
