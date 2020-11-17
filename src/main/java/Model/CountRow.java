package Model;

import java.io.*;
/*
   ||=======================================================================================================||
   ||    txt faylda nechta qator borligini aniqlash funksiyasi:                                             ||
   ||       - fileName => txt fayl nomi                                                                     ||
   ||=======================================================================================================||
    */
public class CountRow {
    public static int countRow(String fileName){
        File file = new File("src/main/java/Base/"+fileName+".txt");
        int count=0;
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line !=null){
                count++;
                line = reader.readLine();
            }
          // return count;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

}
