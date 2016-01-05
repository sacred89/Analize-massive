public class Main {

    public static void main(String[] args) {

        int period = 3;

        //inputMassiveProverki
        double[] masFloat = new double[20];
        for(int i=0; i<masFloat.length;i++) {
            masFloat[i]=Math.random()*10;
        }

        double[] outFloat = MassiveProizvodnih.proizvodnie(masFloat);

        //inputMassiveProverki
        double[] masSravnenii = new double[period+1];
        for(int i=0; i<masSravnenii.length;i++) {
            masFloat[i]=Math.random()*10;
        }

        double[] MasProizvodnihSravnenii = MassiveProizvodnih.proizvodnie(masSravnenii) ;

        int index = MassiveProizvodnih.poziciaShodstva(outFloat,MasProizvodnihSravnenii, period);

        System.out.println(masFloat[MassiveProizvodnih.foundMinValue(masFloat)]);

        System.out.println("Blizhaishee shodstvo "+ index);

        for (int i=index; i<index+period; i++) {

            System.out.println(outFloat[i]);
        }

        System.out.println();


    }
}
