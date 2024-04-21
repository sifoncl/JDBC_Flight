package dao.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Flight {

    private int id;
    private String flightNo;

    private LocalDateTime departureDate;

    private String departureAirportCode;

    private String arrivalAirportCode;

    private LocalDateTime arriveDate;


    private int aircraftId;

    private String status;


    public Flight() {
    }

    public Flight(int id, String flightNo, LocalDateTime departureDate, String departureAirportCode,
                  String arrivalAirportCode,
                  LocalDateTime arriveDate, int aircraftId, String status) {
        this.id = id;
        this.flightNo = flightNo;
        this.departureDate = departureDate;
        this.departureAirportCode = departureAirportCode;
        this.arrivalAirportCode = arrivalAirportCode;
        this.arriveDate = arriveDate;

        this.aircraftId = aircraftId;
        this.status = status;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getArrivalAirportCode() {
        return arrivalAirportCode;
    }

    public void setArrivalAirportCode(String arrivalAirportCode) {
        this.arrivalAirportCode = arrivalAirportCode;
    }

    public LocalDateTime getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(LocalDateTime arriveDate) {
        this.arriveDate = arriveDate;
    }


    public int getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(int aircraftId) {
        this.aircraftId = aircraftId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return id == flight.id && aircraftId == flight.aircraftId && Objects.equals(flightNo, flight.flightNo)
               && Objects.equals(departureDate, flight.departureDate)
               && Objects.equals(departureAirportCode, flight.departureAirportCode)
               && Objects.equals(arrivalAirportCode, flight.arrivalAirportCode)
               && Objects.equals(arriveDate, flight.arriveDate)
               && Objects.equals(status, flight.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flightNo, departureDate, departureAirportCode,
                arrivalAirportCode, arriveDate, aircraftId, status);
    }

    @Override
    public String toString() {
        return "Flight{" +
               "id=" + id +
               ", flightNo='" + flightNo + '\'' +
               ", departureDate=" + departureDate +
               ", departureAirportCode='" + departureAirportCode + '\'' +
               ", arrivalAirportCode='" + arrivalAirportCode + '\'' +
               ", arriveDate=" + arriveDate +
               ", aircraftId=" + aircraftId +
               ", status='" + status + '\'' +
               '}';
    }
}
