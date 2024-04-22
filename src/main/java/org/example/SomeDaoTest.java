package org.example;

import dao.daoServices.AircraftDao;
import dao.daoServices.FlightDao;
import dao.daoServices.TicketDao;
import dao.daoServices.filters.FlightFilter;
import dao.daoServices.filters.TicketFilter;
import dao.entities.Aircraft;

public class SomeDaoTest {
    public static void main(String[] args) {


        Aircraft testAircraft = new Aircraft();
        testAircraft.setModel("Бройлер 747");

        // AircraftDao.create(testAircraft);
//        System.out.println( AircraftDao.allAircrafts());
//
//        System.out.println(FlightDao.allFlights());

//      System.out.println(FlightDao.filteredFlights(new FlightFilter(1, "MN3002",
//                null,
//                null,
//                null,
//                null,
//                null,
//                null)));


//        System.out.println(TicketDao.allTickets());


        TicketFilter ticketFilter = TicketFilter.TicketFilterBuilder.aTicketFilter().withFlightId(9L).withLimit(5).build();

        System.out.println(TicketDao.filteredTickets(ticketFilter));

        //        AircraftDao.delete(5);

    }

}
