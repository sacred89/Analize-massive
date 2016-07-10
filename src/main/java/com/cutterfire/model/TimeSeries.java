package com.cutterfire.model;

import javafx.scene.chart.XYChart;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TimeSeries {
    List<Row> series;
    final LogicScheme logicScheme;
    public long n =0;
    public final long k =10;
    long range = 0;

    public TimeSeries(String fileName,final LogicScheme logicScheme) throws FileNotFoundException {
        // открываем файл
        this.logicScheme = logicScheme;
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        series = reader
                .lines()
                .map(new Function<String, Row>() {
                    @Override
                    public Row apply(String lines) {
                        String[] line = lines.split(",");
                        String[] strings = new String[line.length-1];
                        for (int i=0;i<strings.length;i++) {
                            if (i==0) {
                                strings[i]=line[i]+","+line[i+1];
                            } else{
                                strings[i] = line[i + 1];
                            }
                        }
                        return new Row(strings, TimeSeries.this.logicScheme);
                    }
                })
                .collect(Collectors.toList());
        range = getRange(0);
    }

    public List<Row> getSeries() {
        return series;
    }

    public LogicScheme getLogicScheme() {
        return logicScheme;
    }

    public XYChart.Series getChart() {
        XYChart.Series seriesChart = new XYChart.Series();
        seriesChart.setName("/home/egor/AUDUSD240.csv");
        scaleRow(0);
        scaleRow(2);
        series.forEach(row-> seriesChart.getData().add(new XYChart.Data(row.getRow()[0],row.getRow()[2])));
        return seriesChart;
    }

    public Long getRange(int numberColumn) {
        Long min = Long.MAX_VALUE;
        Long max = Long.MIN_VALUE;

        for (Row row : series){
                if ((Long) row.getRow()[numberColumn]<min) {
                    min = (Long) row.getRow()[numberColumn];
                }
            if ((Long) row.getRow()[numberColumn]>max) {
                    max = (Long) row.getRow()[numberColumn];
            }
        }
        return max-min;
    }

    public FourierSeries getFourier(int numberColumn) {
        Double intercept = getMean(numberColumn);

        List<Double> cosCoeff = new ArrayList<>();
        List<Double> sinCoeff = new ArrayList<>();

        for (int i=1; i<k;i++) {
            Double summA = 0D;
            Double summB = 0D;

            for (Row row : series) {
                summA +=((Double) row.getRow()[numberColumn])*Math.cos((double) i*(Double) row.getRow()[0]);
                summB +=((Double) row.getRow()[numberColumn])*Math.sin((double) i*(Double)row.getRow()[0]);
            }

            cosCoeff.add(summA/n*2);
            sinCoeff.add(summB/n*2);
        }
        return new FourierSeries(sinCoeff,cosCoeff,intercept);
    }

    public Double getMean(int numberColumn) {

        Double summ = 0D;
        Long n=0L;

        for (Row row : series) {
            switch (logicScheme.getTypeValues(numberColumn)) {
                case DOUBLE:
                    summ += (Double) row.getRow()[numberColumn];
                    break;
                case DATE:
                    summ += (Long)row.getRow()[numberColumn];
                    break;
            }
            n++;
        }
        this.n=n;
        return summ/(double)n;
    }


    public void scaleRow(int numberColumn) {
        Object min = null;
        switch (logicScheme.getTypeValues(numberColumn)) {
            case DOUBLE: min = Double.MAX_VALUE;
                break;
            case DATE: min = Long.MAX_VALUE;
                break;
        }

        for (Row row : series){
            switch (logicScheme.getTypeValues(numberColumn)) {
                case DOUBLE: if ((Double) row.getRow()[numberColumn]<(Double) min) min= row.getRow()[numberColumn];
                    break;
                case DATE: if ((Long) row.getRow()[numberColumn]<(Long)min) min= row.getRow()[numberColumn];
                    break;
            }
        }

        Double koefficient = range/Math.PI/2;

        for (Row row : series){
            switch (logicScheme.getTypeValues(numberColumn)) {
                case DOUBLE: row.getRow()[numberColumn] = (Double) row.getRow()[numberColumn]-(Double) min;
                    break;
                case DATE: row.getRow()[numberColumn] =(((Long) row.getRow()[numberColumn]-(Long)min)/koefficient)-Math.PI;
                    break;
            }
        }
    }

}
