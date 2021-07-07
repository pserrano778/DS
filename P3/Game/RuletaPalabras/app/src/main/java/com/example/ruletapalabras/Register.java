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

public class Register extends AppCompatActivity {
    private EditText usuarioT, contraT, confirmaContraT;
    private String usuario, contra, confirmarContra;
    private Boolean errorRegistro = false;
    private Boolean errorContra = false;
    private Boolean errorCampos = false;
    private Boolean error = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        usuarioT = (EditText) findViewById(R.id.usuario);
        contraT = (EditText) findViewById(R.id.contrasenia);
        confirmaContraT = (EditText) findViewById(R.id.confirmaContrasenia);

        final Button login = findViewById(R.id.botonInicio);

        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openLogin();
            }
        });

        final Button registro = findViewById(R.id.registro);

        registro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                usuario = usuarioT.getText().toString();
                contra = contraT.getText().toString();
                confirmarContra = confirmaContraT.getText().toString();
                new Registrar().execute();
            }
        });
    }

    public void onBackPressed() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void openLogin() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    private void openMenu(String user){
        Intent intent = new Intent(this, Menu.class);
        intent.putExtra("usuario", user);
        intent.putExtra("hayRuleta", 0);
        intent.putExtra("clase", "registro");
        startActivity(intent);
    }

    class Registrar extends AsyncTask<String, String, JSONObject> {
        private static final String URL = "http://10.0.2.2/DS_P3/php/registro.php";
        private JSONParser jsonParser = new JSONParser();
        private TextView textoError = (TextView) findViewById(R.id.textoError);
        private TextView textoErrorContra = (TextView) findViewById(R.id.textoErrorContra);
        private TextView textoErrorCampos = (TextView) findViewById(R.id.textoErrorCampos);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            errorContra = false;
            errorRegistro = false;
            errorCampos = false;
            error = false;

            textoError.setVisibility(View.INVISIBLE);
            textoErrorContra.setVisibility(View.INVISIBLE);
            textoErrorCampos.setVisibility(View.INVISIBLE);


            //Comprobar que no hay campos vacios
            if(usuario.length() == 0 || contra.length() == 0 || confirmarContra.length() == 0)
                errorCampos = true;

            //Comprobar que las contraseñas son iguales
            if(!contra.equals(confirmarContra))
                errorContra = true;

            //Si no hay errores se hará la petición HTTP
            if(errorContra || errorCampos)
                error = true;
        }

        protected JSONObject doInBackground(String... args) {
            if(!error) {
                try {
                    HashMap<String, String> params = new HashMap<>();

                    params.put("usuario", usuario);
                    params.put("clave", contra);

                    Log.d("request", "starting");

                    JSONObject json = jsonParser.makeHttpRequest(URL, "POST", params, "");

                    if (json != null) {
                        Log.d("JSON result", json.toString());

                        if(json.getInt("exito") == 0)
                            errorRegistro = true;

                        return json;
                    }
                } catch (Exception e) {

                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(JSONObject result){
            super.onPostExecute(result);

            if(errorCampos)
                textoErrorCampos.setVisibility(View.VISIBLE);
            else if(errorContra)
                textoErrorContra.setVisibility(View.VISIBLE);
            else if(errorRegistro)
                textoError.setVisibility(View.VISIBLE);
            else
                openMenu(usuario);
        }
    }
}