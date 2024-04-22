package dao.daoServices.filters;

import java.time.LocalDateTime;

public record FlightFilter(Integer id,
                           String flightNo,

                           LocalDateTime departureDate,

                           String departureAirportCode,

                           String arrivalAirportCode,

                           LocalDateTime arriveDate,


                           Integer aircraftId,

                           String status) {
}
