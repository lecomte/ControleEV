package com.example.gabriel.controleev.database;

import android.database.sqlite.SQLiteDatabase;

import com.example.gabriel.controleev.monsters.PokedexEntry;
import com.example.gabriel.controleev.monsters.Pokemon;

import java.util.ArrayList;

/**
 * Created by gabriel on 23/10/16.
 */

public interface ConsultaBanco {
    ArrayList<?> getAllPokemon(SQLiteDatabase db);
    PokedexEntry getPokemon(int id, SQLiteDatabase db);
}
