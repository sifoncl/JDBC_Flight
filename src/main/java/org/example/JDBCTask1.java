package org.example;

import DataBase.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTask1 {
    public static void main(String[] args) throws SQLException {

        try (Connection connection = ConnectionManager.open()) {
            System.out.println(connection.getTransactionIsolation());


            System.out.println("Task 1");
            //"howMany = чаще всего это больше чем это число"
            int howMany = 2;
            String sql1 = """
                    select passenger_name name, count(ticket.passenger_name) count  from ticket
                    group by ticket.passenger_name
                    having count(ticket.passenger_name)>?
                                        """;
            PreparedStatement statemante = connection.prepareStatement(sql1);
            statemante.setInt(1, howMany);
            ResultSet task1Result = statemante.executeQuery();
            while (task1Result.next()) {
                System.out.println("Имя: " + task1Result.getString("name") + " количество: "
                        + task1Result.getString("count"));
            }


            System.out.println("Task 2");

            String sql2 = """
                    select passenger_name name, count(id) ticketCount from ticket
                    group by passenger_name
                    order by ticketCount desc
                    """;
            PreparedStatement statemante2 = connection.prepareStatement(sql2);
            ResultSet task2Result = statemante2.executeQuery();

            while (task2Result.next()){
                System.out.println("Имя: " + task2Result.getString("name") + " количество: "
                                   + task2Result.getString("ticketCount"));
            }




        }
    }
}
