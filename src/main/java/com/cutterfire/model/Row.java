package com.cutterfire.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Row {
    private Object[] row ;

    public Row(String[] massive,LogicScheme scheme) {

        row = new Object[massive.length];

        for (int i = 0; i < massive.length; i++) {
            TypeValues type = scheme.getTypeValues(i);
            switch (type) {
                case INT: {
                    row[i] = Integer.parseInt(massive[i]);
                    break;
                }
                case STR: {
                    row[i] = massive[i];
                    break;
                }
                case DOUBLE: {
                    row[i] = Double.parseDouble(massive[i]);
                    break;
                }
                case DATE: {
                    DateFormat formatRow = new SimpleDateFormat("yyyy.MM.dd,hh:mm", Locale.ENGLISH);
                    Date date= null;
                    try {
                        date = formatRow.parse(massive[i]);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    row[i] = date.getTime();
                }
                default:
                    new IllegalArgumentException("Illegal logical scheme");
            }
        }
    }

    public Object[] getRow() {
            return row;
        }
}
