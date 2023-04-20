package devandroid.heero.appgaseta.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import devandroid.heero.appgaseta.R;
import devandroid.heero.appgaseta.apoio.UtilGasEta;
import devandroid.heero.appgaseta.model.Combustivel;

public class GasEtaActivity extends AppCompatActivity {

    EditText editGasolina;
    EditText editEtanol;

    Button btnCalcular;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    TextView txtResultado;
    private double precoGasolina;
    private double precoEtanol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gas_eta);

        editGasolina = findViewById(R.id.editGasolina);
        editEtanol = findViewById(R.id.editEtanol);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnSalvar.setEnabled(false);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnFinalizar = findViewById(R.id.btnFinalizar);
        txtResultado = findViewById(R.id.txtResultado);

        btnCalcular.setOnClickListener(v -> {
            btnSalvar.setEnabled(false);
            boolean temErro = false;

            if(TextUtils.isEmpty(editGasolina.getText())){
                editGasolina.setError("* Obrigatorio");
                editGasolina.requestFocus();
                temErro = true;
            }

            if(TextUtils.isEmpty(editEtanol.getText())){
                editEtanol.setError("* Obrigatorio");
                if(!temErro) {
                    editEtanol.requestFocus();
                }
                temErro = true;
            }

            if(!temErro) {
                precoGasolina = Double.valueOf(editGasolina.getText().toString());
                precoEtanol = Double.valueOf(editEtanol.getText().toString());


                txtResultado.setText(UtilGasEta.calcularMelhorOpcao(precoGasolina, precoEtanol));
                btnSalvar.setEnabled(true);
            }else{
                Toast.makeText(GasEtaActivity.this, "Por favor, digite os dados obrigatorios!", Toast.LENGTH_LONG).show();
            }
        });

        btnLimpar.setOnClickListener(v -> {
            editGasolina.setText("");
            editEtanol.setText("");
            txtResultado.setText(R.string.txt_resultado);
        });

        btnFinalizar.setOnClickListener(v -> {
            Toast.makeText(GasEtaActivity.this, "Volte Sempre", Toast.LENGTH_LONG).show();
            finish();
        });

        btnSalvar.setOnClickListener(v -> {
            Combustivel combustivelGasolina = new Combustivel();
            combustivelGasolina.setNomeCombustivel("Gasolina");
            combustivelGasolina.setPrecoCombustivel(precoGasolina);

            Combustivel combustivelEtanol = new Combustivel();
            combustivelEtanol.setNomeCombustivel("Etanol");
            combustivelEtanol.setPrecoCombustivel(precoEtanol);

            Toast.makeText(GasEtaActivity.this, "SALVO!", Toast.LENGTH_LONG).show();
        });



    }
}