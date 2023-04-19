package devandroid.heero.appgaseta.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import devandroid.heero.appgaseta.R;

public class GasEtaActivity extends AppCompatActivity {

    EditText editGasolina;
    EditText editEtanol;

    Button btnCalcular;

    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gas_eta);

        editGasolina = findViewById(R.id.editGasolina);
        editEtanol = findViewById(R.id.editEtanol);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtResultado = findViewById(R.id.txtResultado);

        btnCalcular.setOnClickListener(v -> {
            Double gasolina = Double.valueOf(editGasolina.getText().toString());
            Double etanol = Double.valueOf(editEtanol.getText().toString());


            txtResultado.setText(etanol / gasolina > 0.7 ? "Gasolina" : "Etanol");
        });


    }
}