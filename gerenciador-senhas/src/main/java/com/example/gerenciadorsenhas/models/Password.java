package com.example.gerenciadorsenhas.models;

public class Password {

    private int number;
    private boolean pritorary;
    private String pass;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isPritorary() {
        return pritorary;
    }

    public void setPritorary(boolean pritorary) {
        this.pritorary = pritorary;
    }

    @Override
    public String toString() {
        return "Password{" +
                "number=" + number +
                ", pritorary=" + pritorary +
                ", pass='" + pass + '\'' +
                '}';
    }
}

