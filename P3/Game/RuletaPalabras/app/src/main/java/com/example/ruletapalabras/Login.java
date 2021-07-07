package com.example.ruletapalabras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;
import java.util.HashMap;

public class Login extends AppCompatActivity {
    private EditText usuarioT,contraT;
    private String usuario, contra;
    private Integer hayRuleta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        usuarioT = (EditText) findViewById(R.id.usuario);
        contraT = (EditText) findViewById(R.id.contrasenia);

        //Boton Registro
        final Button registro = findViewById(R.id.registro);

        registro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openRegister();
            }
        });


        //Boton Inicio
        final Button inicio = findViewById(R.id.inicio);

        inicio.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                usuario = usuarioT.getText().toString();
                contra = contraT.getText().toString();
                new IniciaSesion().execute();
            }
        });
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void openRegister() {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }

    private void openMenu(String user, int hayRuleta){
        Intent intent = new Intent(this, Menu.class);
        intent.putExtra("usuario", user);
        intent.putExtra("hayRuleta", hayRuleta);
        intent.putExtra("clase", "login");
        startActivity(intent);
    }

    class IniciaSesion extends AsyncTask<String, String, JSONObject> {
        private final static String URL = "http://10.0.2.2/DS_P3/php/login.php";
        private JSONParser jsonParser = new JSONParser();
        private Boolean errorInicio = false;
        private TextView textoError = (TextView) findViewById(R.id.textoError);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            textoError.setVisibility(View.INVISIBLE);
        }

        protected JSONObject doInBackground(String... args) {

            try{
                HashMap<String, String> params = new HashMap<>();

                params.put("usuario", usuario);
                params.put("clave", contra);

                Log.d("request", "starting");

                JSONObject json = jsonParser.makeHttpRequest(URL, "POST", params, "");

                if (json != null) {
                    Log.d("JSON result:   ", json.toString());
                    hayRuleta = 0;

                    if(json.getInt("exito") == 0)
                        errorInicio = true;
                    else if(json.getInt("exito") == 1){
                        hayRuleta = json.getInt("hayRuleta");
                    }

                    return json;
                }
            } catch (Exception e) {

                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(JSONObject result){
            super.onPostExecute(result);

            if(errorInicio)
                textoError.setVisibility(View.VISIBLE);
            else {
                openMenu(usuario, hayRuleta);
            }
        }
    }
}