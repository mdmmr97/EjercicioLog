package com.kreitek.pets.infraestructure.bd;

import com.kreitek.pets.infraestructure.logs.Logger;
import com.kreitek.pets.domain.Cat;
import com.kreitek.pets.domain.Dog;

import java.util.ArrayList;
import java.util.List;

public class DbService {
    private static volatile DbService instance = null;

    // TODO Logger declaration
    static Logger logger = Logger.getInstance();

    private List<Cat> cats = new ArrayList<>();
    private List<Dog> dogs = new ArrayList<>();

    private DbService() {
        if (instance != null) {
            throw new RuntimeException("Usage getInstance() method to create");
        }
    }

    public static DbService getInstance() {
        if (instance == null) {
            synchronized(DbService.class) {
                if (instance == null) {
                    instance = new DbService();
                }
            }
        }
        return instance;
    }

    public void addNewDog(Dog dog) {
        dogs.add(dog);
        // TODO logger.debug("BdService.Dog added");
        logger.Debug("BdService.Dog added");
    }
    public void addNewCat(Cat cat) {
        cats.add(cat);
        // TODO logger.debug("BdService.Cat added");
        logger.Debug("BdService.Cat added");
    }

    public List<Cat> getCats() {
        // TODO logger.debug("BdService.Get " + cats.size() + " cats);
        logger.Debug("BdService.Get " + cats.size() + " cats");
        return new ArrayList<>(cats);
    }

    public List<Dog> getDogs() {
        // TODO logger.debug("BdService.Get " + cats.size() + " dogs);
        logger.Debug("BdService.Get " + dogs.size() + " dogs");
        return new ArrayList<>(dogs);
    }
}
