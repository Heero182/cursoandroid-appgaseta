package devandroid.heero.appgaseta.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import devandroid.heero.appgaseta.model.Combustivel;

public class GasEtaDB extends SQLiteOpenHelper {

    private static final String DB_NAME = "gaseta.db";
    private static final int DB_VERSION = 1;

    Cursor cursor;

    SQLiteDatabase db;

    public GasEtaDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // DDL CRIAR TABELA COMBUSTIVEL
        String sqlTabelaCombustivel = "CREATE TABLE Combustivel (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " nomeCombustivel TEXT, precoCombustivel REAL, dataAtualizacao DATETIME )";

        db.execSQL(sqlTabelaCombustivel);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void salvarObjeto(String tabela, ContentValues dados) {
        db.insert(tabela, null, dados);
    }

    public List<Combustivel> listarDados() throws ParseException {

        List<Combustivel> listaCombustivel = new ArrayList<>();
        cursor = db.rawQuery("Select * from Combustivel", null);

        if(cursor.moveToFirst()){
            SimpleDateFormat dateFormat = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            do{
                Combustivel combustivel = new Combustivel();

                combustivel.setId(cursor.getInt(0));
                combustivel.setNomeCombustivel(cursor.getString(1));
                combustivel.setPrecoCombustivel(cursor.getDouble(2));
                String dataAtualizacaoString = cursor.getString(3);
                combustivel.setDataAtualizacao(dateFormat.parse(dataAtualizacaoString));

                listaCombustivel.add(combustivel);
            }while (cursor.moveToNext());
        }

        return listaCombustivel;
    }

    public void alterarDados(String tabela, ContentValues dados) {
        int id = dados.getAsInteger("id");

        db.update(tabela, dados, "id=?", new String[]{Integer.toString(id)});

    }

    public void deletarDados(String tabela, Integer id) {

        db.delete(tabela,"id=?", new String[]{Integer.toString(id)});

    }
}
