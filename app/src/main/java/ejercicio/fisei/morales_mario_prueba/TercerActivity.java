package ejercicio.fisei.morales_mario_prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class TercerActivity extends AppCompatActivity {

    private EditText et2Nombre;
    private EditText et2Apellido;
    private EditText et2Base;
    private EditText et2Exponente;
    private EditText et2Factorial;

    String nombre;
    String apellido;
    String base;
    String exponente;
    String factorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercer);

        et2Nombre = findViewById(R.id.et2Nombre);
        et2Apellido = findViewById(R.id.et2Apellido);
        et2Base = findViewById(R.id.et2Base);
        et2Exponente = findViewById(R.id.et2Exponente);
        et2Factorial = findViewById(R.id.et2NumFactorial);

    }

    public void onClickCerrar(View view){
        nombre = et2Nombre.getText().toString();
        apellido = et2Apellido.getText().toString();
        base = et2Base.getText().toString();
        exponente = et2Exponente.getText().toString();
        factorial = et2Factorial.getText().toString();

        Intent intent = new Intent();
        intent.setData(Uri.parse(nombre+"," +apellido+","+base+","+exponente+","+factorial));
        setResult(Activity.RESULT_OK, intent);
        finish();

    }
}
