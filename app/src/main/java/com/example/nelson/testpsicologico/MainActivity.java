package com.example.nelson.testpsicologico;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

@SuppressWarnings("all")
public class MainActivity extends AppCompatActivity {
    public Typeface fuente;
    private Button btn_IniciarTest;
    private EditText edt_codigoLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //eliminar la barra de notificaciones
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btn_IniciarTest = (Button)findViewById(R.id.btn_iniciarTest);
        edt_codigoLogin=(EditText)findViewById(R.id.edt_codigoLogin);

        btn_IniciarTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validar()) {
                    Intent intent = new Intent(getApplicationContext(), Activity_test.class);
                    startActivity(intent);
                }
            }
        });

    }

    private boolean validar(){
        String codigo=edt_codigoLogin.getText().toString().trim();
        if(codigo.isEmpty() || codigo.length()<8 || !Patterns.PHONE.matcher(codigo).matches()){
            edt_codigoLogin.setError("Ingrese 8 digitos");
            return false;
        }else{
            edt_codigoLogin.setError(null);
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
