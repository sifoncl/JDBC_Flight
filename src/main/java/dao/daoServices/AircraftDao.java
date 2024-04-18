package dao.daoServices;

import dao.entities.Aircraft;
import dataBase.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AircraftDao {

    private static AircraftDao instance;


    private static final String CREATE_SQL = """
            insert into aircraft (model)
            values (?);
            """;

    private static final String DELETE_SQL = """
            delete from aircraft
            where id = ?;
            """;


    public static void create(Aircraft aircraft) {
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_SQL)) {
            preparedStatement.setString(1, aircraft.getModel());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void delete(int id){
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

    public static AircraftDao getInstance() {
        if (instance == null) {
            instance = new AircraftDao();
        }
        return instance;
    }

}
