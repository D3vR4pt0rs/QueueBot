import Settings.Bot;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.telegram.telegrambots.ApiContext;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Main {

    private static String PROXY_HOST = "185.93.3.123";
    private static Integer PROXY_PORT = 8080;

    public static void main(String[] args) {
        try {

            ApiContextInitializer.init();


            TelegramBotsApi botsApi = new TelegramBotsApi();

            DefaultBotOptions botOptions = ApiContext.getInstance(DefaultBotOptions.class);

            HttpHost httpHost = new HttpHost(PROXY_HOST, PROXY_PORT);

            RequestConfig requestConfig = RequestConfig.custom().setProxy(httpHost).setAuthenticationEnabled(false).build();
            botOptions.setRequestConfig(requestConfig);

            Bot bot = new Bot(botOptions);

            botsApi.registerBot(bot);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}
