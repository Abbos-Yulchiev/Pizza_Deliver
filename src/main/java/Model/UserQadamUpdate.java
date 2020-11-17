package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserQadamUpdate {
    public static boolean userQadamUpdate(int user_id,int qada){
        boolean result = false;
        File newTxt1 = new File("src/main/java/Base/users.txt");
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
            boolean shu=false;
            for (int i = 0; i < count; i++) {
                //System.out.println(list.get(i));
                m = list.get(i).split("---");
                for (int i1 = 0; i1 < m.length; i1++) {
                    if(String.valueOf(user_id).equals(m[1])){

                        shu = true;
                    }
                }
                if(shu == true) {
                    updateRow = (updateRow.length()>3 ? "\n" : "") + m[0] + "---" +
                            m[1] + "---" +
                            m[2] + "---" +
                            m[3] + "---" +
                            m[4] + "---" +
                            m[5] + "---" +
                            m[6] + "---" +
                            m[7] + "---" +
                            m[8] + "---" +
                            qada+ "---" +
                            m[10];

                }else{
                    updateRow = (updateRow.length()>3 ? "\n" : "")+ list.get(i);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File txt3 = new File("src/main/java/Base/users.txt");


            try(OutputStream outputStream = new FileOutputStream(txt3);) {
                outputStream.write(updateRow.getBytes());

            } catch (IOException e) {
                e.printStackTrace();
            }
        return  result;
    }
}
