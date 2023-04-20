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

public class GasEtaActivity extends AppCompatActivity {

    EditText editGasolina;
    EditText editEtanol;

    Button btnCalcular;
    Button btnLimpar;
    Button btnFinalizar;

    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gas_eta);

        editGasolina = findViewById(R.id.editGasolina);
        editEtanol = findViewById(R.id.editEtanol);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnFinalizar = findViewById(R.id.btnFinalizar);
        txtResultado = findViewById(R.id.txtResultado);

        btnCalcular.setOnClickListener(v -> {
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
                double gasolina = Double.valueOf(editGasolina.getText().toString());
                double etanol = Double.valueOf(editEtanol.getText().toString());


                txtResultado.setText(UtilGasEta.calcularMelhorOpcao(gasolina, etanol));
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


    }
}