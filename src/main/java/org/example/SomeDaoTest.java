package org.example;

import dao.daoServices.AircraftDao;
import dao.daoServices.FlightDao;
import dao.entities.Aircraft;

public class SomeDaoTest {
    public static void main(String[] args) {


        Aircraft testAircraft = new Aircraft();
        testAircraft.setModel("Бройлер 747");

       // AircraftDao.create(testAircraft);
//        System.out.println( AircraftDao.allAircrafts());
//
        System.out.println(FlightDao.allFlights());


        AircraftDao.delete(5);

    }

}
