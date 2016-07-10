package com.cutterfire;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int period = 3;

        final int LengthMassive = 100;

        //Случайный массив
        List<Double> masFloat = new ArrayList<>();
        for(int i=0; i<LengthMassive;i++) {
            masFloat.add(Math.random()*10);
        }
        List<Double> outFloat = MassiveProizvodnih.proizvodnie(masFloat);
        //inputMassiveProverki
        List<Double> masSravnenii = new ArrayList<>();

        for(int i=0; i<period+1;i++) {
            masSravnenii.add(Math.random()*10);
        }

        List<Double> MasProizvodnihSravnenii = MassiveProizvodnih.proizvodnie(masSravnenii) ;

        int index = MassiveProizvodnih.poziciaShodstva(outFloat,MasProizvodnihSravnenii);

        System.out.println(masFloat.get(MassiveProizvodnih.foundMinValue(masFloat)));

        System.out.println("Blizhaishee shodstvo "+ index);

        System.out.println();


    }
}
