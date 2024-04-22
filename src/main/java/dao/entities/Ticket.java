package dao.entities;

import java.math.BigDecimal;
import java.util.Objects;

public class Ticket {

    private int id;
    private String passportNo;

    private String passengerName;

    private long flightId;

    private String seatNo;

    private BigDecimal cost;

    public Ticket() {
    }

    public Ticket(int id, String passportNo, String passengerName, long flightId, String seatNo, BigDecimal cost) {
        this.id = id;
        this.passportNo = passportNo;
        this.passengerName = passengerName;
        this.flightId = flightId;
        this.seatNo = seatNo;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && flightId == ticket.flightId && Objects.equals(passportNo, ticket.passportNo) && Objects.equals(passengerName, ticket.passengerName) && Objects.equals(seatNo, ticket.seatNo) && Objects.equals(cost, ticket.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, passportNo, passengerName, flightId, seatNo, cost);
    }

    @Override
    public String toString() {
        return "Ticket{" +
               "id=" + id +
               ", passportNo='" + passportNo + '\'' +
               ", passengerName='" + passengerName + '\'' +
               ", flightId=" + flightId +
               ", seatNo='" + seatNo + '\'' +
               ", cost=" + cost +
               '}';
    }
}
