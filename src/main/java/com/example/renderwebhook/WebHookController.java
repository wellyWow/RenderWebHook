package com.example.renderwebhook;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
public class WebHookController {

    private final RenderWebHookHelloBot renderWebHookHelloBot;

    public WebHookController(RenderWebHookHelloBot renderWebHookHelloBot) {
        this.renderWebHookHelloBot = renderWebHookHelloBot;
    }

    @PostMapping("/")
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        return renderWebHookHelloBot.onWebhookUpdateReceived(update);
    }
}
