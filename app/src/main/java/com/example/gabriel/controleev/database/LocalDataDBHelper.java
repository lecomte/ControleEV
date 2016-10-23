package com.example.gabriel.controleev.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.gabriel.controleev.monsters.Pokemon;

import java.util.ArrayList;

/**
 * Created by gabriel on 22/10/16.
 */

public class LocalDataDBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATA_TABLE_NAME = "pokemon";
    private static final String KEY_NAME = "name";
    private static final String KEY_IDENTIFIER = "identifier";
    private static final String KEY_TYPE = "type";
    private static final String KEY_DEX = "dexId";
    private static final String KEY_ATT = "attack";
    private static final String KEY_DEF = "defense";
    private static final String KEY_SPATT = "spAttack";
    private static final String KEY_SPDEF = "spDefense";
    private static final String KEY_SPE = "speed";
    private static final String KEY_HP = "hp";
    private static final String DATA_TABLE_CREATE =
            "CREATE TABLE " + DATA_TABLE_NAME + " (" +
                    KEY_NAME + " TEXT, " +
                    KEY_IDENTIFIER + " TEXT, " +
                    KEY_TYPE + " TEXT, " +
                    KEY_DEX + " INT, " +
                    KEY_ATT + " INT, " +
                    KEY_DEF + " INT, " +
                    KEY_SPATT + " INT, " +
                    KEY_SPDEF + " INT, " +
                    KEY_SPE + " INT, " +
                    KEY_HP + " INT," +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL);";
    private static final String DATABASE_NAME = "localdata";

    public LocalDataDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATA_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int a, int b) {

    }

    public static void addPokemon(SQLiteDatabase db, Pokemon pokemon) {
        db.execSQL("INSERT INTO " + DATA_TABLE_NAME +"(name,identifier,type,dexId,attack,defense,spAttack,spDefense,speed,hp) VALUES ('"
                + pokemon.getNickname() + "','" + pokemon.getName() + "','" + pokemon.getType() + "'," + pokemon.getDexId() +
                "," + pokemon.getAttack() + "," + pokemon.getDefense() + "," + pokemon.getSpAttack() + "," + pokemon.getSpDefense() +
                "," + pokemon.getSpeed() + "," + pokemon.getHp() + ");");
    }

    public ArrayList<Pokemon> getAllPokemon(SQLiteDatabase myDataBase) {
        ArrayList<Pokemon> lista = new ArrayList<Pokemon>();
        Cursor cursor = myDataBase.rawQuery("select * from pokemon ",null);
        if (cursor.moveToFirst()) {
            while (cursor.isAfterLast() == false) {
                Pokemon entry = new Pokemon(cursor.getString(cursor.getColumnIndex(KEY_IDENTIFIER)),
                        cursor.getString(cursor.getColumnIndex(KEY_TYPE)),cursor.getInt(cursor.getColumnIndex(KEY_DEX)), cursor.getString(cursor.getColumnIndex(KEY_NAME)), cursor.getInt(cursor.getColumnIndex(KEY_ATT)), cursor.getInt(cursor.getColumnIndex(KEY_DEF))
                        , cursor.getInt(cursor.getColumnIndex(KEY_SPATT)), cursor.getInt(cursor.getColumnIndex(KEY_SPDEF)), cursor.getInt(cursor.getColumnIndex(KEY_SPE)), cursor.getInt(cursor.getColumnIndex(KEY_HP)), cursor.getInt(cursor.getColumnIndex("_id")));
                lista.add(entry);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return lista;
    }

    public Pokemon getPokemon(int id, SQLiteDatabase myDataBase) {
        Cursor cursor = myDataBase.rawQuery("select * from pokemon where _id = " + String.valueOf(id),null);
        if (cursor.moveToFirst()) {
                Pokemon entry = new Pokemon(cursor.getString(cursor.getColumnIndex(KEY_IDENTIFIER)),
                        cursor.getString(cursor.getColumnIndex(KEY_TYPE)),cursor.getInt(cursor.getColumnIndex(KEY_DEX)), cursor.getString(cursor.getColumnIndex(KEY_NAME)), cursor.getInt(cursor.getColumnIndex(KEY_ATT)), cursor.getInt(cursor.getColumnIndex(KEY_DEF))
                        , cursor.getInt(cursor.getColumnIndex(KEY_SPATT)), cursor.getInt(cursor.getColumnIndex(KEY_SPDEF)), cursor.getInt(cursor.getColumnIndex(KEY_SPE)), cursor.getInt(cursor.getColumnIndex(KEY_HP)), cursor.getInt(cursor.getColumnIndex("_id")));
                return entry;
        }
        cursor.close();
        return null;
    }

    public void updateStat(String key, int id, SQLiteDatabase db, int value) {
        db.execSQL("UPDATE " + DATA_TABLE_NAME + " SET " + key + " = " + String.valueOf(value) + " WHERE _id = " + String.valueOf(id) + ";" );
    }

    public int getStat(String key,int id, SQLiteDatabase myDataBase) {
        Cursor cursor = myDataBase.rawQuery("select * from pokemon where _id = " + String.valueOf(id),null);
        if (cursor.moveToFirst()) {
            int stat = cursor.getInt(cursor.getColumnIndex(key));
            return stat;
        }
        cursor.close();
        return -1;
    }

}
