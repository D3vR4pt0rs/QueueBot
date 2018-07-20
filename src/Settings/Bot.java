package Settings;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {


    public Bot(DefaultBotOptions botOptions) {
        super(botOptions);
    }


    @Override
    public void onUpdateReceived(Update update) {
        boolean get_command=false;

        if(update.hasMessage()) {
            Message message = update.getMessage();
            if (message!=null && message.hasText()) {

                System.out.println((message.getChat().getUserName())+": "+"''"+(message.getText()+"''"));

                if (message.getText().equals("/help")) {
                    get_command = true;
                    sendMsg(message, "Привет, "+(message.getChat().getFirstName())+" Помощи хочешь??");
                }

                if(!get_command) {
                    sendMsg(message, "Я Вас не понимаю.");

                }

            }
        }



    }

    private void sendMsg(Message message, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(s);

        try{
            sendMessage(sendMessage);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return BotConfig.BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BotConfig.BOT_TOKEN;
    }
}