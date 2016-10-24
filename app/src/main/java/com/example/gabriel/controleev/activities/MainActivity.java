package com.example.gabriel.controleev.activities;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gabriel.controleev.R;
import com.example.gabriel.controleev.database.LocalDataDBHelper;
import com.example.gabriel.controleev.database.PokedexDBHelper;
import com.example.gabriel.controleev.monsters.CriaView;
import com.example.gabriel.controleev.monsters.Pokemon;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.gabriel.controleev.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Controle de EVs");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciaAddPokemon(view);
            }
        });
        LinearLayout gridLayout = (LinearLayout) findViewById(R.id.grid);
        LocalDataDBHelper helper = new LocalDataDBHelper(this);
        ArrayList<Pokemon> lista = helper.getAllPokemon(helper.getReadableDatabase());
        DisplayMetrics metrics = this.getResources().getDisplayMetrics();
        for (final Pokemon p : lista) {
            LinearLayout l = CriaView.imprime(p, this);
            l.setClickable(true);
            l.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    altera(view, p);
                }
            });
            gridLayout.addView(l);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void iniciaAddPokemon(View view) {
        Intent nextScreen = new Intent(this, AddPokemon.class);
        startActivity(nextScreen);
    }

    public void altera(View view, Pokemon pokemon) {
        Intent nextScreen = new Intent(this, AlteraPokemon.class);
        nextScreen.putExtra(EXTRA_MESSAGE, pokemon.getId());
        startActivity(nextScreen);
    }
}
