package com.kreitek.pets;

import com.kreitek.pets.infraestructure.bd.DbService;

public class Logs {
    private static Logs instance = null;
    private Logs() {
        if (instance != null) {
            throw new RuntimeException("Usage getInstance() method to create");
        }
    }
    public static Logs getInstance() {
        if (instance == null) {
            synchronized(Logs.class) {
                if (instance == null) {
                    instance = new Logs();
                }
            }
        }
        return instance;
    }
    private int contador = 0;
    public void Debug (String mensaje){
        contador++;
        System.out.printf("[DEBUG][%d] - %s \n", contador, mensaje);
    }
}
