package Model;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class AddUsers {
    public static String addUsers(String str,int pages){


        if(pages == 1){
            File txt3 = new File("src/main/java/Base/users.txt");
            try(OutputStream outputStream = new FileOutputStream(txt3);) {
                outputStream.write(str.getBytes());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            File txt = new File("src/main/java/Base/users.txt");
            try(OutputStream outputStream = new FileOutputStream(txt,true);) {
                str = "\n"+str;
                outputStream.write(str.getBytes());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return str;
    }

}
