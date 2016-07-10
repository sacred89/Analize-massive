package com.cutterfire.model;

import java.util.ArrayList;
import java.util.List;

public class LogicScheme {

    private List<String> columnNames;
    private List<TypeValues> dataType;

    public LogicScheme() {
        columnNames = new ArrayList<>();
        dataType = new ArrayList<>();
    }

    public void appendColumn(String name, TypeValues typeValues) {
        columnNames.add(name);
        dataType.add(typeValues);
    }

    public TypeValues getTypeValues(int index) {
        return dataType.get(index);
    }

    public String getColumnName(int index) {
        return columnNames.get(index);
    }

}
