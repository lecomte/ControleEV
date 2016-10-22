package com.example.gabriel.controleev.monsters;

/**
 * Created by gabriel on 21/10/16.
 */

public class Pokemon extends PokedexEntry {
    private Atributos atributos;

    public Pokemon(String name, String type, int dexId, int attack, int defense, int spAttack, int spDefense, int speed, int hp) {
        super(name, type, dexId);
        atributos = new Atributos(attack, defense, spAttack, spDefense, speed, hp);
    }

    public int getAttack() {
        return atributos.getAttack();
    }

    public void setAttack(int attack) {
        atributos.setAttack(attack);
    }

    public int getDefense() {
        return atributos.getDefense();
    }

    public void setDefense(int defense) {
        atributos.setDefense(defense);
    }

    public int getSpAttack() {
        return atributos.getSpAttack();
    }

    public void setSpAttack(int spAttack) {
        atributos.setSpAttack(spAttack);
    }

    public int getSpDefense() {
        return atributos.getSpDefense();
    }

    public void setSpDefense(int spDefense) {
        atributos.setSpDefense(spDefense);
    }

    public int getSpeed() {
        return atributos.getSpeed();
    }

    public void setSpeed(int speed) {
        atributos.setSpeed(speed);
    }

    public int getHp() {
        return atributos.getHp();
    }

    public void setHp(int hp) {
        atributos.setHp(hp);
    }

    public String toString() {
        return super.toString() + "\n" + super.getType() + "\n" + atributos.toString();
    }
}
