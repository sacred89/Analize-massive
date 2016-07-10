package com.cutterfire.view;

import javafx.beans.NamedArg;
import javafx.collections.ObservableList;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.shape.Circle;

public class MainLineChart extends LineChart {
    public MainLineChart(@NamedArg("xAxis") Axis axis, @NamedArg("yAxis") Axis axis2) {
        super(axis, axis2);
        setTranslateY(40);
        setTranslateX(20);
        setPrefWidth(750);
        setPrefHeight(550);
        setCreateSymbols(false);
    }

    public MainLineChart(@NamedArg("xAxis") Axis axis, @NamedArg("yAxis") Axis axis2, @NamedArg("data") ObservableList data) {
        super(axis, axis2, data);
        setTranslateY(40);
        setTranslateX(20);
    }

}
