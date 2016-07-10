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

        StringBuffer sb = new StringBuffer("Function = "+ intecept+ "+");
        for (int i=0;i<cosCoeff.size();i++) {
            sb.append(String.format("%(.5f * cos(", cosCoeff.get(i)) + "x*" + (i+1)+")+");
            sb.append(String.format("%(.5f * sin(", sinCoeff.get(i)) + "x*" + (i+1)+")+");
            sb.append("\n");
        }
        System.out.println(cosCoeff.size());
        System.out.println(sinCoeff.size());
        return sb.substring(0,sb.length()-1);

    }
}
