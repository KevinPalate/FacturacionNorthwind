package com.example.final_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Pantalla3 extends AppCompatActivity {

    EditText etNombres, etApellidos, etDividendo, etDivisor, etNumero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pantalla3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etNombres = findViewById(R.id.etNombres);
        etApellidos = findViewById(R.id.etApellidos);
        etDividendo = findViewById(R.id.etDividendo);
        etDivisor = findViewById(R.id.etDivisor);
        etNumero = findViewById(R.id.etNumero);
        
        Bundle b = this.getIntent().getExtras();
        etNombres.setText(b.getString("nombres"));
        etApellidos.setText(b.getString("apellidos"));
    }
    
    public void btnHome(View v){
        String numero = etNumero.getText().toString();
        String dividendo = etDividendo.getText().toString();
        String divisor = etDivisor.getText().toString();
        
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("multiplicacion",obtenerMultiplicacion());
        i.putExtra("factorial",obtFactorial());
        startActivity(i);
    }

    private String obtFactorial() {

    }

    private String obtenerMultiplicacion() {
        return null;
    }

    // Método para calcular el factorial de un número
    private String obtFactorial2() {
        String numeroStr = etNumero.getText().toString();

        if (numeroStr.isEmpty()) {
            return "Error: campo vacío";
        }

        int numero = Integer.parseInt(numeroStr);
        long resultado = 1;

        for (int i = 1; i <= numero; i++) {
            resultado *= i;
        }

        return String.valueOf(resultado);
    }

    // Metodo para calcular la multiplicación de dos números
    private String obtenerMultiplicacion2() {
        String num1Str = etDividendo.getText().toString();
        String num2Str = etDivisor.getText().toString();

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            return "Error: campos vacíos";
        }

        int num1 = Integer.parseInt(num1Str);
        int num2 = Integer.parseInt(num2Str);

        int resultado = num1 * num2;

        return String.valueOf(resultado);
    }


    private String obtFactorial3() {
        String numeroStr = etNumero.getText().toString();

        int numero = Integer.parseInt(numeroStr);
        long resultado = factorialRecursivo3(numero);

        return String.valueOf(resultado);
    }

    private long factorialRecursivo3(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorialRecursivo3(n - 1);
    }

    private String obtenerMultiplicacion() {
        String num1Str = etNum1.getText().toString();
        String num2Str = etNum2.getText().toString();

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            return "Error: campos vacíos";
        }

        int num1 = Integer.parseInt(num1Str);
        int num2 = Integer.parseInt(num2Str);

        int resultado = multiplicarPorSuma(num1, num2);

        return String.valueOf(resultado);
    }

    private int multiplicarPorSuma(int a, int b) {
        int resultado = 0;
        boolean negativo = false;

        // Manejo de signos
        if (a < 0) {
            a = -a;
            negativo = !negativo;
        }
        if (b < 0) {
            b = -b;
            negativo = !negativo;
        }

        // Suma repetida
        for (int i = 0; i < b; i++) {
            resultado += a;
        }

        return negativo ? -resultado : resultado;
    }
}