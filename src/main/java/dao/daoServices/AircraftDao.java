package dao.daoServices;

import dao.entities.Aircraft;
import dataBase.ConnectionManager;


import java.sql.*;
import java.util.ArrayList;

public class AircraftDao {

    private static final String CREATE_SQL = """
            insert into aircraft (model)
            values (?);
            """;

    private static final String ALL_AITRCRAFTS_SQL = """
            select id, model from aircraft;
            """;

    private static final String DELETE_SQL = """
            delete from aircraft
            where id = ?;
            """;

    public static ArrayList<Aircraft> allAircrafts() {
        ArrayList<Aircraft> allAircrafts = new ArrayList();
        try (Connection connection = ConnectionManager.open();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(ALL_AITRCRAFTS_SQL);
            while (resultSet.next()) {
                allAircrafts.add(new Aircraft(resultSet.getInt("id"), resultSet.getString("model")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allAircrafts;
    }


    public static void create(Aircraft aircraft) {
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_SQL)) {
            preparedStatement.setString(1, aircraft.getModel());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void delete(int id) {
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private AircraftDao() {
    }
}
