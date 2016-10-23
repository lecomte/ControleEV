package com.example.gabriel.controleev.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.gabriel.controleev.monsters.PokedexEntry;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * Created by gabriel on 21/10/16.
 */

public class PokedexDBHelper extends SQLiteOpenHelper implements ConsultaBanco {

    public static String getDbName() {
        return DB_NAME;
    }

    private static String DB_NAME = "pokedex.sqlite";

    private SQLiteDatabase myDataBase;

    private final Context myContext;

    private static String DB_PATH = "/data/data/com.example.gabriel.controleev/databases/";



    public PokedexDBHelper(Context context) {
        super(context, DB_NAME, null, 1);
        this.myContext = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void createDataBase() throws IOException {

        boolean dbExist = checkDataBase();

        if(dbExist){
            //do nothing - database already exist
        }else{

            //By calling this method and empty database will be created into the default system path
            //of your application so we are gonna be able to overwrite that database with our database.
            this.getReadableDatabase();

            try {

                copyDataBase();

            } catch (IOException e) {

                throw new Error("Error copying database");

            }
        }

    }

    private boolean checkDataBase(){

        SQLiteDatabase checkDB = null;

        try{
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        }catch(SQLiteException e){

            //database does't exist yet.

        }

        if(checkDB != null){

            checkDB.close();

        }

        return checkDB != null ? true : false;
    }
    private void copyDataBase() throws IOException{

        //Open your local db as the input stream
        InputStream myInput = myContext.getAssets().open(DB_NAME);

        // Path to the just created empty db
        String outFileName = DB_PATH + DB_NAME;

        //Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        //transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }

        //Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public void openDataBase() throws SQLException {

        //Open the database
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

    }

    @Override
    public synchronized void close() {

        if(myDataBase != null)
            myDataBase.close();

        super.close();

    }

    public ArrayList<PokedexEntry> getAllPokemon(SQLiteDatabase myDataBase) {
        ArrayList<PokedexEntry> lista = new ArrayList<PokedexEntry>();
        Cursor cursor = myDataBase.rawQuery("select * from pokemon where _id < 650",null);
        if (cursor.moveToFirst()) {
            while (cursor.isAfterLast() == false) {
                PokedexEntry entry = new PokedexEntry(cursor.getString(cursor.getColumnIndex("identifier")),
                        cursor.getString(cursor.getColumnIndex("type")),cursor.getInt(cursor.getColumnIndex("_id")));
                lista.add(entry);
                cursor.moveToNext();
            }
        }
        return lista;
    }

    public PokedexEntry getPokemon(int id, SQLiteDatabase myDataBase) {
        Cursor cursor = myDataBase.rawQuery("select * from pokemon where _id = " + String.valueOf(id),null);
        if (cursor.moveToFirst()) {
            return new PokedexEntry(cursor.getString(cursor.getColumnIndex("identifier")),
                    cursor.getString(cursor.getColumnIndex("type")),cursor.getInt(cursor.getColumnIndex("_id")));
        }
        return null;
    }

    public SQLiteDatabase getMyDataBase() {
        return myDataBase;
    }
}
