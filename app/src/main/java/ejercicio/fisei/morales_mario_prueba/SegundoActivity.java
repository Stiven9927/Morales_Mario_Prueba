package ejercicio.fisei.morales_mario_prueba;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SegundoActivity extends AppCompatActivity {

    private int codigo=1;
    private EditText et1Nombre;
    private EditText et1Base;
    private Button bt1Cerrar;
    private Button bt1Siguiente;
    String nombre;
    String base;

    String apellido;
    String exponente;
    String factorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        et1Nombre = findViewById(R.id.et1Nombre);
        et1Base = findViewById(R.id.et1Base);
        bt1Cerrar = findViewById(R.id.bt1Cerrar);
        bt1Siguiente = findViewById(R.id.bt1Siguiente);

        bt1Cerrar.setEnabled(false);
        et1Nombre.setEnabled(false);
        et1Base.setEnabled(false);
    }

    public void OnclickSiguiente(View view){
        Intent intent = new Intent(this, TercerActivity.class);
        startActivityForResult(intent, codigo);
        setResult(Activity.RESULT_OK, intent);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String info;
        info=data.getDataString();
        String[] arreglo= info.split(",");

        nombre=arreglo[0];
        apellido=arreglo[1];
        base=arreglo[2];
        exponente = arreglo[3];
        factorial = arreglo[4];

        bt1Cerrar.setEnabled(true);

    }

    public void onClickCerrar(View view){

        Intent intent = new Intent();
        intent.setData(Uri.parse(nombre+","+apellido+","+base+","+exponente+","+factorial));
        setResult(Activity.RESULT_OK, intent);
        finish();

    }
}

