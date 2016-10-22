package com.example.gabriel.controleev.activities;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gabriel.controleev.R;
import com.example.gabriel.controleev.database.PokedexDBHelper;
import com.example.gabriel.controleev.monsters.PokedexEntry;

import java.io.IOException;
import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;
import static java.security.AccessController.getContext;

public class AddPokemon extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.gabriel.controleev.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pokemon);
        setTitle("Escolha o Pokémon");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        DisplayMetrics metrics = this.getResources().getDisplayMetrics();
        LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.linearLayout1);
        PokedexDBHelper helper = new PokedexDBHelper(this);
        helper.openDataBase();
        ArrayList<PokedexEntry> lista = helper.getAllPokemon();
        for(final PokedexEntry pokedexEntry : lista) {
            TextView text = new TextView(AddPokemon.this);
            text.setText(pokedexEntry.toString());
            text.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, (int) (56 * metrics.density + 0.5f)));
            text.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
            text.setPadding((int) (16 * metrics.density + 0.5f),(int) (13 * metrics.density + 0.5f),(int) (16 * metrics.density + 0.5f), 0);
            text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    enviaPokemon(view, pokedexEntry.getDexId());
                }
            });
            linearLayout1.addView(text);
        }
        helper.close();
    }

    public void enviaPokemon(View view, int id) {
        Intent intent = new Intent(this, CadastroPokemon.class);
        intent.putExtra(EXTRA_MESSAGE, id);
        startActivity(intent);
    }

}
