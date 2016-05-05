package com.example.nelson.testpsicologico;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

@SuppressWarnings("all")
public class Activity_test extends AppCompatActivity implements HiloPrincipal.Hilo {

    private RecyclerView recyclerTest;
    public static TextView txt_resultado;
    public static  int resultados[]=new int[40];
    private AdapterRecyclerViewTest adaptador;
    private ProgressBar pb_BarraProgreso;
    private  Button btn_enviar;
    public static boolean finalizarTest=false;
    public static ArrayList<Preguntas> listaDePreguntas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        //eliminar la barra de notificaciones
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        txt_resultado=(TextView)findViewById(R.id.txt_resultado);
        pb_BarraProgreso=(ProgressBar)findViewById(R.id.pb_barraProgreso);
        btn_enviar=(Button)findViewById(R.id.btn_enviar);

       recyclerTest = (RecyclerView)findViewById(R.id.recyclerTest);
       listaDePreguntas=Preguntas.listaTotalPreguntas();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
       adaptador = new AdapterRecyclerViewTest(listaDePreguntas,this);
       recyclerTest.setAdapter(adaptador);
       recyclerTest.setLayoutManager(linearLayoutManager);
       recyclerTest.setHasFixedSize(true);



        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int PreguntasXcontestar = 40-AdapterRecyclerViewTest.contadorDePreguntas;

                    if (PreguntasXcontestar==0){
                        CrearDiaogo(" Test Finalizado !!");
                        Activity_test.finalizarTest=true;

                    }else{
                     CrearDiaogo("Faltan responder "+PreguntasXcontestar+" Preguntas!");
                    }
            }
        });

        //cuando se rota la pantalla
        HiloPrincipal.crearHilo(this);



   }

    @Override
    protected void onDestroy() {
        super.onDestroy();
          for(int i=0; i<resultados.length;i++){
              resultados[i]=0;
          }
        pb_BarraProgreso.setProgress(0);
    }


    @Override
    protected void onPostResume() {
        super.onPostResume();



    }

    public void CrearDiaogo(String mensaje){
       AlertDialog.Builder  builder;
       final AlertDialog alertDialog;

       LayoutInflater layoutInflater = this.getLayoutInflater();
       View v = layoutInflater.inflate(R.layout.layout_dialogo,null);


       Button btn_aceptar = (Button)v.findViewById(R.id.btn_aceptar);
       TextView txt_mensaje = (TextView)v.findViewById(R.id.txt_mensaje);
        txt_mensaje.setText(mensaje);
        builder = new AlertDialog.Builder(this);
        builder.setView(v);
        alertDialog = builder.create();

       btn_aceptar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              if(Activity_test.finalizarTest){
                  alertDialog.dismiss();
                  Intent intent = new Intent(getApplication(),MainActivity.class);
                  startActivity(intent);
              } else{
                  alertDialog.dismiss();
              }


           }
       });

        alertDialog.show();
       }



    @Override
    public void SumaPuntajeTest(int sumaPuntaje) {
       // txt_resultado.setText(String.valueOf(sumaPuntaje));
    }

    @Override
    public void ContadorDePreguntas(int progreso) {
        pb_BarraProgreso.setProgress(progreso);
    }
}
