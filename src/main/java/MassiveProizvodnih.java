import java.util.ArrayList;
import java.util.List;

public class MassiveProizvodnih {

    public static List<Double> proizvodnie(List<Double> inputMassive) {
        List<Double> outMassive = new ArrayList<>();
        outMassive.add(inputMassive.get(0));
    for(int i=0;i<(inputMassive.size()-1);i++) {
        outMassive.add(inputMassive.get(i+1)-inputMassive.get(i));
    }
        return outMassive;
    }

    public static int poziciaShodstva(List<Double> inputMassive, List<Double> inMasSravnenii) {

        int x;

        List<Double> outMassive = new ArrayList<>();

        for(int i=0;i<inputMassive.size()-inMasSravnenii.size();i++) {
            outMassive.add(0D);
            for(int k=0;k<inMasSravnenii.size();k++)
                outMassive.set(i,outMassive.get(i)+Math.abs(inputMassive.get(i+k)-inMasSravnenii.get(k)));
        }

        x=foundMinValue(outMassive);
        return x;
    }

    public static int foundMinValue(List<Double> inMassive) {
        int min=0;
        for(int i=1;i<inMassive.size();i++) {
            if (inMassive.get(min) >= inMassive.get(i)) min=i;
        }
        return min;
    }

    public static void consolOutMassive(final double[] array) {
        for(int i=0;i<array.length;i++) {
            System.out.print("(" + i +")" + array[i]+" ");
        }
        System.out.println();

    }

}
