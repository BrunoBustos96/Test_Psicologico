package com.example.nelson.testpsicologico;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by nelson on 01/05/2016.
 */
@SuppressWarnings("all")


public  class HiloPrincipal extends AsyncTask<int [],Integer,Integer> {

        private  Hilo objeto;
        private  int contadorPreguntas;

        public  HiloPrincipal(Hilo obj ){

             objeto = obj;
            contadorPreguntas=AdapterRecyclerViewTest.contadorDePreguntas;


        }

    public static void crearHilo(Hilo hilo){
        HiloPrincipal  hiloPrincipal = new HiloPrincipal(hilo);
        hiloPrincipal.execute(Activity_test.resultados);

    }

    //interface
    public interface  Hilo{
        void SumaPuntajeTest(int sumaPuntaje);
        void ContadorDePreguntas(int progreso);

    }


        @Override
        protected Integer doInBackground(int[]... params) {
            int  arreglo[]= params[0];
            int suma=0;
            for(int i=0; i<arreglo.length;i++){
                suma=suma+arreglo[i];

            }
            return suma;
        }


        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            this.objeto.SumaPuntajeTest(integer);
            double porcentaje= (Math.rint((contadorPreguntas/(double)40)*1000)/1000)*100;
            this.objeto.ContadorDePreguntas((int)porcentaje);
            Log.d("MSM_contador",String.valueOf(contadorPreguntas));
            Log.d("MSM_2",String.valueOf(porcentaje));
        }


        @Override
        protected void onCancelled(Integer integer) {
            super.onCancelled(integer);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }




}




