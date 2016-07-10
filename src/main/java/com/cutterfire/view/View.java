package com.cutterfire.view;

import com.cutterfire.GlobalVariable;
import com.cutterfire.model.LogicScheme;
import com.cutterfire.model.TimeSeries;
import com.cutterfire.model.TypeValues;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
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

        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("date");

        MainLineChart mainLineChart = new MainLineChart(xAxis,yAxis);
        mainLineChart.setTitle(textField.getText());

        loadButton.setOnAction(event-> {
            System.out.println("Loading...");
            LogicScheme logicScheme = new LogicScheme();
            logicScheme.appendColumn("date", TypeValues.DATE);
            logicScheme.appendColumn("in",TypeValues.DOUBLE);
            logicScheme.appendColumn("out",TypeValues.DOUBLE);
            logicScheme.appendColumn("min",TypeValues.DOUBLE);
            logicScheme.appendColumn("max",TypeValues.DOUBLE);
            logicScheme.appendColumn("count",TypeValues.INT);
            try {
                ts = new TimeSeries(textField.getText(),logicScheme);
                if (mainLineChart.getData().isEmpty())
                    mainLineChart.getData().addAll(ts.getChart());
                else {
                    XYChart.Series seriesChart = new XYChart.Series();
                    seriesChart.getData().add((new XYChart.Data(0L,0.150)));
                    seriesChart.getData().add((new XYChart.Data(ts.getRange(0),0.150)));
                    seriesChart.setName("dasd");
                    mainLineChart.getData().addAll(seriesChart);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                textField.setText("Введён не корректный путь");
            }

            System.out.println("Loading done");

        });

        clearButton.setOnAction(event ->mainLineChart.getData().clear());

        Group root = new Group(textField,loadButton,clearButton,mainLineChart);
        Scene scene = new Scene(root, GlobalVariable.WEIGHT, GlobalVariable.HEIGHT);

        Stage stage = new Stage();
        stage.setTitle("Всё для любимого дяди");
        stage.setScene(scene);
        stage.show();
    }



    public void set(TimeSeries ts) {
        this.ts= ts;
    }

    public TimeSeries getTs() {
        return ts;
    }


}
