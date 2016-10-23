package com.example.gabriel.controleev.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.gabriel.controleev.monsters.*;

import java.util.ArrayList;

/**
 * Created by Pedro on 23/10/2016.
 */

public class Teste {

    public PokedexEntry getPokemon(PokedexEntry pokemon, SQLiteDatabase myDB){
        if (pokemon instanceof Pokemon){
            Cursor cursor = myDB.rawQuery("select * from pokemon where _id = " + String.valueOf(pokemon.getDexId()),null);
            return new Pokemon(cursor.getString(cursor.getColumnIndex("identifier")),
                    cursor.getString(cursor.getColumnIndex("type")),cursor.getInt(cursor.getColumnIndex("dexId")), cursor.getString(cursor.getColumnIndex("name")), cursor.getInt(cursor.getColumnIndex("attack")), cursor.getInt(cursor.getColumnIndex("defense"))
                    , cursor.getInt(cursor.getColumnIndex("spAttack")), cursor.getInt(cursor.getColumnIndex("spDefense")), cursor.getInt(cursor.getColumnIndex("speed")), cursor.getInt(cursor.getColumnIndex("hp")), cursor.getInt(cursor.getColumnIndex("_id")));
        }
        else if (pokemon != null){
            Cursor cursor = myDB.rawQuery("select * from pokemon where _id = " + String.valueOf(pokemon.getDexId()),null);
            if (cursor.moveToFirst()) {
                return new PokedexEntry(cursor.getString(cursor.getColumnIndex("identifier")),
                        cursor.getString(cursor.getColumnIndex("type")),cursor.getInt(cursor.getColumnIndex("_id")));
            }
        }
        return null;
    }

}
