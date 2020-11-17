package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PizzaList {
    public static String pizzaList(){
        File newTxt1 = new File("src/main/java/Base/pizza.txt");
        String updateRow="";
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
            for (int i = 0; i < count; i++) {
               m = list.get(i).split("---");
               updateRow = (updateRow.length() > 0 ? updateRow+"\n" : "")+m[0]+"."+m[1]+" (Narxi: "+m[4]+" so'm)";

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  updateRow;
    }
}
