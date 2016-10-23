package com.example.gabriel.controleev.monsters;

/**
 * Created by gabriel on 21/10/16.
 */

public class PokedexEntry {
    private String name, type;
    private int dexId;

    public PokedexEntry(String name, String type, int dexId) {
        this.name = name;
        this.type = type;
        this.dexId = dexId;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getDexId() {
        return dexId;
    }

    public String toString() {
        return String.valueOf(this.dexId) + " - " + this.name;
    }



    public String toString(PokedexEntry pokedexEntry){
        return pokedexEntry.toString();
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public int getResId() {
        return resId;
    }
}
