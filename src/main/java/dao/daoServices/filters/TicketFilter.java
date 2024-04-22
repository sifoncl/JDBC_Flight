package dao.daoServices.filters;

import java.math.BigDecimal;

public class TicketFilter {
    private Integer id;
    private String passportNo;

    private String passengerName;

    private Long flightId;

    private String seatNo;

    private BigDecimal cost;

    private Integer limit;
    private Integer offset;

    public TicketFilter() {
    }

    public TicketFilter(Integer id,
                        String passportNo, String passengerName, Long flightId, String seatNo, BigDecimal cost, Integer limit, Integer offset) {
        this.id = id;
        this.passportNo = passportNo;
        this.passengerName = passengerName;
        this.flightId = flightId;
        this.seatNo = seatNo;
        this.cost = cost;
        this.limit = limit;
        this.offset = offset;
    }

    public Integer getId() {
        return id;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public Long getFlightId() {
        return flightId;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public Integer getLimit() {
        return limit;
    }

    public Integer getOffset() {
        return offset;
    }


    public static final class TicketFilterBuilder {
        private Integer id;
        private String passportNo;
        private String passengerName;
        private Long flightId;
        private String seatNo;
        private BigDecimal cost;
        private Integer limit;
        private Integer offset;

        private TicketFilterBuilder() {
        }

        public static TicketFilterBuilder aTicketFilter() {
            return new TicketFilterBuilder();
        }

        public TicketFilterBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public TicketFilterBuilder withPassportNo(String passportNo) {
            this.passportNo = passportNo;
            return this;
        }

        public TicketFilterBuilder withPassengerName(String passengerName) {
            this.passengerName = passengerName;
            return this;
        }

        public TicketFilterBuilder withFlightId(Long flightId) {
            this.flightId = flightId;
            return this;
        }

        public TicketFilterBuilder withSeatNo(String seatNo) {
            this.seatNo = seatNo;
            return this;
        }

        public TicketFilterBuilder withCost(BigDecimal cost) {
            this.cost = cost;
            return this;
        }

        public TicketFilterBuilder withLimit(Integer limit) {
            this.limit = limit;
            return this;
        }

        public TicketFilterBuilder withOffset(Integer offset) {
            this.offset = offset;
            return this;
        }

        public TicketFilter build() {
            return new TicketFilter(id, passportNo, passengerName, flightId, seatNo, cost, limit, offset);
        }
    }
}