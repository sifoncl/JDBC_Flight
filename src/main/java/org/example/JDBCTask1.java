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

            while (task2Result.next()) {
                System.out.println("Имя: " + task2Result.getString("name") + " количество: "
                                   + task2Result.getString("ticketCount"));
            }


            System.out.println("Task 3");

            int ticketId = 55;
            String passportNo = "2233BB";
            String passengerName = "Новый пасажир";
            long flightId = 9;
            String seatNo = "B52";
            int cost = 300;

            String sql3 = """
                    update ticket
                    set passport_no =?, passenger_name=?, flight_id=?, seat_no=?, cost =?
                    where id =?;
                         """;
            PreparedStatement statemante3 = connection.prepareStatement(sql3);
            statemante3.setString(1, passportNo);
            statemante3.setString(2, passengerName);
            statemante3.setLong(3, flightId);
            statemante3.setString(4, seatNo);
            statemante3.setInt(5, cost);
            statemante3.setInt(6, ticketId);

            System.out.println(statemante3.execute());

            System.out.println("Task 4");

            String status = "Прилетел";
            flightId = 9L;
            passportNo = "ABC123";
            passengerName = "КТО-ТО ТАМЫЧ";
            cost = 2333;
            try {
                connection.setAutoCommit(false);
                String sqlUpDate1 = """
                                
                        update ticket
                        set passport_no =?, passenger_name=?, cost =?
                        where flight_id =?;
                        """;

                PreparedStatement statemanteUp1 = connection.prepareStatement(sqlUpDate1);

                statemanteUp1.setString(1, passportNo);
                statemanteUp1.setString(2, passengerName);
                statemanteUp1.setInt(3, cost);
                statemanteUp1.setLong(4, flightId);

                String sqlUpDate2 = """
                        update flight
                                 set status=?
                                 where id =?;
                         """;
                PreparedStatement statemanteUp2 = connection.prepareStatement(sqlUpDate2);

                statemanteUp2.setString(1, status);
                statemanteUp2.setLong(2, flightId);

                statemanteUp1.execute();
                System.out.println("отправил 1");
                statemanteUp2.execute();
                System.out.println("отправил 2");

                connection.commit();
                System.out.println("Закомител");
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Сделал робэк");
                connection.rollback();
            }
        }
    }
}