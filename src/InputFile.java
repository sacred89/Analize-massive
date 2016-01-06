import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class InputFile {

    public static double[] inputMassiveDouble(String fileNames) throws IOException {

        // открываем файл
        BufferedReader reader = new BufferedReader(new FileReader(fileNames));
        // считываем построчно
        String line = null;
        Scanner scanner = null;
        int index = 0;
        while ((line = reader.readLine()) != null)
        {
            index++;
        }
        reader.close();

        reader = new BufferedReader(new FileReader("C:\\AUDUSD240.csv"));
        scanner=null;

        double[] mas1 = new double[index];

        index=0;
        reader.close();
        return mas1;
    }
}
