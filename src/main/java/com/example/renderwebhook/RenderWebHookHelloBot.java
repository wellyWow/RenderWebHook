package com.example.renderwebhook;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.starter.SpringWebhookBot;

@Component
public class RenderWebHookHelloBot extends SpringWebhookBot {

    private final TelegramConfig telegramConfig;

    // https://api.telegram.org/bot5887516482:AAEK4-rA4iHp-966sw4D2eQKA1NxiMfMNqk/setWebhook?url=https://0ffd-45-134-212-34.eu.ngrok.io

    public RenderWebHookHelloBot(TelegramConfig telegramConfig) {
        super(
                SetWebhook.builder().url(telegramConfig.getPath()).build(),
                telegramConfig.getBotToken());
        this.telegramConfig = telegramConfig;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        System.out.println(update);
        return SendMessage.builder()
                .chatId(update.getMessage().getChatId())
                .text("Hello dod!").build();
    }

    @Override
    public String getBotPath() {
        return telegramConfig.getPath();
    }

    @Override
    public String getBotUsername() {
        return telegramConfig.getUsername();
    }
}
