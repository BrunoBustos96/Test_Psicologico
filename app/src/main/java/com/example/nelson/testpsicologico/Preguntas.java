package com.example.nelson.testpsicologico;

import java.util.ArrayList;

/**
 * Created by nelson on 30/04/2016.
 */

@SuppressWarnings("all")
public class Preguntas {

   private  String pregunta;
   private  boolean estado;
   private  int puntuacion[];
   private  boolean estadoCheck;


    public  static int lsPuntuacion[][]= {
            //nunca  - algunas - muchas - casiSiempre
            {1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4},
            {4,3,2,1},{1,2,3,4},{1,2,3,4},{1,2,3,4},
            {4,3,2,1},{1,2,3,4},{1,2,3,4},{1,2,3,4},
            {4,3,2,1},{1,2,3,4},{1,2,3,4},{1,2,3,4},
            {4,3,2,1},{1,2,3,4}, {4,3,2,1},{1,2,3,4},

            {1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4},
            {4,3,2,1},{1,2,3,4},{1,2,3,4},{1,2,3,4},
            {4,3,2,1},{1,2,3,4},{1,2,3,4},{1,2,3,4},
            {4,3,2,1},{1,2,3,4},{1,2,3,4},{1,2,3,4},
            {4,3,2,1},{1,2,3,4}, {4,3,2,1},{1,2,3,4}
            };
   public static String lsPreguntas[]= {
           "ME SIENTO TRISTE Y DECAÍDO",
           "POR LAS MAÑANAS ME SIENTO MEJOR",
           "TENGO GANAS DE LLORAR Y A VECES LLORO",
           "ME CUESTA MUCHO DORMIR POR LAS NOCHES",
           "TENGO TANTO APETITO COMO ANTES",
           "AÚN TENGO DESEOS SEXUALES",
           "NOTO QUE ESTOY ADELGAZANDO",
           "ESTOY ESTREÑIDO",
           "EL CORAZÓN ME LATE MÁS RÁPIDO QUE ANTES",
           "ME CANSO SIN MOTIVO",
           "MI MENTE ESTÁ TAN DESPEJADA COMO SIEMPRE",
           "HAGO LAS COSAS CON LA MISMA FACILIDAD QUE ANTES",
           "ME SIENTO INTRANQUILO Y NO PUEDO MANTENERME QUIETO",
           "TENGO CONFIANZA EN EL FUTURO",
           "ESTOY MÁS IRRITABLE QUE ANTES",
           "ENCUNETRO FÁCIL TOMAR DECISIONES",
           "SIENTO QUE SOY ÚTIL Y NECESARIO",
           "ENCUENTRO AGRADABLE VIVIR",
           "CREO QUE SERÍA LO MEJOR PARA LOS DEMÁS SI ESTUVIERA MUERTO",
           "ME GUSTAN LAS MISMAS COSAS QUE ANTES",

           //21
           "ME SIENTO MAS NERVIOSO QUE DE COSTUMBRE",
           "ME SIENTO CON TEMOR SIN RAZÓN",
           "DEPSIERTO CON FACILIDAD",
           "ME SIENTO COM SI FUERA A REVENTAR Y PARTIRME EN MIL PEDASOS",
           "SIENTO QUE TODO ESTÁ BIEN Y NADA MALO PUEDE SUCEDERME ",
           "ME TIEMBLAN LAS MANOS Y LAS PIERNAS ",
           "ME MORTIFICAN DOLORES DE CABEZA, CUELLO Y CINTURA",
           "ME SIENTO DÉBIL Y ME CANSO FÁCILMENTE",
           "ME SIENTO TRANQUILO Y LO PUEDO PERMANECER EN CALMA FÁCILMENTE ",
           "PUEDO SENTIR QUE ME LATE MUY RÁPIDO EL CORAZÓN",
           "SUFRO DE MAREOS",
           "SUFRO DE DESMAYOS Y SIENTO QUE ME VOY A DESMAYAR",
           "PUEDO INSPIRAR Y ESPIRAR FÁCILMENTE",
           "SE ME ADORMECEN Y SE ME HINCHAN LOS DEDOS DE LAS MANOS Y LOS PIES",
           "SUFRO DE MOLESTIAS ESTOMACALES O INDIGESTIÓN",
           "ORINO CON MUCHA FRECUENCIA",
           "GENERALMENTE MIS MANOS ESTÁN SECAS Y CALIENTES",
           "SIENTO BOCHORNOS",
           "ME QUEDO DORMIDO CON FACILIDAD Y DESCANSO TODA LA NOCHE",
           "TENGO PESADILLAS"};

    public Preguntas() {
        this.estado=false;
        this.estadoCheck=false;
        this.puntuacion= new int[4];

    }



    public static ArrayList<Preguntas> listaTotalPreguntas(){
                  ArrayList<Preguntas> ls = new ArrayList<>();
          int a[]= new int[4];
             for(int i=0; i<40;i++){
                 for (int j=0; j<4;j++){
                     a[j]=lsPuntuacion[i][j];
                   }
                 Preguntas preguntas = new Preguntas();
                 preguntas.setPregunta(lsPreguntas[i]);
                 preguntas.setPuntuacion(a);
                 ls.add(preguntas);

             }

        return ls;

    }

    public boolean getEstadoCheck() {
        return estadoCheck;
    }

    public void setEstadoCheck(boolean estadoCheck) {
        this.estadoCheck = estadoCheck;
    }

    public int[] getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int[] puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
