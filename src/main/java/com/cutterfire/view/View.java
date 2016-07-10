package com.cutterfire.view;

import com.cutterfire.GlobalVariable;
import com.cutterfire.model.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class View extends Application {

    public static TimeSeries ts;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        FileLoadEdit textField = new FileLoadEdit("/home/egor/AUDUSD240.csv",10,10,230);
        LoadButton loadButton = new LoadButton("Load",250,10);
        Button clearButton = new Button("Clear");
        clearButton.setTranslateX(350);
        clearButton.setTranslateY(10);

        Button analiZeButton = new Button("AnaliZe");
        analiZeButton.setTranslateX(450);
        analiZeButton.setTranslateY(10);

        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("date");

        MainLineChart mainLineChart = new MainLineChart(xAxis,yAxis);
        mainLineChart.setTitle(textField.getText());

        TextArea textArea = new TextArea();
        textArea.setTranslateX(10);
        textArea.setTranslateY(610);
        textArea.setPrefHeight(130);
        textArea.setPrefWidth(780);
        textArea.setScrollLeft(0.5);

        loadButton.setOnAction(event-> {
            try {
                    System.out.println("Loading...");
                    LogicScheme logicScheme = new LogicScheme();
                    logicScheme.appendColumn("date", TypeValues.DATE);
                    logicScheme.appendColumn("in",TypeValues.DOUBLE);
                    logicScheme.appendColumn("out",TypeValues.DOUBLE);
                    logicScheme.appendColumn("min",TypeValues.DOUBLE);
                    logicScheme.appendColumn("max",TypeValues.DOUBLE);
                    logicScheme.appendColumn("count",TypeValues.INT);
                    ts = new TimeSeries(textField.getText(),logicScheme);
                    mainLineChart.getData().addAll(ts.getChart());

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                textField.setText("Введён не корректный путь");
            }

            System.out.println("Loading done");

        });

        analiZeButton.setOnAction(event1 -> {
            FourierSeries fourierSeries = ts.getFourier(2);
            textArea.setText(fourierSeries.toString());
            XYChart.Series seriesChart = new XYChart.Series();
            for (Row row :ts.getSeries()) {
                Double x = (Double) row.getRow()[0];
                Double y = fourierSeries.transform(x);
                seriesChart.getData().add((new XYChart.Data(x,y)));
            }
            mainLineChart.getData().addAll(seriesChart);
        });

        clearButton.setOnAction(event ->mainLineChart.getData().clear());

        Group root = new Group(textField,loadButton,clearButton,mainLineChart,analiZeButton,textArea);
        Scene scene = new Scene(root, GlobalVariable.WEIGHT, GlobalVariable.HEIGHT);

        Stage stage = new Stage();
        stage.setTitle("Всё для любимого дяди");
        stage.setScene(scene);
        stage.show();
    }


}
