package tradeking.API.market;

import tradeking.API.TradeKingAPICall;
import tradeking.API.enums.ResponseFormat;import java.lang.String;import java.lang.StringBuffer;

abstract class AbstractMarketRequest implements TradeKingAPICall {
    protected final String[] symbols;
    protected final ResponseFormat format;


    protected AbstractMarketRequest(String[] symbols, ResponseFormat responseFormat){
        this.symbols = symbols;
        this.format = responseFormat;
    }

    /**
     * @return The symbols delimited by commas
     */
    protected String getSymbols(){
        StringBuffer symbolsString = new StringBuffer();
        for (String symbol : symbols){
            symbolsString.append(symbol + "," );
        }

        return symbolsString.toString();
    }
}
