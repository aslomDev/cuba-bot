package com.company.bot.entity.tgBot.telegram.commands.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import com.company.bot.entity.tgBot.Utils;
import com.company.bot.entity.tgBot.telegram.Bot;
import com.company.bot.entity.tgBot.telegram.nonCommand.Settings;

/**
 * Команда получения текущих настроек
 */
public class SettingsCommand extends ServiceCommand {
    private Logger logger = LoggerFactory.getLogger(SettingsCommand.class);

    public SettingsCommand(String identifier, String description) {
        super(identifier, description);
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        String userName = Utils.getUserName(user);

        logger.debug(String.format("Пользователь %s. Начато выполнение команды %s", userName,
                this.getCommandIdentifier()));

        Long chatId = chat.getId();
        Settings settings = Bot.getUserSettings(chatId);
        sendAnswer(absSender, chatId, this.getCommandIdentifier(), userName,
                String.format("*Текущие настройки*\n" +
                                "- минимальное число, использующееся в заданиях - *%s*\n" +
                                "- максимальное число, использующееся в заданиях - *%s*\n" +
                                "- число страниц итогового файла - *%s*\n\n" +
                                "Если Вы хотите изменить эти параметры, введите через пробел или запятую 3 числа - " +
                                "минимальное число, максимальное число и количество страниц в файле (не более 10)\n\n" +
                                "\uD83D\uDC49 Например, 3,15,6 или 4 17 3",
                        settings.getMin(), settings.getMax(), settings.getListCount()));

        logger.debug(String.format("Пользователь %s. Завершено выполнение команды %s", userName,
                this.getCommandIdentifier()));
    }
}