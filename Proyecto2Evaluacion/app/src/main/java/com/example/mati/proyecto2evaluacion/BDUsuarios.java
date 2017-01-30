package com.example.mati.proyecto2evaluacion;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.EditText;

/**
 * Created by mati on 23/01/17.
 */
public class BDUsuarios extends SQLiteOpenHelper {

    //Cadena con la sentencia SQL que permite crear la tabla Clientes
    String cadSQL = "CREATE TABLE Usuarios (ID integer primary key autoincrement, usuario TEXT, contraseña TEXT);";

    public BDUsuarios(Context contexto, String nombre, SQLiteDatabase.CursorFactory almacen, int version){
        super(contexto, nombre, almacen, version);
    }

    //Este metodo se ejecuta automaticamente cuando sea necesaria la creacion de la base de datos.
    //Es decir, se ejecutará cuando la base de datos todavia no exista.
    //Aqui deben crearse todas las tablas necesarias e insertar los datos iniciales si es necesario.
    @Override
    public void onCreate(SQLiteDatabase bd) {
        //Ejecutamos la sentencia SQL para crear la tabla Clientes
        //El metodo execSQL se limita a ejecutar directamente el codigo SQL que le pasemos.
        bd.execSQL(cadSQL);
    }

    //Este metodo se lanza automaticamente cuando es necesaria una actualizacion de la estructura
    //de la base de datos o una conversion de los datos.
    @Override
    public void onUpgrade(SQLiteDatabase bd, int versionAnterior, int versionNueva) {
        //NOTA: Para simplificar este ejemplo eliminamos la tabla anterior y la creamos de nuevo
        //		con el nuevo formato.
        //		Lo normal sera realizar una migracion o traspaso de los datos de la tabla antigua
        //		a la nueva, con la consiguiente complicacion que ello conlleva.

        //Eliminamos la version anterior de la tabla
        bd.execSQL("DROP TABLE IF EXISTS Clientes");

        //Creamos la nueva versi�n de la tabla
        bd.execSQL(cadSQL);
    }


}
