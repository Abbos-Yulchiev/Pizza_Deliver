package Model;

public class IsPhone {

        public static String isNumeric(String str) {
            if (str == null) {
                return "Telefon raqamni kiriting";
            }
            int sz = str.length();
            if(sz != 9){
                return "Telefon raqam 9 xonalik kiritilishi kerak.\n" +
                        "+998 ni kiritmang";
            }
            boolean harfbor = false;
            for (int i = 0; i < sz; i++) {
                if (Character.isDigit(str.charAt(i)) == false) {
                    harfbor =  true;
                    break;
                }
            }
            if(harfbor == true){
                return "Telefon nomer kiritishda faqat raqamlardan foydalaning";
            }
            return "1";
        }

}
