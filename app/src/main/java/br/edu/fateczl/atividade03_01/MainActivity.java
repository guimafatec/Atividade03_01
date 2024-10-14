package br.edu.fateczl.atividade03_01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    /*
     *@author: Gustavo Guimarães de Oliveira
     */
    private EditText etGasolina;
    private EditText etEtanol;
    private TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etGasolina = findViewById(R.id.etGasolina);
        etGasolina.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etEtanol = findViewById(R.id.etEtanol);
        etEtanol.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        Button btnCalc = findViewById(R.id.btnCalc);
        tvRes = findViewById(R.id.tvRes);
        tvRes.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        btnCalc.setOnClickListener(op -> calc());
    }

    private void calc() {
        float vl_gasolina = Float.parseFloat(etGasolina.getText().toString());
        float vl_etanol = Float.parseFloat(etEtanol.getText().toString());
        float ratio = vl_etanol / vl_gasolina;
        String combustivel = ratio <= 0.7 ? "Etanol" : "Gasolina";
        StringBuilder res_final;
        res_final = new StringBuilder(getString(R.string.res_final));
        res_final.append(" ");
        res_final.append(combustivel);
        res_final.append("\n");
        res_final.append("Pois o etanol custa ");
        res_final.append(ratio * 100);
        res_final.append("% do valor da gasolina");
        tvRes.setText(res_final.toString());
        etGasolina.setText("");
        etEtanol.setText("");
    }
}