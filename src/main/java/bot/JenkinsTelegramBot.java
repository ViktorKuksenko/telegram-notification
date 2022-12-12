package bot;

//import com.sun.org.slf4j.internal.LoggerFactory;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

//@Data
//@AllArgsConstructor
public class JenkinsTelegramBot extends TelegramLongPollingBot {

    private String messageToSent;

    public JenkinsTelegramBot(String messageToSent) {
        this.messageToSent = messageToSent;
    }

    @Override
    public String getBotUsername() {
        return "Diploma_jenkins_bot";
    }

    @Override
    public String getBotToken() {
        return "5690759701:AAGdkusHaefgegcohwymgCHz1TgF47SyEug";
    }


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            long chatId = update
                    .getMessage()
                    .getChatId();

            SendMessage message = new SendMessage();
            message.setChatId(chatId);
            message.setText(messageToSent);

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);

        try {
            botsApi.registerBot(new JenkinsTelegramBot("lol"));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
