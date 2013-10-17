package tradeking.API.market;

import tradeking.API.TradeKingAPICall;
import tradeking.API.enums.ResponseFormat;import java.lang.Override;import java.lang.String;

public class Clock implements TradeKingAPICall{

    private final ResponseFormat format;

    public static class Builder{

        // Optional parameters - initialized to default values
        private ResponseFormat responseFormat = ResponseFormat.xml;

        public Builder format(ResponseFormat val){
            this.responseFormat = val;
            return this;
        }

        public Clock build(){
            return new Clock(this);
        }
    }

    private Clock(Builder builder) {
        format = builder.responseFormat;
    }

    @Override
    public String getRequestURL() {
        return String.format( "https://api.tradeking.com/v1/market/clock.%s", format.name() );
    }
}