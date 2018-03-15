package com.travix.medusa.busyflights.domain.crazyair;

public class CrazyAirRequest {

    private String origin;
    private String destination;
    private String departureDate;
    private String returnDate;
    private int passengerCount;

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    private CrazyAirRequest(){

    }

    public static class CrazyAirRequestBuilder {

        private String origin;
        private String destination;
        private String departureDate;
        private String returnDate;
        private int passengerCount;

        public CrazyAirRequestBuilder setOrigin(String origin){
            this.origin = origin;
            return this;
        }

        public CrazyAirRequestBuilder setDestination(String destination){
            this.destination = destination;
            return this;
        }

        public CrazyAirRequestBuilder setDepartureDate(String departureDate){
            this.departureDate = departureDate;
            return this;
        }

        public CrazyAirRequestBuilder setReturnDate(String returnDate){
            this.returnDate = returnDate;
            return this;
        }

        public CrazyAirRequestBuilder setPassengerCount(int passengerCount){
            this.passengerCount = passengerCount;
            return this;
        }

        public CrazyAirRequest build(){
            CrazyAirRequest crazyAirRequest = new CrazyAirRequest();
            crazyAirRequest.passengerCount = this.passengerCount;
            crazyAirRequest.returnDate = this.returnDate;
            crazyAirRequest.origin = this.origin;
            crazyAirRequest.destination = this.destination;
            crazyAirRequest.departureDate = this.departureDate;

            return crazyAirRequest;
        }
    }
}

