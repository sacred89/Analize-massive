package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
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
                .map(lines -> new Row(lines.split(","),this.logicScheme))
                .collect(Collectors.toList());
    }

    public List<Row> getSeries() {
        return series;
    }

    public LogicScheme getLogicScheme() {
        return logicScheme;
    }
}
