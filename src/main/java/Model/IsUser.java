package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Date;

public class IsUser {
    public  static String isUser(int user,String ism,String  fam, String tlgName){
        String sessionString="";
        Date date = new Date();
        int oldUserId = CountRow.countRow("users");
        int newUserId = oldUserId+1;
        String userBaseText;
        if(oldUserId == 0){
            userBaseText = newUserId+"---"+
                    user+"---"+
                    ism+ "---"+
                    tlgName+"---"+
                    date+"---"+
                    date.getTime()+"---"+
                    "0"+"---"+
                    "locatsa"+"---"+
                    "1000000"+"---"+
                    "0"+"---"+
                    "0";
            sessionString = AddUsers.addUsers(userBaseText,1);
        }else{

            String dataUser = YesNo.yesNoUser("users",1,String.valueOf(user));
            if(dataUser.equals("0")){
                userBaseText = newUserId+"---"+
                        user+"---"+
                        ism+ "---"+
                        tlgName+"---"+
                        date+"---"+
                        date.getTime()+"---"+
                        "0"+"---"+
                        "locatsa"+"---"+
                        "1000000"+"---"+
                        "0"+"---" +
                        "0";
                sessionString =  AddUsers.addUsers(userBaseText,2);
            }else{
                sessionString = dataUser;
            }
        }
        return sessionString;
    }
}
