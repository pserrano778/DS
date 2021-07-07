package com.example.ruletapalabras;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class ResumenPartida extends AppCompatActivity {
    private String user;
    private HashMap<String, Integer> resumen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_partida);

        Bundle bundle = getIntent().getExtras();

        Intent intent = getIntent();

        resumen = (HashMap<String, Integer>) intent.getSerializableExtra("resumen");
        user = bundle.getString("usuario");

        TextView aciertos = (TextView) findViewById(R.id.aciertos);
        TextView sin_contestar = (TextView) findViewById(R.id.sin_contestar);
        TextView errores = (TextView) findViewById(R.id.errores);

        int aciertosI = resumen.get("aciertos");
        int sin_responderI = resumen.get("sin_responder");
        int erroresI = resumen.get("errores");
        String cadena = "";

        if (aciertosI == 0){
            cadena = "No has acertado ninguna palabra.";
        } else if(aciertosI == 1){
            cadena = "Has acertado " + aciertosI + " palabra.";
        } else{
            cadena = "Has acertado " + aciertosI + " palabras.";
        }
        aciertos.setText(cadena);

        if (sin_responderI == 0){
            cadena = "No has dejado ninguna palabra.";
        } else if(sin_responderI == 1){
            cadena = "Has dejado " + sin_responderI + " palabra.";
        } else{
            cadena = "Has dejado " + sin_responderI + " palabras.";
        }
        sin_contestar.setText(cadena);

        if (erroresI == 0){
            cadena = "No has fallado ninguna palabra.";
        } else if(erroresI == 1){
            cadena = "Has fallado " + erroresI + " palabra.";
        } else{
            cadena = "Has fallado " + erroresI + " palabras.";
        }
        errores.setText(cadena);

        EnviarResumen resumenTarea = new EnviarResumen();
        resumenTarea.execute();
        try {
            resumenTarea.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed(){

        Intent intent = new Intent(this, Menu.class);
        intent.putExtra("clase", "resumenPartida");
        intent.putExtra("usuario", user);
        intent.putExtra("hayRuleta", 0);
        startActivity(intent);
    }

    class EnviarResumen extends AsyncTask<String, String, JSONObject> {
        private static final String URL = "http://10.0.2.2/DS_P3/php/actualizarEstadisticas.php";
        private JSONParser jsonParser = new JSONParser();
        private JSONObject jsonResumen = new JSONObject();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            try {
                jsonResumen.put("aciertos", resumen.get("aciertos"));
                jsonResumen.put("sin_responder", resumen.get("sin_responder"));
                jsonResumen.put("errores", resumen.get("errores"));
                jsonResumen.put("usuario", user);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        protected JSONObject doInBackground(String... args) {

            try {
                HashMap<String, String> params = new HashMap<>();

                params.put("respuesta", jsonResumen.toString());

                Log.d("request", "starting");

                JSONObject json = jsonParser.makeHttpRequest(URL, "POST", params, "RULETA");
            } catch (Exception e) {

                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(JSONObject result) {
            super.onPostExecute(result);
        }
    }
}

