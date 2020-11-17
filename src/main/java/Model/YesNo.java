package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class YesNo {
    public  static String yesNoUser(String fileName,int keyValue,String poiskUser){
        String arrayString="0";
        File newTxt1 = new File("src/main/java/Base/"+fileName+".txt");
        try(BufferedReader reader = new BufferedReader(new FileReader(newTxt1))) {
            String line = reader.readLine();
            List<String> list = new ArrayList<>();
            int count=0;

            while (line !=null){
                list.add(line);
                line = reader.readLine();
                count++;
            }
            String[] m;
            boolean endSikl = false;
            for (int i = 0; i < count; i++) {
                //System.out.println(list.get(i));
                m = list.get(i).split("---");
                for (int i1 = 0; i1 < m.length; i1++) {
                    if(poiskUser.equals(m[keyValue])){
                        arrayString = list.get(i);
                        endSikl = true;
                        break;
                    }
                }

                if(endSikl == true) break;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayString;
    }


}
