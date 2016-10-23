package com.example.gabriel.controleev.activities;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gabriel.controleev.R;
import com.example.gabriel.controleev.database.LocalDataDBHelper;
import com.example.gabriel.controleev.database.PokedexDBHelper;
import com.example.gabriel.controleev.monsters.PokedexEntry;
import com.example.gabriel.controleev.monsters.Pokemon;

public class CadastroPokemon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pokemon);
        setTitle("Dados do Pokémon");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarCadastro);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final TextView pokemonName = (TextView) findViewById(R.id.pokemonName);
        ImageView sprite = (ImageView) findViewById(R.id.sprite);
        final EditText pokemonNickName = (EditText) findViewById(R.id.nickname);
        final EditText pokemonAtt = (EditText) findViewById(R.id.attack);
        final EditText pokemonDef = (EditText) findViewById(R.id.defense);
        final EditText pokemonSpAtt = (EditText) findViewById(R.id.spAttack);
        final EditText pokemonSpDef = (EditText) findViewById(R.id.spDefense);
        final EditText pokemonSpe = (EditText) findViewById(R.id.speed);
        final EditText pokemonHp = (EditText) findViewById(R.id.hp);
        Intent intent = getIntent();
        int id = intent.getIntExtra(AddPokemon.EXTRA_MESSAGE, 0);
        PokedexDBHelper helper = new PokedexDBHelper(this);
        helper.openDataBase();
        final PokedexEntry pokedexEntry = helper.getPokemon(id, helper.getMyDataBase());
        helper.close();
        pokedexEntry.setResId(CadastroPokemon.this.getResources().getIdentifier("sprite" + String.valueOf(id), "drawable", CadastroPokemon.this.getPackageName()));
        sprite.setImageResource(pokedexEntry.getResId());
        Button concluir = (Button) findViewById(R.id.button);
        final Pokemon pokemon = (Pokemon)pokedexEntry;
        pokemon.setAttack(Integer.parseInt(pokemonAtt.getText().toString()));
        pokemon.setDefense(Integer.parseInt(pokemonDef.getText().toString()));
        pokemon.setSpAttack(Integer.parseInt(pokemonSpAtt.getText().toString()));
        pokemon.setSpDefense(Integer.parseInt(pokemonSpDef.getText().toString()));
        pokemon.setSpeed(Integer.parseInt(pokemonSpe.getText().toString()));
        pokemon.setHp(Integer.parseInt(pokemonHp.getText().toString()));
        if (!(pokemonNickName.getText().toString().equals("")))
            pokemon.setNickname(pokemonNickName.getText().toString());
        concluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LocalDataDBHelper helper1 = new LocalDataDBHelper(CadastroPokemon.this);
                salva(pokemon, helper1.getWritableDatabase());
                helper1.close();
                Intent intent = new Intent(CadastroPokemon.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void salva(Pokemon pokemon, SQLiteDatabase db) {
        LocalDataDBHelper.addPokemon(db, pokemon);
    }
}
