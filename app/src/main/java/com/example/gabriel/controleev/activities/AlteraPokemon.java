package com.example.gabriel.controleev.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gabriel.controleev.R;
import com.example.gabriel.controleev.database.LocalDataDBHelper;
import com.example.gabriel.controleev.monsters.Pokemon;

public class AlteraPokemon extends AppCompatActivity {

    Pokemon pokemon;
    private static final String KEY_TYPE = "type";
    private static final String KEY_DEX = "dexId";
    private static final String KEY_ATT = "attack";
    private static final String KEY_DEF = "defense";
    private static final String KEY_SPATT = "spAttack";
    private static final String KEY_SPDEF = "spDefense";
    private static final String KEY_SPE = "speed";
    private static final String KEY_HP = "hp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altera_pokemon);
        Intent intent = getIntent();
        int id = intent.getIntExtra(MainActivity.EXTRA_MESSAGE, 0);
        setTitle("Alterar Pokémon");
        LocalDataDBHelper helper = new LocalDataDBHelper(this);
        pokemon = helper.getPokemon(id, helper.getReadableDatabase());
        helper.close();
        TextView name = (TextView) findViewById(R.id.pokemonNameAltera);
        name.setText(pokemon.getNickname());
        TextView att = (TextView) findViewById(R.id.attackAltera);
        att.setText(String.valueOf(pokemon.getAttack()));
        TextView def = (TextView) findViewById(R.id.defenseAltera);
        def.setText(String.valueOf(pokemon.getDefense()));
        TextView spatt = (TextView) findViewById(R.id.spAttackAltera);
        spatt.setText(String.valueOf(pokemon.getSpAttack()));
        TextView spdef = (TextView) findViewById(R.id.spDefenseAltera);
        spdef.setText(String.valueOf(pokemon.getSpDefense()));
        TextView spe = (TextView) findViewById(R.id.speedAltera);
        spe.setText(String.valueOf(pokemon.getSpeed()));
        TextView hp = (TextView) findViewById(R.id.hpAltera);
        hp.setText(String.valueOf(pokemon.getHp()));
        int resId = AlteraPokemon.this.getResources().getIdentifier("sprite" + String.valueOf(pokemon.getDexId()), "drawable", AlteraPokemon.this.getPackageName());
        ImageView sprite = (ImageView) findViewById(R.id.spriteAltera);
        sprite.setImageResource(resId);
        TextView species = (TextView) findViewById(R.id.especieAltera);
        species.setText(pokemon.getName());
        buttons(pokemon);
    }

    private void buttons(final Pokemon p) {
            Button attackInc = (Button) findViewById(R.id.incAtt);
            attackInc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (p.totalEVs() < 510 && p.getAttack() < 255) {
                        LocalDataDBHelper helper = new LocalDataDBHelper(AlteraPokemon.this);
                        p.setAttack(p.getAttack() + 1);
                        helper.updateStat(KEY_ATT, p.getId(), helper.getWritableDatabase(), p.getAttack());
                        TextView t = (TextView) findViewById(R.id.attackAltera);
                        t.setText(String.valueOf(helper.getStat(KEY_ATT, p.getId(), helper.getReadableDatabase())));
                        helper.close();
                    }
                }
            });

            Button attackDec = (Button) findViewById(R.id.decAtt);
            attackDec.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (p.getAttack() > 0) {
                        LocalDataDBHelper helper = new LocalDataDBHelper(AlteraPokemon.this);
                        p.setAttack(p.getAttack() - 1);
                        helper.updateStat(KEY_ATT, p.getId(), helper.getWritableDatabase(), p.getAttack());
                        TextView t = (TextView) findViewById(R.id.attackAltera);
                        t.setText(String.valueOf(helper.getStat(KEY_ATT, p.getId(), helper.getReadableDatabase())));
                        helper.close();
                    }
                }
            });

        Button defenseInc = (Button) findViewById(R.id.incDef);
        defenseInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (p.totalEVs() < 510 && p.getDefense() < 255) {
                    LocalDataDBHelper helper = new LocalDataDBHelper(AlteraPokemon.this);
                    p.setDefense(p.getDefense() + 1);
                    helper.updateStat(KEY_DEF, p.getId(), helper.getWritableDatabase(), p.getDefense());
                    TextView t = (TextView) findViewById(R.id.defenseAltera);
                    t.setText(String.valueOf(helper.getStat(KEY_DEF, p.getId(), helper.getReadableDatabase())));
                    helper.close();
                }
            }
        });

        Button defenseDec = (Button) findViewById(R.id.decDef);
        defenseDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (p.getDefense() > 0) {
                    LocalDataDBHelper helper = new LocalDataDBHelper(AlteraPokemon.this);
                    p.setDefense(p.getDefense() - 1);
                    helper.updateStat(KEY_DEF, p.getId(), helper.getWritableDatabase(), p.getDefense());
                    TextView t = (TextView) findViewById(R.id.defenseAltera);
                    t.setText(String.valueOf(helper.getStat(KEY_DEF, p.getId(), helper.getReadableDatabase())));
                    helper.close();
                }
            }
        });

        Button spattackInc = (Button) findViewById(R.id.incSpAtt);
        spattackInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (p.totalEVs() < 510 && p.getSpAttack() < 255) {
                    LocalDataDBHelper helper = new LocalDataDBHelper(AlteraPokemon.this);
                    p.setSpAttack(p.getSpAttack() + 1);
                    helper.updateStat(KEY_SPATT, p.getId(), helper.getWritableDatabase(), p.getSpAttack());
                    TextView t = (TextView) findViewById(R.id.spAttackAltera);
                    t.setText(String.valueOf(helper.getStat(KEY_SPATT, p.getId(), helper.getReadableDatabase())));
                    helper.close();
                }
            }
        });

        Button spattackDec = (Button) findViewById(R.id.decSpAtt);
        spattackDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (p.getSpAttack() > 0) {
                    LocalDataDBHelper helper = new LocalDataDBHelper(AlteraPokemon.this);
                    p.setSpAttack(p.getSpAttack() - 1);
                    helper.updateStat(KEY_SPATT, p.getId(), helper.getWritableDatabase(), p.getSpAttack());
                    TextView t = (TextView) findViewById(R.id.spAttackAltera);
                    t.setText(String.valueOf(helper.getStat(KEY_SPATT, p.getId(), helper.getReadableDatabase())));
                    helper.close();
                }
            }
        });

        Button spdefenseInc = (Button) findViewById(R.id.incSpDef);
        spdefenseInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (p.totalEVs() < 510 && p.getSpDefense() < 255) {
                    LocalDataDBHelper helper = new LocalDataDBHelper(AlteraPokemon.this);
                    p.setSpDefense(p.getSpDefense() + 1);
                    helper.updateStat(KEY_SPDEF, p.getId(), helper.getWritableDatabase(), p.getSpDefense());
                    TextView t = (TextView) findViewById(R.id.spDefenseAltera);
                    t.setText(String.valueOf(helper.getStat(KEY_SPDEF, p.getId(), helper.getReadableDatabase())));
                    helper.close();
                }
            }
        });

        Button spdefenseDec = (Button) findViewById(R.id.decSpDef);
        spdefenseDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (p.getSpDefense() > 0) {
                    LocalDataDBHelper helper = new LocalDataDBHelper(AlteraPokemon.this);
                    p.setSpDefense(p.getSpDefense() - 1);
                    helper.updateStat(KEY_SPDEF, p.getId(), helper.getWritableDatabase(), p.getSpDefense());
                    TextView t = (TextView) findViewById(R.id.spDefenseAltera);
                    t.setText(String.valueOf(helper.getStat(KEY_SPDEF, p.getId(), helper.getReadableDatabase())));
                    helper.close();
                }
            }
        });

        Button speedInc = (Button) findViewById(R.id.incSpe);
        speedInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (p.totalEVs() < 510 && p.getSpeed() < 255) {
                    LocalDataDBHelper helper = new LocalDataDBHelper(AlteraPokemon.this);
                    p.setSpeed(p.getSpeed() + 1);
                    helper.updateStat(KEY_SPE, p.getId(), helper.getWritableDatabase(), p.getSpeed());
                    TextView t = (TextView) findViewById(R.id.speedAltera);
                    t.setText(String.valueOf(helper.getStat(KEY_SPE, p.getId(), helper.getReadableDatabase())));
                    helper.close();
                }
            }
        });

        Button speedDec = (Button) findViewById(R.id.decSpe);
        speedDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (p.getSpeed() > 0) {
                    LocalDataDBHelper helper = new LocalDataDBHelper(AlteraPokemon.this);
                    p.setSpeed(p.getSpeed() - 1);
                    helper.updateStat(KEY_SPE, p.getId(), helper.getWritableDatabase(), p.getSpeed());
                    TextView t = (TextView) findViewById(R.id.speedAltera);
                    t.setText(String.valueOf(helper.getStat(KEY_SPE, p.getId(), helper.getReadableDatabase())));
                    helper.close();
                }
            }
        });

        Button hpInc = (Button) findViewById(R.id.incHp);
       hpInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (p.totalEVs() < 510 && p.getHp() < 255) {
                    LocalDataDBHelper helper = new LocalDataDBHelper(AlteraPokemon.this);
                    p.setHp(p.getHp() + 1);
                    helper.updateStat(KEY_HP, p.getId(), helper.getWritableDatabase(), p.getHp());
                    TextView t = (TextView) findViewById(R.id.hpAltera);
                    t.setText(String.valueOf(helper.getStat(KEY_HP, p.getId(), helper.getReadableDatabase())));
                    helper.close();
                }
            }
        });

        Button hpDec = (Button) findViewById(R.id.decHp);
        hpDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (p.getHp() > 0) {
                    LocalDataDBHelper helper = new LocalDataDBHelper(AlteraPokemon.this);
                    p.setHp(p.getHp() - 1);
                    helper.updateStat(KEY_HP, p.getId(), helper.getWritableDatabase(), p.getHp());
                    TextView t = (TextView) findViewById(R.id.hpAltera);
                    t.setText(String.valueOf(helper.getStat(KEY_HP, p.getId(), helper.getReadableDatabase())));
                    helper.close();
                }
            }
        });

        ImageButton delete = (ImageButton) findViewById(R.id.deleteButton);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(AlteraPokemon.this);
                builder.setMessage("Tem certeza que quer excluir " + p.getNickname() + "?")
                        .setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        })
                        .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(AlteraPokemon.this, MainActivity.class);
                                LocalDataDBHelper helper = new LocalDataDBHelper(AlteraPokemon.this);
                                helper.remove(p.getId(), helper.getWritableDatabase());
                                helper.close();
                                startActivity(intent);
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

    }
}
