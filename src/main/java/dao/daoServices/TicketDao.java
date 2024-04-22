package dao.daoServices;

import dao.daoServices.filters.TicketFilter;
import dao.entities.Flight;
import dao.entities.Ticket;
import dataBase.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class TicketDao {

    private TicketDao() {
    }


    private static final String ALL_TICKETS_SQL = """
            select id, passport_no, passenger_name, flight_id, seat_no, cost from ticket;
            """;


    public static ArrayList<Ticket> filteredTickets(TicketFilter ticketFilter) {
        ArrayList<Ticket> allTickets = new ArrayList();
        ArrayList<Object> parameters = new ArrayList<>();
        ArrayList<String> sql = new ArrayList<>();

        if (ticketFilter.getId() != null) {
            sql.add("id = ?");
            parameters.add(ticketFilter.getId());
        }
        if (ticketFilter.getPassportNo() != null) {
            sql.add("passport_no = ?");
            parameters.add(ticketFilter.getPassportNo());
        }
        if (ticketFilter.getPassengerName() != null) {
            sql.add("passenger_name = ?");
            parameters.add(ticketFilter.getPassengerName());
        }
        if (ticketFilter.getFlightId() != null) {
            sql.add("flight_id = ?");
            parameters.add(ticketFilter.getFlightId());
        }
        if (ticketFilter.getSeatNo() != null) {
            sql.add("seat_no = ?");
            parameters.add(ticketFilter.getSeatNo());
        }
        if (ticketFilter.getCost() != null) {
            sql.add("cost = ?");
            parameters.add(ticketFilter.getCost());
        }

        String sqlFields = "select id, passport_no, passenger_name, flight_id, seat_no, cost from ticket";

        String sqlQuery = sqlFields + sql.stream().collect(Collectors.joining(" and ", " where ", ""));


        if (ticketFilter.getLimit() != null) {
            sqlQuery = sqlQuery + " limit ?";
            parameters.add(ticketFilter.getLimit());
        }

        if (ticketFilter.getOffset() != null) {
            sqlQuery = sqlQuery + "offset ?";
            parameters.add(ticketFilter.getOffset());
        }

        System.out.println(sqlQuery);

        try (Connection connection = ConnectionManager.open();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {

            for (int i = 0; i < parameters.size(); i++) {

                statement.setObject(i + 1, parameters.get(i));
            }

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                allTickets.add(new Ticket(
                                resultSet.getInt("id"),
                                resultSet.getString("passport_no"),
                                resultSet.getString("passenger_name"),
                                resultSet.getInt("flight_id"),
                                resultSet.getString("seat_no"),
                                resultSet.getBigDecimal("cost")
                        )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allTickets;
    }

    public static ArrayList<Ticket> allTickets() {
        ArrayList<Ticket> allTickets = new ArrayList();
        try (Connection connection = ConnectionManager.open();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(ALL_TICKETS_SQL);
            while (resultSet.next()) {
                allTickets.add(new Ticket(
                                resultSet.getInt("id"),
                                resultSet.getString("passport_no"),
                                resultSet.getString("passenger_name"),
                                resultSet.getInt("flight_id"),
                                resultSet.getString("seat_no"),
                                resultSet.getBigDecimal("cost")
                        )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allTickets;
    }


}
