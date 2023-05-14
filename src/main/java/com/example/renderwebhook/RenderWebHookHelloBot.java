package com.example.renderwebhook;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.starter.SpringWebhookBot;

@Component
public class RenderWebHookHelloBot extends SpringWebhookBot {

    // https://api.telegram.org/bot5887516482:AAEK4-rA4iHp-966sw4D2eQKA1NxiMfMNqk/setWebhook?url=https://b96f-45-134-212-34.eu.ngrok.io

    public RenderWebHookHelloBot() {
        super(
                SetWebhook.builder().url("https://1a07-151-249-131-14.eu.ngrok.io").build(),
        "5887516482:AAEK4-rA4iHp-966sw4D2eQKA1NxiMfMNqk");
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        System.out.println(update);
        return new SendMessage(update.getMessage().getChatId().toString(), "Hello dod!");
    }

    @Override
    public String getBotPath() {
        return "https://1a07-151-249-131-14.eu.ngrok.io";
    }

    @Override
    public String getBotUsername() {
        return "RenderHelloBot";
    }
}
