package devandroid.heero.appgaseta.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import devandroid.heero.appgaseta.R;


public class SplashActivity extends AppCompatActivity {

    public static final int TIME_OUT_SPLASH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        comutarTelaSplash();
        finish();
    }

    private void comutarTelaSplash() {
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, GasEtaActivity.class);
            startActivity(intent);
        }, TIME_OUT_SPLASH);
    }
}