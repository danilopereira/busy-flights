package com.travix.medusa.busyflights.domain.toughjet;

public class ToughJetRequest {

    private String from;
    private String to;
    private String outboundDate;
    private String inboundDate;
    private int numberOfAdults;

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getOutboundDate() {
        return outboundDate;
    }

    public String getInboundDate() {
        return inboundDate;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    private ToughJetRequest(){

    }

    public static class ToughJetRequestBuilder{
        private String from;
        private String to;
        private String outboundDate;
        private String inboundDate;
        private int numberOfAdults;

        public ToughJetRequestBuilder setFrom(String from){
            this.from = from;
            return this;
        }

        public ToughJetRequestBuilder setTo(String to){
            this.to = to;
            return this;
        }

        public ToughJetRequestBuilder setOutboundDate(String outboundDate){
            this.outboundDate = outboundDate;
            return this;
        }

        public ToughJetRequestBuilder setInboundDate(String inboundDate){
            this.inboundDate = inboundDate;
            return this;
        }
        public ToughJetRequestBuilder setNumberOfAdults(int numberOfAdults){
            this.numberOfAdults = numberOfAdults;
            return this;
        }

        public ToughJetRequest build(){
            ToughJetRequest toughJetRequest = new ToughJetRequest();
            toughJetRequest.from = this.from;
            toughJetRequest.to = this.to;
            toughJetRequest.inboundDate = this.inboundDate;
            toughJetRequest.outboundDate = this.outboundDate;
            toughJetRequest.numberOfAdults = this.numberOfAdults;

            return toughJetRequest;
        }
    }
}
