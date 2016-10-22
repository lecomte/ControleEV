package com.example.gabriel.controleev.monsters;

/**
 * Created by gabriel on 21/10/16.
 */

public class Pokemon extends PokedexEntry {
    private int attack, defense, spAttack, spDefense, speed, hp;
    private String nickname;

    public Pokemon(String name, String type, int dexId, String nickname, int attack, int defense, int spAttack, int spDefense, int speed, int hp) {
        super(name, type, dexId);
        this.attack = attack;
        this.defense = defense;
        this.spAttack = spAttack;
        this.spDefense = spDefense;
        this.speed = speed;
        this.hp = hp;
        this.nickname = nickname;
    }


    public Pokemon(String name, String type, int dexId, int attack, int defense, int spAttack, int spDefense, int speed, int hp) {
        super(name, type, dexId);
        this.attack = attack;
        this.defense = defense;
        this.spAttack = spAttack;
        this.spDefense = spDefense;
        this.speed = speed;
        this.hp = hp;
        this.nickname = name;
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


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
