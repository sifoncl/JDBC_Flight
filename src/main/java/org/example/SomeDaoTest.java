package org.example;

import dao.daoServices.AircraftDao;
import dao.entities.Aircraft;

public class SomeDaoTest {
    public static void main(String[] args) {


        Aircraft testAircraft = new Aircraft();
        testAircraft.setModel("Бройлер 747");

       // AircraftDao.create(testAircraft);


        AircraftDao.delete(5);

    }

}
