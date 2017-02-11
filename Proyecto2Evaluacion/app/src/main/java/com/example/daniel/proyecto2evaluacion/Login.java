package com.example.daniel.proyecto2evaluacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button Loguear = (Button)findViewById(R.id.LOGIN);
        Button registrarse = (Button)findViewById(R.id.REGISTRARSE);
        final EditText usuario = (EditText)findViewById(R.id.usuario);
        final EditText contraseña = (EditText)findViewById(R.id.contraseña1);

        //Abrimos la base de datos en modo escritura
        BDUsuarios BDU = new BDUsuarios(this, "BDUsuarios", null, 1);

        //Obtenemos referencia a la base de datos para poder modificarla.
        final SQLiteDatabase bd = BDU.getWritableDatabase();

        Loguear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Usuario = usuario.getText().toString();
                String Password = contraseña.getText().toString();
                Cursor cursor = bd.rawQuery("SELECT usuario,contraseña FROM Usuarios WHERE usuario='"+Usuario+"' and contraseña='"+Password+"'",null);

                if (cursor.moveToFirst()){
                    String usu = cursor.getString(0);
                    String pwd = cursor.getString(1);

                    if (Usuario.equals(usu)&&Password.equals(pwd)){
                        Toast.makeText(getApplicationContext(),"EL Login ha sido correcto",Toast.LENGTH_LONG).show();
                        Bundle bundle = new Bundle();
                        bundle.putString("usuario",Usuario);
                        Intent intent = new Intent(Login.this,Pedido.class);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Usuario o Contraseña incorrectos",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Registro.class);
                startActivity(intent);

            }
        });

    }
    //INICIO Menu Acerca De
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.acercade:
                mostrarAcercaDe();
                break;
        }
        return true;
    }
    public void mostrarAcercaDe(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Acerca De")
                .setMessage("Hecho por Daniel Romero")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        builder.create().show();
    }
    //FIN de Menu
}
