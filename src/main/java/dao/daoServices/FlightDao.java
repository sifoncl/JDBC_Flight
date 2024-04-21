package dao.daoServices;


import dao.entities.Flight;
import dataBase.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class FlightDao {

    private FlightDao() {
    }

    private static final String ALL_FLIGHTS_SQL = """
            select id, flight_no, departure_date, departure_airport_code,
             arrival_date, arrival_airport_code, aircraft_id, status from flight;
            """;


    public static ArrayList<Flight> allFlights() {
        ArrayList<Flight> allAircrafts = new ArrayList();
        try (Connection connection = ConnectionManager.open();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(ALL_FLIGHTS_SQL);
            while (resultSet.next()) {
                allAircrafts.add(new Flight(
                        resultSet.getInt("id"),
                        resultSet.getString("flight_no"),
                        resultSet.getTimestamp("departure_date").toLocalDateTime(),
                        resultSet.getString("departure_airport_code"),
                        resultSet.getString("arrival_airport_code"),
                        resultSet.getTimestamp("arrival_date").toLocalDateTime(),
                        resultSet.getInt("aircraft_id"),
                        resultSet.getString("status")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allAircrafts;
    }


}
