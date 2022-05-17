package ejercicio.fisei.morales_mario_prueba;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private int codigo=1;

    String nombre;
    String apellido;
    String base;
    String exponente;
    String factorial;
    String potencia;

    private EditText etNombre;
    private EditText etApellido;
    private EditText etBase;
    private EditText etExponente;
    private EditText etFactorial;
    private EditText etPotencia;

    private Button btnMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre=findViewById(R.id.etNombre);
        etApellido=findViewById(R.id.etApellido);
        etBase=findViewById(R.id.etBase);
        etExponente=findViewById(R.id.etExponente);
        etFactorial=findViewById(R.id.etFactorial);
        etPotencia=findViewById(R.id.etPotencia);

        btnMostrar=findViewById(R.id.btMostrarResultado);

        btnMostrar.setEnabled(false);

        etNombre.setEnabled(false);
        etApellido.setEnabled(false);
        etBase.setEnabled(false);
        etExponente.setEnabled(false);
        etFactorial.setEnabled(false);
        etPotencia.setEnabled(false);

    }

    public void OnclicSiguiente(View view){
        Intent intent = new Intent(this, SegundoActivity.class);
        startActivityForResult(intent, codigo);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String info;
        info =data.getDataString();
        String[] arreglo=info.split(",");

        nombre=arreglo[0];
        apellido=arreglo[1];
        base=arreglo[2];
        exponente=arreglo[3];
        factorial=arreglo[4];


        btnMostrar.setEnabled(true);
    }

    public void onclickMostrar(View view){

        //factorial = etFactorial.getText().toString();
        etNombre.setText(nombre.toUpperCase(Locale.ROOT));
        etApellido.setText(apellido.toUpperCase(Locale.ROOT));
        etBase.setText(base);
        etExponente.setText(exponente);
        etFactorial.setText(String.valueOf(factorial(Double.valueOf(factorial))));
        etPotencia.setText(String.valueOf(potencia(Integer.valueOf(base), Integer.valueOf(exponente))));
    }

    public double factorial(double numero){
        double factorial = 1;

        while ( numero!=0) {
            factorial=factorial*numero; numero--;
        }
        return factorial;
    }
    public int potencia(int base, int exponente){
        int result;
        if(exponente == 0){
            result = 1;
        }
        else{
            result = base * potencia(base, exponente - 1);
        }
        return result;
    }

}
