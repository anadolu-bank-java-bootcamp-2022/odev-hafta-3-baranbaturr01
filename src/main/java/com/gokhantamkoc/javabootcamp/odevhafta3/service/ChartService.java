package com.gokhantamkoc.javabootcamp.odevhafta3.service;

import com.gokhantamkoc.javabootcamp.odevhafta3.model.Candle;
import com.gokhantamkoc.javabootcamp.odevhafta3.repository.CSVRepository;
import com.gokhantamkoc.javabootcamp.odevhafta3.util.chart.CandleStickChart;

import java.io.IOException;
import java.util.List;

public class ChartService {

    CSVRepository cryptoDataCSVRepository;

    public ChartService(CSVRepository cryptoDataCSVRepository) {
        this.cryptoDataCSVRepository = cryptoDataCSVRepository;
    }

    public CandleStickChart createChartFromCryptoData() {


        CandleStickChart candleStickChart = new CandleStickChart("BTC/USDT Chart");

        try {
            List<Candle> candles = cryptoDataCSVRepository.readCSV("Binance_BTCUSDT_d.csv");
            for (Candle candle : candles) {
                candleStickChart.addCandle(candle.getTime(), candle.getOpen(), candle.getHigh(), candle.getLow(), candle.getClose(), candle.getVolume());
            }
        } catch (IOException e) {
            e.printStackTrace();

        }

        return candleStickChart;
    }
}
