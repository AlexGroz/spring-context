package com.javastart.springcontext;

public class CombatCat {
    private String name;
    private Integer strength = 1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStrength() {
        return strength;
    }

    @Override
    public String toString() {
        return "CombatCat{" +
                "name='" + name + '\'' +
                ", strength=" + strength +
                '}';
    }
}
