package com.kreitek.pets.controllers;

import com.kreitek.pets.Controller;
import com.kreitek.pets.infraestructure.logs.Logger;
import com.kreitek.pets.domain.Dog;
import com.kreitek.pets.infraestructure.bd.DbService;

import java.util.List;

public class DogController implements Controller {

    // TODO Logger declaration
    static Logger logger = Logger.getInstance();

    public String executePut(String petName, String ownerName, String telephone) {
        // TODO logger.debug("DogController.executePut " + petName + "," + ownerName + "," + telephone);
        logger.Debug("DogController.executePut " + petName + "," + ownerName + "," + telephone);

        Dog dog = new Dog(petName, ownerName, telephone);
        DbService dbService = DbService.getInstance();
        dbService.addNewDog(dog);
        return "New dog has been added";
    }

    @Override
    public String executeGet() {
        // TODO logger.debug("DogController.executeGet DOGS");
        logger.Debug("DogController.executeGet DOGS");

        DbService dbService = DbService.getInstance();
        List<Dog> dogs = dbService.getDogs();
        String response = "";
        for (Dog dog:dogs) {
            response += dog.toString() + "\r\n";
        }
        return response;
    }
}
