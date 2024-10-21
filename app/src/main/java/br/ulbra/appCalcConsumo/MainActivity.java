package br.ulbra.appCalcConsumo;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtPotencia, edtTempodeUso, edtPrecoKwh;
    Button btnCalcular;
    TextView txtConsumoEnergia, txtCustoAssociado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edtPotencia = findViewById(R.id.edtPotencia);
        edtTempodeUso = findViewById(R.id.edtTempodeUso);
        edtPrecoKwh = findViewById(R.id.edtPrecoKwh);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double Potencia, Tempuso, PrecoKwh, r1, r2;
                try {
                    Potencia = Double.parseDouble(edtPotencia.getText().toString());
                    Tempuso = Double.parseDouble(edtTempodeUso.getText().toString());
                    PrecoKwh = Double.parseDouble(edtPrecoKwh.getText().toString());
                    r1 = (Potencia * Tempuso) / 1000;
                    r2 = r1 * PrecoKwh;
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Resultado:");
                    builder.setMessage("O consumo de energia foi: " + r1 + " kWh\nO custo associado foi: R$ " + r2);
                    builder.setPositiveButton("OK", null);  // Add a button to dismiss the dialog
                    builder.show();

                }catch (NumberFormatException e) {
                    //Trata o erro caso algum campo esteja vazio ou tenha um valor inválido
                    Toast.makeText(view.getContext(),"Por favor, preencha ambos os campos com númros válidos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}