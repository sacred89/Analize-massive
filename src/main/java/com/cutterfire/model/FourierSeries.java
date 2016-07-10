package com.cutterfire.model;

import java.util.List;

/**
 * Created by egor on 10.07.16.
 */
public class FourierSeries {
    List<Double> sinCoeff;
    List<Double> cosCoeff;
    Double intecept;

    public FourierSeries(List<Double> sinCoeff, List<Double> cosCoeff, Double intecept) {
        this.sinCoeff = sinCoeff;
        this.cosCoeff = cosCoeff;
        this.intecept = intecept;
    }

    public List<Double> getSinCoeff() {
        return sinCoeff;
    }

    public List<Double> getCosCoeff() {
        return cosCoeff;
    }

    public Double getIntecept() {
        return intecept;
    }

    public int getSIze(){
        return sinCoeff.size();
    }

    public Double transform(double x) {
        Double value = intecept;

        for (int i = 0 ; i<sinCoeff.size();i++) {
            value+= cosCoeff.get(i)* Math.cos((i+1)*x);
        }
        for (int i = 0 ; i<sinCoeff.size();i++) {
            value+= sinCoeff.get(i)* Math.sin((i+1)*x);
        }

        return value;
    }

    @Override
    public String toString() {
        return "FourierSeries{" +
                "sinCoeff=" + sinCoeff +
                ", cosCoeff=" + cosCoeff +
                ", intecept=" + intecept +
                '}';
    }
}
