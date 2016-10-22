package com.example.gabriel.controleev.monsters;

/**
 * Created by gabriel on 21/10/16.
 */

public class Pokemon extends PokedexEntry {
    private int attack, defense, spAttack, spDefense, speed, hp;

    public Pokemon(String name, String type, int dexId, int attack, int defense, int spAttack, int spDefense, int speed, int hp) {
        super(name, type, dexId);
        this.attack = attack;
        this.defense = defense;
        this.spAttack = spAttack;
        this.spDefense = spDefense;
        this.speed = speed;
        this.hp = hp;
    }
}
