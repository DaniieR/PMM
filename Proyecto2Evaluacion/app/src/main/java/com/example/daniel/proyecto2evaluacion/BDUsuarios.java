package com.example.daniel.proyecto2evaluacion;

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

    //Cadena con la sentencia SQL que permite crear la tabla Usuarios,Skins,Pedidos
    String cadSQL = "CREATE TABLE Usuarios (ID integer primary key autoincrement, usuario TEXT, contraseña TEXT);";
    String cadSQL1 = "CREATE TABLE Skins (ID integer primary key autoincrement, nombre TEXT, skin TEXT, precio DOUBLE);";
    String cadSQL2 = "CREATE TABLE Pedidos (ID integer primary key autoincrement, usuario TEXT, pedido TEXT, FOREIGN KEY (ID) REFERENCES Usuarios (ID));";

    private static String[] crearProductos = new String[] {
            "('LeBlanc', 'Hija De Los Cuervos', '10.00')",
            "('LeBlanc', 'Bosque Ancestral', '8.00')",
            "('Ahri', 'Arcade', '12.00')",
            "('Ahri', 'Raposa Ignea', '7.00')",
            "('Lux', 'Elementalista', '20.00')",
            "('Lux', 'Guardiana De Las Estrellas', '8.00')"
    };

    public BDUsuarios(Context contexto, String nombre, SQLiteDatabase.CursorFactory almacen, int version) {
        super(contexto, nombre, almacen, version);
    }
        public void crearProductosInicio(){
            SQLiteDatabase db = this.getWritableDatabase();
            for (int i=0; i<crearProductos.length;i++){
                db.execSQL("INSERT INTO Skins (nombre, skin, precio) VALUES "+crearProductos[i]);
            }
            db.close();
        }

    //Este metodo se ejecuta automaticamente cuando sea necesaria la creacion de la base de datos.
    //Es decir, se ejecutará cuando la base de datos todavia no exista.
    //Aqui deben crearse todas las tablas necesarias e insertar los datos iniciales si es necesario.
    @Override
    public void onCreate(SQLiteDatabase bd) {
        //Ejecutamos la sentencia SQL para crear la tabla Clientes
        //El metodo execSQL se limita a ejecutar directamente el codigo SQL que le pasemos.
        bd.execSQL(cadSQL);
        bd.execSQL(cadSQL1);
        bd.execSQL(cadSQL2);
        bd.execSQL("DROP TABLE IF EXISTS Skins");
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