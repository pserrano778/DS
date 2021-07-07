package com.example.ruletapalabras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;

public class Partida extends AppCompatActivity{
    private EditText respuesta;
    private Button botonRespuesta, botonPasar, botonRendirse;
    private TextView textoErrorVacio;
    private Boolean errorRespuestaVacia = false;
    private Boolean error = false;
    private Ruleta ruleta;
    private String user;
    private ActualizaEstado actualizar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruleta);

        respuesta = (EditText) findViewById(R.id.respuesta);
        botonRespuesta = (Button) findViewById(R.id.botonRespuesta);
        botonPasar = (Button) findViewById(R.id.botonPasar);
        botonRendirse = (Button) findViewById(R.id.rendirse);
        textoErrorVacio = (TextView) findViewById(R.id.textoErrorVacio);
        final TextView definicion = (TextView) findViewById(R.id.definicion);
        final TextView mensaje = (TextView) findViewById(R.id.mensaje);

        HashMap<String, HashMap<String, String>> ruletaPos;
        Bundle bundle = getIntent().getExtras();

        Intent intent = getIntent();
        ruletaPos = (HashMap<String, HashMap<String, String>>) intent.getSerializableExtra("ruleta");
        TreeMap<String, HashMap<String, String>> ruletaFinal = new TreeMap<>();
        Integer pos = bundle.getInt("posicion");
        user = bundle.getString("usuario");
        ArrayList<Letra> letras = new ArrayList<>();

        for(String key : ruletaPos.keySet()){
            ruletaFinal.put(key, ruletaPos.get(key));
        }

        for(String key : ruletaFinal.keySet()) {
            Palabra palabra = new Palabra(ruletaPos.get(key).get("palabra"), ruletaPos.get(key).get("definicion"));
            Integer id = getResources().getIdentifier("shape" + key.toUpperCase(), "id", getPackageName());
            String estado = ruletaPos.get(key).get("estado");
            Integer hayRuleta = bundle.getInt("hayRuleta");
            Letra letraTemp = null;

            //Comprobar el estado de las letras y actualizar la GUI

            //Si hay ruleta guardada en la BD
            if(hayRuleta == 1) {
                if (estado.equals("INCORRECTA"))
                    letraTemp = new Letra(key, palabra, id, this, Estado.INCORRECTA);
                else if (estado.equals("CORRECTA")) {
                    letraTemp = new Letra(key, palabra, id, this, Estado.CORRECTA);
                }
                else if(estado.equals("SIN_RESPONDER")) {
                    letraTemp = new Letra(key, palabra, id, this, Estado.SIN_RESPONDER);
                }

            //Si no hay ruleta guardada en la BD
            } else if(hayRuleta == 0)
                letraTemp = new Letra(key, palabra, id, this, Estado.SIN_RESPONDER);

            if(letraTemp.getEstado() == Estado.CORRECTA) {
                ImageView imagen = (ImageView) findViewById(id);
                imagen.setImageResource(R.drawable.circulo_verde);
            } else if (letraTemp.getEstado() == Estado.INCORRECTA) {
                ImageView imagen = (ImageView) findViewById(id);
                imagen.setImageResource(R.drawable.circulo_rojo);
            }

            letras.add(letraTemp);
        }

        ruleta = new Ruleta(letras, pos);

        definicion.setText(ruleta.getLetraActual().getPalabra().getDefinicion());

        botonRespuesta.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                errorRespuestaVacia = false;
                String texto = respuesta.getText().toString();
                textoErrorVacio.setVisibility(View.INVISIBLE);

                if(texto.length() == 0){
                    errorRespuestaVacia = true;
                    textoErrorVacio.setVisibility(View.VISIBLE);
                }

                if(!errorRespuestaVacia){

                    mensaje.setText(ruleta.comprobarRespuesta(respuesta.getText().toString()));
                    mensaje.setVisibility(View.VISIBLE);

                    //Animacion de texto
                    Timer t = new Timer(false);
                    t.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                public void run() {
                                    mensaje.setVisibility(View.INVISIBLE);
                                }
                            });
                        }
                    }, 3000);

                    terminarPartida(false);
                    if (ruleta.getRestantes() > 0)
                        definicion.setText(ruleta.getLetraActual().getPalabra().getDefinicion());

                    respuesta.setText("");
                }
                if (ruleta.getRestantes() > 0){
                    try {
                        actualizar.get();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    actualizar = new ActualizaEstado();
                    actualizar.execute();
                }
            }
        });

        botonPasar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ruleta.siguienteLetra();
                definicion.setText(ruleta.getLetraActual().getPalabra().getDefinicion());
                try {
                    actualizar.get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                actualizar = new ActualizaEstado();
                actualizar.execute();
                respuesta.setText("");
            }
        });

        botonRendirse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                terminarPartida(true);
            }});

        actualizar = new ActualizaEstado();
        actualizar.execute();
    }

    @Override
    public void onBackPressed() {
        try {
            actualizar.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Intent intent = new Intent(this, Menu.class);
        intent.putExtra("clase", "partida");
        intent.putExtra("usuario", user);
        intent.putExtra("hayRuleta", 1);
        startActivity(intent);
    }

    private void terminarPartida(Boolean rendirse){
        if(ruleta.getRestantes() == 0 || rendirse) {

            FinalizarRuleta terminar = new FinalizarRuleta();
            terminar.execute();

            try {
                terminar.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Intent intent = new Intent(this, ResumenPartida.class);
            intent.putExtra("usuario", user);
            intent.putExtra("resumen", ruleta.getResumen());
            startActivity(intent);
        }
    }

    class ActualizaEstado extends AsyncTask<String, String, JSONObject> {
        private static final String URL = "http://10.0.2.2/DS_P3/php/actualizarEstadoRuleta.php";
        private JSONParser jsonParser = new JSONParser();
        private JSONObject ruletaActual = new JSONObject();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            if(errorRespuestaVacia){
                error = true;
            }

            if(!error){
                ArrayList<Letra> temp = ruleta.getLetras();
                JSONObject jsonRuleta = new JSONObject();

                for(int i = 0; i < temp.size(); i++) {
                    JSONObject jsonPalabra = new JSONObject();
                    String letra = temp.get(i).getLetra();
                    String palabra = temp.get(i).getPalabra().getPalabra();
                    String estado = temp.get(i).getEstado().toString();

                    try {
                        jsonPalabra.put("letra", letra);
                        jsonPalabra.put("palabra", palabra);
                        jsonPalabra.put("estado", estado);

                        jsonRuleta.put(letra, jsonPalabra);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    jsonRuleta.put("posicion", ruleta.getPosicionActual());
                    ruletaActual.put("usuario", user);
                    ruletaActual.put("ruleta", jsonRuleta);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        protected JSONObject doInBackground(String... args) {

            if(!error) {
                try {
                    HashMap<String, String> params = new HashMap<>();

                    params.put("respuesta", ruletaActual.toString());

                    Log.d("request", "starting");

                    JSONObject json = jsonParser.makeHttpRequest(URL, "POST", params, "RULETA");
                } catch (Exception e) {

                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(JSONObject result) {
            super.onPostExecute(result);
        }
    }

    class FinalizarRuleta extends AsyncTask<String, String, JSONObject> {
        private static final String URL = "http://10.0.2.2/DS_P3/php/terminarRuleta.php";
        private JSONParser jsonParser = new JSONParser();
        private JSONObject json = new JSONObject();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            try {
                json.put("usuario", user);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        protected JSONObject doInBackground(String... args) {

            if(!error) {
                try {
                    HashMap<String, String> params = new HashMap<>();

                    params.put("respuesta", json.toString());

                    Log.d("request", "starting");

                    JSONObject json = jsonParser.makeHttpRequest(URL, "POST", params, "RULETA");
                } catch (Exception e) {

                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(JSONObject result) {
            super.onPostExecute(result);
        }
    }
}
