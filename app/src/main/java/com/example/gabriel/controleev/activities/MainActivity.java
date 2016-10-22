package com.example.gabriel.controleev.activities;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gabriel.controleev.R;
import com.example.gabriel.controleev.database.LocalDataDBHelper;
import com.example.gabriel.controleev.database.PokedexDBHelper;
import com.example.gabriel.controleev.monsters.Pokemon;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tentaAbrir();
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
        GridLayout gridLayout = (GridLayout) findViewById(R.id.grid);
        LocalDataDBHelper helper = new LocalDataDBHelper(this);
        ArrayList<Pokemon> lista = helper.getAllPokemon(helper.getReadableDatabase());
        for (Pokemon p : lista) {
            LinearLayout l = new LinearLayout(this);
            l.setOrientation(LinearLayout.VERTICAL);
            ImageView image = new ImageView(this);
            int resId = MainActivity.this.getResources().getIdentifier("sprite" + String.valueOf(p.getDexId()), "drawable", MainActivity.this.getPackageName());
            image.setImageResource(resId);
            l.addView(image);
            TextView text = new TextView(this);
            text.setGravity(View.TEXT_ALIGNMENT_CENTER);
            text.setText(p.getNickname());
            l.addView(text);
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

    public void tentaAbrir() {
        PokedexDBHelper myDbHelper;
        myDbHelper = new PokedexDBHelper(this);

        try {

            myDbHelper.createDataBase();

        } catch (IOException ioe) {

            throw new Error("Unable to create database");

        }

        try {

            myDbHelper.openDataBase();

        }catch(SQLException sqle){

            throw sqle;

        }
        myDbHelper.close();
    }
}
