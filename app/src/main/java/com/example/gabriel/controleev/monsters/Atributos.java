package com.example.gabriel.controleev.monsters;

/**
 * Created by Pedro on 22/10/2016.
 */

public class Atributos {
    private int attack, defense, spAttack, spDefense, speed, hp;

    public Atributos(int attack, int defense, int spAttack, int spDefense, int speed, int hp){
        this.attack = attack;
        this.defense = defense;
        this.spAttack = spAttack;
        this.spDefense = spDefense;
        this.speed = speed;
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpAttack() {
        return spAttack;
    }

    public void setSpAttack(int spAttack) {
        this.spAttack = spAttack;
    }

    public int getSpDefense() {
        return spDefense;
    }

    public void setSpDefense(int spDefense) {
        this.spDefense = spDefense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String toString(){
        return "Attack: " + String.valueOf(attack) + "\n" + "Defense: " + String.valueOf(defense) + "\n" + "SpAttack: " + String.valueOf(spAttack) + "\n" + "SpDefense: " + String.valueOf(spDefense) + "\n" + "Speed: " + String.valueOf(speed) + "\n" + "Hp: " + String.valueOf(hp) + "\n";
    }
}
