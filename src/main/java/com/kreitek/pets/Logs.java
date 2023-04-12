package com.kreitek.pets;

public class Logs {
    private int contador = 0;
    public void Debug (String mensaje){
        contador++;
        System.out.printf("[DEBUG][%d] - %s", contador, mensaje);
    }
}
