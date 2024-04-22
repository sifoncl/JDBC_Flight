package dao.daoServices;


import dao.daoServices.filters.FlightFilter;
import dao.entities.Flight;
import dataBase.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

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


    public static ArrayList<Flight> filteredFlights(FlightFilter flightFilter) {
        ArrayList<Flight> allAircrafts = new ArrayList();
        ArrayList<Object> parameters = new ArrayList<>();
        ArrayList<String> sql = new ArrayList<>();
        if (flightFilter.id() != null) {
            sql.add("id = ? ");
            parameters.add(flightFilter.id());
        }
        if (flightFilter.flightNo() != null) {
            sql.add("flight_no = ? ");
            parameters.add(flightFilter.flightNo());
        }
        if (flightFilter.departureDate() != null) {
            sql.add("departure_date = ? ");
            parameters.add(flightFilter.departureDate());
        }
        if (flightFilter.departureAirportCode() != null) {
            sql.add("departure_airport_code = ? ");
            parameters.add(flightFilter.departureAirportCode());
        }
        if (flightFilter.arriveDate() != null) {
            sql.add("arrival_date = ? ");
            parameters.add(flightFilter.arriveDate());
        }
        if (flightFilter.arrivalAirportCode() != null) {
            sql.add("arrival_airport_code = ? ");
            parameters.add(flightFilter.arrivalAirportCode());
        }
        if (flightFilter.aircraftId() != null) {
            sql.add("aircraft_id = ? ");
            parameters.add(flightFilter.aircraftId());
        }
        if (flightFilter.status() != null) {
            sql.add("status = ? ");
            parameters.add(flightFilter.status());
        }

        String sqlSelectFields = """
                select id, flight_no, departure_date, departure_airport_code,
                arrival_date, arrival_airport_code, aircraft_id, status from flight
                """;

        String sqlQuery = sql.stream().collect(Collectors.joining(" and ", " where ", ""));

        try (Connection connection = ConnectionManager.open();
             PreparedStatement statement = connection.prepareStatement(sqlSelectFields + sqlQuery)) {

            System.out.println(sqlSelectFields + sqlQuery);

            for (int i = 0; i < parameters.size(); i++) {
                statement.setObject(i + 1, parameters.get(i));
            }

            ResultSet resultSet = statement.executeQuery();
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
