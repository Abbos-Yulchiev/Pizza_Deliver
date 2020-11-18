import Model.*;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Main extends TelegramLongPollingBot {
    /*
    ||=======================================================================================================||
    ||                                  Pizza Dostavka Telegram Bot                                          ||
    ||=======================================================================================================||
     */
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi api = new TelegramBotsApi();
        try {
            api.registerBot(new Main());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }


    }

    @Override
    public String getBotToken() {
        return "1244700780:AAHIevRgWqY4Limd5QkPuJikCFTCm78eTr0";
    }

    @Override
    public void onUpdateReceived(Update update) {
        String inputText = update.getMessage().getText();
        String ismi = update.getMessage().getChat().getFirstName();
        String fami = update.getMessage().getChat().getLastName();
        String uName = update.getMessage().getChat().getUserName();
        Integer userId = update.getMessage().getFrom().getId();
        String inputOldText = update.toString();
        System.out.println(inputOldText);
        String[] userData = IsUser.isUser(userId, ismi, fami, uName).split("---");
        //-------------------------------------------------------------------------
        SendMessage sendMessage = new SendMessage();
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(keyboardMarkup);
        keyboardMarkup.setResizeKeyboard(true);
        keyboardMarkup.setOneTimeKeyboard(true);
        keyboardMarkup.setSelective(true);
        List<KeyboardRow> keyboardRows = new ArrayList<KeyboardRow>();
        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();

        //--------------------------------------------------------------------------
        HashMap<String, Integer> keyCaseMap = new HashMap<>();
        keyCaseMap.put("Pizzalar ro'yxati", 1);
        keyCaseMap.put("Mening profilim", 2);
        keyCaseMap.put("Telefon raqam biriktirish", 3);
        keyCaseMap.put("Buyurtma berish", 4);
        keyCaseMap.put("/start", 0);
        int oldQadam = Integer.valueOf(userData[9]);
        boolean submit = false;
        int step = 0;

        if (keyCaseMap.containsKey(inputText)) {
            step = keyCaseMap.get(inputText);
            UserQadamUpdate.userQadamUpdate(userId, step);
        } else {
            step = oldQadam;
            submit = true;
        }

        //--------------------------------------------------------------------------
        switch (step) {
            case 1:
                if (submit == true) {
                    if (IsNumeric.isNumeric(inputText)) {
                        switch (Integer.valueOf(inputText)) {
                            case 1:
                                sendMessage.setText(PizzaInfo.pizzaInfo("1"));
                                TempPizzaId.tempPizzaId(userId, "1");
                                row1.add("Buyurtma berish");
                                break;
                            case 2:
                                sendMessage.setText(PizzaInfo.pizzaInfo("2"));
                                TempPizzaId.tempPizzaId(userId, "2");
                                row1.add("Buyurtma berish");
                                break;
                            case 3:
                                sendMessage.setText(PizzaInfo.pizzaInfo("3"));
                                TempPizzaId.tempPizzaId(userId, "3");
                                row1.add("Buyurtma berish");
                                break;
                            case 4:
                                sendMessage.setText(PizzaInfo.pizzaInfo("4"));
                                TempPizzaId.tempPizzaId(userId, "4");
                                row1.add("Buyurtma berish");
                                break;
                            default:
                                sendMessage.setText("Pizzani tanlash uchun uni tartib raqami kiritilishi shart!\n" +
                                        PizzaList.pizzaList());
                        }
                    } else {
                        sendMessage.setText("Pizzani tanlash uchun uni tartib raqami kiritilishi shart!\n" +
                                PizzaList.pizzaList());
                    }
                } else {
                    sendMessage.setText("Pizzani tanlang!\n" +
                            "Tanlash uchun pizzani tartib raqamini kiriting.\n" +
                            PizzaList.pizzaList());
                }


                sendMessage.setChatId(update.getMessage().getChatId());
                row1.add("Mening buyurtmalarim");
                row2.add("Mening profilim");
                break;
            case 2:
                sendMessage.setText("Mening profilim\n" +
                        "Ismingiz: " + ismi + "!\n" +
                        "Balansingiz: " + userData[8] + " so'm\n" +
                        "Telefon raqamingiz: " + (userData[6].equals("0") ? "kiritilmagan" : userData[6]) + "");
                sendMessage.setChatId(update.getMessage().getChatId());
                row1.add("Mening buyurtmalarim");
                if (userData[6].equals("0")) {
                    row1.add("Telefon raqam biriktirish");
                }
                row2.add("Pizzalar ro'yxati");
                break;
            case 3:
                if (userData[6].equals("0")) {
                    if (submit == true) {

                        if (IsPhone.isNumeric(inputText).equals("1")) {
                            String newNumer = "+998" + inputText;
                            UserPhoneUpdate.userPhoneUpdate(userId, newNumer);
                            sendMessage.setText("Telefon raqamingizni kiritildi!\n" +
                                    "Endi Pizzalarimizni bemalol buyurtma berishingiz mumkin");
                        } else {
                            sendMessage.setText(IsPhone.isNumeric(inputText) + "\n" +
                                    "Telefon raqamni qayta kiriting!");
                        }
                    } else {
                        sendMessage.setText("Telefon raqamingizni kiritng!\n" +
                                "Eslatma: +998 yozilmaydi\n" +
                                "Masalan: 934448840 ");
                    }

                } else {
                    sendMessage.setText("Siz telefon raqam biriktirgansiz!\n" +
                            "Telefon raqamingiz: " + userData[6]);
                }

                sendMessage.setChatId(update.getMessage().getChatId());
                row1.add("Mening profilim");
                row2.add("Pizzalar ro'yxati");
                break;
            case 4:
                if (userData[10].equals("0")) {
                    sendMessage.setText("Avval Pizzalar ro'yxatidan Pizza tanlang!");


                } else {
                    if (submit == true) {
                        if (IsNumeric.isNumeric(inputText)) {
                            if (inputText.equals("0")) {
                                sendMessage.setText(PizzaInfo.pizzaInfoName(userData[10]) + "\n" +
                                        "Nechta buyurtma bermoqchisiz? (Masalan: 3 )");
                            } else {
                                int chiqim = Integer.parseInt(inputText) * Integer.parseInt(PizzaInfo.pizzaInfoSum(userData[10]));
                                if (chiqim > Integer.parseInt(userData[8])) {
                                    sendMessage.setText(PizzaInfo.pizzaInfoName(userData[10]) + "\n" +
                                            "Bu Pizzadan " + inputText + " ta sotib olishga pulingiz yetmadi." +
                                            "Avval hisobingizni to'ldiring!\n ( BIZDA NASIYAGA SAVDO YO'Q HATTO SIZGA HAM :)");
                                } else {
                                    sendMessage.setText("Sizning buyurtmangiz qabul qilindi!" +
                                            "\nBuyurtmangiz " + PizzaInfo.pizzaInfoName(userData[10]));
                                    sendMessage.setChatId(update.getMessage().getChatId());
                                    System.out.println("Buyurtma qabul qilindi");
                                    // OK buyurtma berish kerak

                                }
                            }
                        } else {
                            sendMessage.setText(PizzaInfo.pizzaInfoName(userData[10]) + "\n" +
                                    "Nechta buyurtma bermoqchisiz? (Masalan: 2 )");
                        }
                    } else {
                        sendMessage.setText(PizzaInfo.pizzaInfoName(userData[10]) + "\n" +
                                "Nechta buyurtma bermoqchisiz?");
                    }
                }
                sendMessage.setChatId(update.getMessage().getChatId());
                row1.add("Mening profilim");
                row2.add("Pizzalar ro'yxati");
                break;
            default:
                if (inputText.equals("/start")) {
                    sendMessage.setText("Assalomu Alaykum " + ismi + "!\n\"ABBALI PIZZA\"ga hush kelibsiz!\n" +
                            "Mazali Pizzalarimizga online buyurtma bering!");
                    sendMessage.setChatId(update.getMessage().getChatId());
                    row1.add("Pizzalar ro'yxati");
                    row2.add("Mening profilim");
                }
        }

        //---------------------------------------------------------------------------
        keyboardRows.add(row1);
        keyboardRows.add(row2);
        keyboardMarkup.setKeyboard(keyboardRows);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "abbali_pizza_bot";
    }
}
