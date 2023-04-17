package com.kreitek.pets;

import com.kreitek.pets.infraestructure.bd.DbService;

public class Logger {
    private static Logger instance = null;
    private Logger() {
        if (instance != null) {
            throw new RuntimeException("Usage getInstance() method to create");
        }
    }
    public static Logger getInstance() {
        if (instance == null) {
            synchronized(Logger.class) {
                if (instance == null) {
                    instance = new Logger();
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
