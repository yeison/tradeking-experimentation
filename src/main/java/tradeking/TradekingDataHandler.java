package tradeking;

import org.codehaus.jackson.map.ObjectMapper;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.mortbay.io.Buffer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

/** HANDLES data from tradeking API */
public class TradekingDataHandler {
    private final String streamFile;
    private final FileOutputStream fileOutputStream;


    public TradekingDataHandler() throws FileNotFoundException {
        streamFile = String.format("/tmp/tradeking.response.%s-%s", new LocalDate(), new LocalTime());
        fileOutputStream = new FileOutputStream(streamFile);
    }

    public void handleBuffer(Buffer data){

        try {
            while (data.hasContent())
                data.writeTo(fileOutputStream);

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    public void handleData(){
        HashMap<String,Object> result = null;

        try {
            FileInputStream fileInputStream = new FileInputStream(streamFile);
            result = new ObjectMapper().readValue(fileInputStream, HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        System.out.println(result);
    }

}