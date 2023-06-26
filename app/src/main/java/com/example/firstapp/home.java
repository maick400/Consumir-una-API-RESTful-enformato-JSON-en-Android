package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import WebService.WebService;
import WebService.Asynchtask;


public class home extends AppCompatActivity  implements Asynchtask {
    TextView txtToken;
    TextView txtUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        txtUsers = (TextView) findViewById(R.id.txtUsers);
        TextView strSaludo = (TextView) findViewById(R.id.bienvenida);
        Bundle bdl = this.getIntent().getExtras();

        /*strSaludo.setText("Bienvenido " + bdl.getString("USUARIO"));
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService(
                "https://dummyjson.com/users",datos, home.this, home.this);
        ws.execute("GET");
        */

    }

    public  void  getUsers (View view){
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService(
                "https://dummyjson.com/users",datos, home.this, home.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException{

        JSONObject json = new JSONObject(result);
        //JSONArray jUsers = new json.getJSONArray("users");
        JSONArray array = json.getJSONArray("users");

        String lstUsu = "";
        for(int i = 0; i < array.length(); i++){
            JSONObject userobj = array.getJSONObject(i);
            lstUsu = lstUsu + "\n" + "Nombre: " +  userobj.get("firstName") + "  Edad: " + userobj.get("age")  + "  email: " + userobj.get("email");
        }
        Log.i("CHecked", result);
        txtUsers.setText(lstUsu);




    }





}