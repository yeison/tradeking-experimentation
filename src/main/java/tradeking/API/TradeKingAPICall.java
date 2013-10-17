package tradeking.API;

import java.lang.String;public interface TradeKingAPICall {

    /**
     * @return The request URL e.g. /v1/market/quotes.xml?symbols=AAPL,QQQ,MSFT,AAPL120721C00200000
     */
    String getRequestURL();

}
