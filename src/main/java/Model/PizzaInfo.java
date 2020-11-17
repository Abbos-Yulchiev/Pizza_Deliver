package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PizzaInfo {
    public static String pizzaInfo(String idPizza){
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
                if(idPizza.equals(m[0])){
                    updateRow = "Nomi: "+m[1]+"\n" +
                            "Tarkibi: "+m[2]+"\n" +
                            "Tayyorlash vaqti: "+m[3]+" minut\n" +
                            "Narxi: "+m[4]+" so'm";
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  updateRow;
    }
    public static String pizzaInfoName(String idPizza){
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
                if(idPizza.equals(m[0])){
                    updateRow = "PiZZa: "+m[1]+" ( 1 donasi narxi: "+m[4]+" so'm )";
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  updateRow;
    }
    public static String pizzaInfoSum(String idPizza){
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
                if(idPizza.equals(m[0])){
                    updateRow = m[4];
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  updateRow;
    }
}
