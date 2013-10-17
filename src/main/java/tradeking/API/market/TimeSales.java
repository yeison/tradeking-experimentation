package tradeking.API.market;

import org.joda.time.LocalDate;
import tradeking.API.enums.Interval;
import tradeking.API.enums.ResponseFormat;

import java.lang.Override;import java.lang.String;import java.sql.Time;

public class TimeSales extends AbstractMarketRequest {

    private final Interval interval;
    private final int requestsPerPage, recordOffset;
    private final LocalDate startDate, endDate;
    private final Time startTime;

    public static class Builder implements tradeking.API.Builder<TimeSales> {
        // Required parameters
        private final String[] symbols;
        private final LocalDate startDate;

        // Optional parameters - initialized to default values
        private LocalDate endDate = new LocalDate();
        private ResponseFormat responseFormat = ResponseFormat.xml;
        private Interval interval = Interval.min5;
        private int requestsPerPage = 10;
        private int recordOffset = 0;
        private Time startTime = Time.valueOf("08:00:00");

        public Builder(LocalDate startDate, String symbol){
            this.symbols = new String[]{symbol};
            this.startDate = startDate;
        }

        public Builder endDate(LocalDate val){
            this.endDate = val;
            return this;
        }

        public Builder format(ResponseFormat val){
            this.responseFormat = val;
            return this;
        }

        public Builder interval(Interval val){
            this.interval = val;
            return this;
        }

        public Builder rpp(int val){
            this.requestsPerPage = val;
            return this;
        }

        public Builder recordOffset(int val){
            this.recordOffset = val;
            return this;
        }

        public Builder startTime(Time val){
            this.startTime = val;
            return this;
        }

        public TimeSales build(){
            return new TimeSales(this);
        }
    }

    private TimeSales(Builder builder) {
        super(builder.symbols, builder.responseFormat);
        interval = builder.interval;
        requestsPerPage = builder.requestsPerPage;
        recordOffset = builder.recordOffset;
        startDate = builder.startDate;
        endDate = builder.endDate;
        startTime = builder.startTime;
    }

    @Override
    public String getRequestURL() {
        return String.format("https://api.tradeking.com/v1/market/timesales.%s?%s&%s&%s&%s&%s&%s",
                format.name(),
                "symbols=" + getSymbols(),
                "interval=" + interval.getValue(),
                "rpp=" + requestsPerPage,
                "index=" + recordOffset,
                "startdate=" + startDate,
                "enddate=" + endDate);
//                "starttime=" + startTime);
    }

}
