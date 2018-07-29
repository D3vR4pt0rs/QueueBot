package Employee.UI;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class EmployeeButtons {


    public synchronized void Employee(SendMessage sendMessage) {

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow keyboardFirstRow = new KeyboardRow();

        keyboardFirstRow.add(new KeyboardButton("Открыто"));
        keyboardFirstRow.add(new KeyboardButton("Закрыто"));

        
        
        KeyboardRow keyboadSecondRow = new KeyboardRow();
        
        keyboardSecondtRow.add(new KeyboardButton("Свободен"));
      



        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);



        replyKeyboardMarkup.setKeyboard(keyboard);

    }


}
