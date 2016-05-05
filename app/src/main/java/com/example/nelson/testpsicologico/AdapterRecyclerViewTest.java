package com.example.nelson.testpsicologico;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nelson on 30/04/2016.
 */

@SuppressWarnings("all")
public class AdapterRecyclerViewTest extends RecyclerView.Adapter<AdapterRecyclerViewTest.itemLayout>  {

    private ArrayList<Preguntas>listaPregunta;
    private HiloPrincipal.Hilo interfaz;
    public static int contadorDePreguntas;


public AdapterRecyclerViewTest(ArrayList<Preguntas> ls, HiloPrincipal.Hilo hilo){
     listaPregunta=ls;
    interfaz= hilo;
    contadorDePreguntas=0;

}

    class itemLayout extends RecyclerView.ViewHolder{

        private TextView txt_numPregunta;
        private TextView txt_pregunta;

        private LinearLayout linearLayoutPrincipal;
        private LinearLayout linearLayoutBotones;
        private LinearLayout linearLayoutCheck;

        private Button btn_nunca;
        private Button btn_algunas;
        private Button btn_muchas;
        private Button btn_casiSiempre;

         private  Boolean estado=false;

        private View view;

        public itemLayout(View itemView) {
            super(itemView);
            view = itemView;
            txt_numPregunta= (TextView)itemView.findViewById(R.id.txt_numPregunta);
            txt_pregunta =(TextView)itemView.findViewById(R.id.txt_pregunta);

            linearLayoutPrincipal=(LinearLayout)itemView.findViewById(R.id.linearLayout_principal);
            linearLayoutBotones=(LinearLayout)itemView.findViewById(R.id.linearLayoutBotones);
            linearLayoutCheck=(LinearLayout)itemView.findViewById(R.id.linearLayoutCheck);

            btn_nunca=(Button)itemView.findViewById(R.id.btn_Nunca);
            btn_algunas=(Button)itemView.findViewById(R.id.btn_Algunas);
            btn_muchas=(Button)itemView.findViewById(R.id.btn_Muchas);
            btn_casiSiempre=(Button)itemView.findViewById(R.id.btn_casiSiempre);


        }


    }

    @Override
    public itemLayout onCreateViewHolder(ViewGroup parent, int viewType) {
         View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_test,parent,false);
         return new itemLayout(v);
    }

    @Override
    public void onBindViewHolder(final itemLayout holder, final int position) {
             final Preguntas pregunta =  listaPregunta.get(position);

           holder.txt_numPregunta.setText(String.valueOf(position+1));
           holder.txt_pregunta.setText(pregunta.getPregunta());

        //verificando el ESTADO DEL LA PREGUNTA
        if (pregunta.getEstadoCheck()){
            holder.linearLayoutBotones.setVisibility(View.GONE);
            holder.linearLayoutCheck.setVisibility(View.VISIBLE);
         }

          if (!pregunta.getEstadoCheck()){
              holder.linearLayoutCheck.setVisibility(View.GONE);
              holder.linearLayoutBotones.setVisibility(View.VISIBLE);
          }


           //boton nunca
           holder.btn_nunca.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   holder.linearLayoutBotones.setVisibility(View.GONE);
                   holder.linearLayoutCheck.setVisibility(View.VISIBLE);

                   Activity_test.resultados[position]=pregunta.getPuntuacion()[0];
                   contadorDePreguntas=contadorDePreguntas+1;
                   HiloPrincipal.crearHilo(interfaz);

                   pregunta.setEstadoCheck(true);
                   listaPregunta.set(position,pregunta);

               }
           });
            //boton algunas
            holder.btn_algunas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.linearLayoutBotones.setVisibility(View.GONE);
                    holder.linearLayoutCheck.setVisibility(View.VISIBLE);


                    Activity_test.resultados[position]=pregunta.getPuntuacion()[1];
                    contadorDePreguntas=contadorDePreguntas+1;
                    HiloPrincipal.crearHilo(interfaz);

                    pregunta.setEstadoCheck(true);
                    listaPregunta.set(position,pregunta);


                }
            });

            //boton muchas
            holder.btn_muchas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.linearLayoutBotones.setVisibility(View.GONE);
                    holder.linearLayoutCheck.setVisibility(View.VISIBLE);

                    Activity_test.resultados[position]=pregunta.getPuntuacion()[2];
                    contadorDePreguntas=contadorDePreguntas+1;
                    HiloPrincipal.crearHilo(interfaz);


                    pregunta.setEstadoCheck(true);
                    listaPregunta.set(position,pregunta);

                }
            });

           //boton casiSiempre
           holder.btn_casiSiempre.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   holder.linearLayoutBotones.setVisibility(View.GONE);
                   holder.linearLayoutCheck.setVisibility(View.VISIBLE);

                   Activity_test.resultados[position]=pregunta.getPuntuacion()[3];
                   contadorDePreguntas=contadorDePreguntas+1;
                   HiloPrincipal.crearHilo(interfaz);


                   pregunta.setEstadoCheck(true);
                   listaPregunta.set(position,pregunta);
               }
           });



         holder.linearLayoutCheck.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 holder.linearLayoutCheck.setVisibility(View.GONE);
                 holder.linearLayoutBotones.setVisibility(View.VISIBLE);

                 Activity_test.resultados[position]=0;
                 contadorDePreguntas=contadorDePreguntas-1;
                 HiloPrincipal.crearHilo(interfaz);


                 pregunta.setEstadoCheck(false);
                 listaPregunta.set(position,pregunta);

                 }
         });


    }

    @Override
    public int getItemCount() {
        return listaPregunta.size();
    }


}