
public class InputFile {

//    public static StringFile[] inputMassiveRecord(String fileNames) throws IOException {
//
//        // открываем файл
//        BufferedReader reader = new BufferedReader(new FileReader(fileNames));
//        // считываем построчно
//        String line = null;
//        Scanner scanner = null;
//        int index = 0;
//        while ((line = reader.readLine()) != null)
//        {
//            index++;
//        }
//        reader.close();
//
//        StringFile[] masRec = new StringFile[index];
//        for(int i=0;i<masRec.length;i++)
//            masRec[i] = new StringFile();
//
//        index=0;
//        reader = new BufferedReader(new FileReader(fileNames));
//        while ((line = reader.readLine()) != null)
//        {
//            int index2=0;
//            scanner = new Scanner(line);
//            scanner.useDelimiter(",");
//            while (scanner.hasNext()) {
//                String data = scanner.next();
//                if (index2 == 0)
//                    masRec[index].setDate(data);
//                else if (index2 == 1)
//                    masRec[index].setTime(data);
//                else if (index2 == 2)
//                    masRec[index].setOpen(new Double(data));
//                else if (index2 == 3)
//                    masRec[index].setMax(new Double(data));
//                else if (index2 == 4)
//                    masRec[index].setMin(new Double(data));
//                else if (index2 == 5)
//                    masRec[index].setClose(new Double(data));
//                else if (index2 == 6)
//                    masRec[index].setAmount(new Integer(data));
//                else
//                    System.out.println("Некорректные данные::" + data);
//                index2++;
//            }
//            index2=0;
//
//            index++;
//        }
//        reader.close();
//
//        return masRec;
//    }
}
