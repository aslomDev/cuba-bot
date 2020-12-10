package com.company.bot.service;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

public interface TgUserService {
    String NAME = "bot_TgUserService";


    void createUserTg(long id);

}