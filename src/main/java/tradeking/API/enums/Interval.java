package tradeking.API.enums;

import java.lang.String;public enum Interval {
    min5("5min"),
    min1("1min"),
    tick("tick");


    private final String value;
    Interval(String requestValue) {
        this.value = requestValue;
    }

    public String getValue() {
        return value;
    }
}
