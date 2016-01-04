public class Main {

    public static void main(String[] args) {

        //inputMassiveProverki
        double[] masFloat = {1.2, 2.6 ,3.8 ,4.9 ,5.8 ,6.2, 5.4, 3.2, 4.5, 5.8};

        double[] outFloat = MassiveProizvodnih.proizvodnie(masFloat);

        int period = 3;

        //inputMassiveProverki
        double[] masSravnenii = {5.4,3.2,4.5,5.9};

        double[] MasProizvodnihSravnenii = MassiveProizvodnih.proizvodnie(masSravnenii) ;



        int index = MassiveProizvodnih.poziciaShodstva(outFloat,MasProizvodnihSravnenii, period);

        System.out.println(masFloat[MassiveProizvodnih.foundMinValue(masFloat)]);

        System.out.println("Blizhaishee shodstvo "+ index);

        for (int i=index;i<index+period;i++) {

            System.out.println(outFloat[i]);
        }

        System.out.println();


    }
}
