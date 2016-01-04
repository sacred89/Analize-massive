public class MassiveProizvodnih {

    public static double[] proizvodnie(final double[] inputMassive) {

        double[] outMassive = new double[inputMassive.length-1];
    for(int i=0;i<(inputMassive.length-1);i++) {
        outMassive[i]=(inputMassive[i+1]-inputMassive[i]);
    }
        return outMassive;
    }

    public static int poziciaShodstva(final double[] inputMassive, double[] inMasSravnenii,int period) {

        int x=0;

        double[] outMassive = new double[inputMassive.length-period+1];

        for(int i=0;i<outMassive.length;i++) {
            for(int k=0;k<period;k++)
            outMassive[i]+=Math.abs(inputMassive[i+k]-inMasSravnenii[k]);
        }

        x=foundMinValue(outMassive);
        return x;
    }

    public static int foundMinValue(final double[] inMassive) {
        int b=0;
        for(int i=1;i<inMassive.length;i++) {
            if (inMassive[b] >= inMassive[i]) b=i;
        }
        return b;
    };

}
