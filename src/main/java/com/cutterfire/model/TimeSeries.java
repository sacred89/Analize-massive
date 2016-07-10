package com.cutterfire.model;

import javafx.scene.chart.XYChart;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TimeSeries {
    List<Row> series;
    final LogicScheme logicScheme;

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

        for (Row row : series){
            switch (logicScheme.getTypeValues(numberColumn)) {
                case DOUBLE: row.getRow()[numberColumn] = (Double) row.getRow()[numberColumn]-(Double) min;
                    break;
                case DATE: row.getRow()[numberColumn] = (Long) row.getRow()[numberColumn]-(Long)min;
                    break;
            }
        }
    }

}
