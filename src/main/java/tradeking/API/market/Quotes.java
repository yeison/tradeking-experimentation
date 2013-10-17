package tradeking.API.market;

import tradeking.API.TradeKingAPICall;
import tradeking.API.enums.ResponseFormat;import java.lang.Override;import java.lang.String;import java.lang.StringBuffer;

/**
 * This call will begin streaming quote and trade payloads for a symbol or list of symbols passed as a query parameter (see query parameters below).
 */
public class Quotes implements TradeKingAPICall {

    private final String[] symbols;
    private final ResponseFormat format;

    public static class Builder{
        // Required parameters
        private final String[] symbols;

        // Optional parameters - initialized to default values
        private ResponseFormat responseFormat = ResponseFormat.xml;

        public Builder(String ... symbols){
            this.symbols = symbols;
        }

        public Builder format(ResponseFormat val){
            this.responseFormat = val;
            return this;
        }

        public Quotes build(){
            return new Quotes(this);
        }
    }

    private Quotes(Builder builder) {
        symbols = builder.symbols;
        format = builder.responseFormat;
    }

    @Override
    public String getRequestURL() {
        return String.format("https://stream.tradeking.com/v1/market/quotes.%s?symbols=%s",
                                format.name(), getSymbols() );
    }

    /**
     * @return The symbols delimited by commas
     */
    private String getSymbols(){
        StringBuffer symbolsString = new StringBuffer();
        for (String symbol : symbols){
            symbolsString.append(symbol + "," );
        }

        return symbolsString.toString();
    }
}