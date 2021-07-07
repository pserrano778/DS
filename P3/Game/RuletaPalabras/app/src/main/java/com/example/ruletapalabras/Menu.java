package com.example.ruletapalabras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class Menu extends AppCompatActivity {
    private String user;
    private JSONObject json;
    private Integer hayRuleta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Bundle bundle = getIntent().getExtras();

        if(bundle.getString("clase") != "partida"){
            user = bundle.getString("usuario");
            hayRuleta = bundle.getInt("hayRuleta");
        }

        Button botonNuevaPartida = findViewById(R.id.botonNuevaPartida);

        botonNuevaPartida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    openPartida();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Button botonContinuarPartida = findViewById(R.id.botonContinuarPartida);

        if(hayRuleta == 0)
            botonContinuarPartida.setVisibility(View.INVISIBLE);
        else
            botonContinuarPartida.setVisibility(View.VISIBLE);

        botonContinuarPartida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    continuarPartida();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    private void openPartida() throws ExecutionException, InterruptedException {
        new NuevaRuleta().execute().get();

        enviarDatosRuleta(0, 0);
    }

    private void continuarPartida() throws ExecutionException, InterruptedException {
        new GetRuleta().execute().get();


        try {
            enviarDatosRuleta(json.getInt("posicion"), hayRuleta);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void enviarDatosRuleta(Integer posicion, Integer hayRuleta1){
        Intent intent = new Intent(this, Partida.class);

        HashMap<String, HashMap<String, String>> ruleta = new HashMap<>();

        try {
            ArrayList<String> letras = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                    "l", "m", "n" , "ni", "o", "p", "q", "r", "s", "t", "u", "v", "x", "y", "z"));

            for(int i = 0; i < letras.size(); i++) {
                HashMap<String, String> map = new HashMap<>();
                map.put("palabra", json.getJSONObject(letras.get(i)).getString("palabra"));
                map.put("definicion", json.getJSONObject(letras.get(i)).getString("definicion"));

                if (hayRuleta1 == 1){
                    map.put("estado", json.getJSONObject(letras.get(i)).getString("estado"));
                } else if(hayRuleta1 == 0)
                    map.put("estado", "SIN_RESPONDER");


                ruleta.put(letras.get(i), map);
            }

            intent.putExtra("ruleta", ruleta);
            intent.putExtra("posicion", posicion);
            intent.putExtra("usuario", user);
            intent.putExtra("hayRuleta", hayRuleta1);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        startActivity(intent);
    }

    class GetRuleta extends AsyncTask<String, String, JSONObject> {
        private final static String URL= "http://10.0.2.2/DS_P3/php/getRuletaActual.php";
        private JSONParser jsonParser = new JSONParser();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected JSONObject doInBackground(String... args) {

            try{
                HashMap<String, String> params = new HashMap<>();

                params.put("usuario", user);

                Log.d("request", "starting");

                json = jsonParser.makeHttpRequest(URL, "POST", params, "");

                if (json != null) {
                    Log.d("JSON result:   ", json.toString());

                    return json;
                }
            } catch (Exception e) {

                e.printStackTrace();
            }

            return null;
        }
    }

    class NuevaRuleta extends AsyncTask<String, String, JSONObject> {
        private final static String URL = "http://10.0.2.2/DS_P3/php/nuevaRuleta.php";
        private JSONParser jsonParser = new JSONParser();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected JSONObject doInBackground(String... args) {

            try{
                HashMap<String, String> params = new HashMap<>();

                params.put("usuario", user);

                Log.d("request", "starting");

                json = jsonParser.makeHttpRequest(URL, "POST", params, "");

                if (json != null) {
                    Log.d("JSON result:   ", json.toString());

                    return json;
                }
            } catch (Exception e) {

                e.printStackTrace();
            }

            return null;
        }
    }
}
