package com.example.gabriel.controleev.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.gabriel.controleev.R;
import com.example.gabriel.controleev.database.PokedexDBHelper;
import com.example.gabriel.controleev.monsters.PokedexEntry;

public class CadastroPokemon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pokemon);
        setTitle("Dados do Pokémon");
        TextView pokemonName = (TextView) findViewById(R.id.pokemonName);
        Intent intent = getIntent();
        int id = intent.getIntExtra(AddPokemon.EXTRA_MESSAGE, 0);
        PokedexDBHelper helper = new PokedexDBHelper(this);
        helper.openDataBase();
        PokedexEntry pokedexEntry = helper.getPokemon(id);
        helper.close();
        pokemonName.setText(pokedexEntry.getName());
    }
}
