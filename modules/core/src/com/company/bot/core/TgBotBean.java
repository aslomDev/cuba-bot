package com.company.bot.core;

import com.company.bot.entity.tgBot.telegram.Bot;
import com.haulmont.cuba.core.global.Events;
import com.haulmont.cuba.core.sys.AppContext;
import com.haulmont.cuba.core.sys.events.AppContextInitializedEvent;
import com.haulmont.cuba.core.sys.events.AppContextStartedEvent;
import com.haulmont.cuba.core.sys.events.AppContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

@Component(TgBotBean.NAME)
public class TgBotBean {
    public static final String NAME = "bot_TgBotBean";

    private static final Map<String, String> getenv = System.getenv();

    @EventListener(AppContextInitializedEvent.class)



    @Order(Events.LOWEST_PLATFORM_PRECEDENCE + 100)
    protected void appInitialized() {
        System.out.println("Initialized");
    }

    // event type is defined by method parameter
    @EventListener
    protected void appStarted(AppContextStartedEvent event) {


        try {

            AppContext.isStarted();
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new Bot("lolMessageBot", "1487031714:AAGGW29Lvqkx-zpP2HydHU47KMZkg8d07v0"));
        } catch (TelegramApiException e) {
//            Logger.error("TelegramApiException " + e.getMessage(), e);
            e.printStackTrace();
        }
    }

    @EventListener
    protected void appStopped(AppContextStoppedEvent event) {
        System.out.println("Stopped");
    }

}