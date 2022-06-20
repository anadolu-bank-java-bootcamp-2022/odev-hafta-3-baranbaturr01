package com.gokhantamkoc.javabootcamp.odevhafta3.repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.gokhantamkoc.javabootcamp.odevhafta3.model.Candle;

public class CryptoDataCSVRepository implements CSVRepository {

    private final String COMMA_DELIMITER = ",";

    @Override
    public List<Candle> readCSV(String filename) throws FileNotFoundException, IOException {
        List<Candle> candles = new ArrayList<Candle>();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(filename);

        assert inputStream != null;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = bufferedReader.readLine();
        line = bufferedReader.readLine();
        while (line != null) {
            String[] values = line.split(COMMA_DELIMITER);
            long time = Long.parseLong(values[0]);
            double open = Double.parseDouble(values[3]);
            double high = Double.parseDouble(values[4]);
            double low = Double.parseDouble(values[5]);
            double close = Double.parseDouble(values[6]);
            double volume = Double.parseDouble(values[7]);
            candles.add(new Candle(time, open, high, low, close, volume));
            line = bufferedReader.readLine();
        }
        return candles;

    }

}
