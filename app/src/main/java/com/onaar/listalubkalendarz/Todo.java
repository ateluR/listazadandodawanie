package com.onaar.listalubkalendarz;

public class Todo {
    private String nazwa;
    private boolean czyWykonane;
    private byte piorytet;
    public Todo(String nazwa, byte piorytet){
        this.nazwa = nazwa;
        this.piorytet = piorytet;
        czyWykonane = false;
    }

    public String getNazwa() {
        return nazwa;
    }

    public boolean isCzyWykonane() {
        return czyWykonane;
    }

    public byte getPiorytet() {
        return piorytet;
    }

    public void setCzyWykonane(boolean czyWykonane) {
        this.czyWykonane = czyWykonane;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "nazwa='" + nazwa + '\'' +
                ", piorytet=" + piorytet +
                '}';
    }
}
